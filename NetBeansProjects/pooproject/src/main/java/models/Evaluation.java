/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author junior
 */
public class Evaluation {
    private Cours cours;
    private Periode period;
    private float bareme; /* suivant le poids de l'évaluation  ... */
    private Date date;
    private String type;
    private Enseignement enseignement;
    private Note note;
    private TypeEvaluation typeEvaluation;
    private static List<Evaluation> listeEvaluations = new ArrayList<>();
    private static List<TypeEvaluation> listeTypeEvaluation;
    
    static {
        listeTypeEvaluation = TypeEvaluation.getListe();
    }
    
    public Evaluation() {
        
    }
    
    public Evaluation(String type, float bareme, Enseignement enseignement, Cours cours, Periode periode) {
        this.date = new Date();
        this.cours = cours;
        this.enseignement = enseignement;
        this.period = periode;
        this.bareme = bareme;
        this.type = type;
    }
    
    /* pour une évaluation dont on ne précise pas le barème alors on supposera que ce barème correspond au cœfficient */
    public Evaluation(String type, Enseignement enseignement, Cours cours, Periode periode) {
        this.date = new Date();
        this.bareme = enseignement.getCoefficient();
        this.cours = cours;
        this.enseignement = enseignement;
        this.period = periode;
        add(this);
    }
    
    public static void add(Evaluation e) {
        listeEvaluations.add(e);
    }
    
    /*getters et setter*/
    public Enseignant getEnseignant() {
        return this.cours.enseignant;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    public void setPeriode(Periode periode) {
        this.period = periode;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setTypeEvaluation(TypeEvaluation tEva) {
        this.typeEvaluation = tEva;
    }
    
    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    } 
    
    public void setBareme(float bareme) {
        this.bareme = bareme;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public Enseignement getEnseignement() {
        return this.enseignement;
    }
    
    public String getType() {
        return this.type;
    }
    
    public float getBareme() {
        return this.bareme;
    }
    
    public Cours getCours() {
        return this.cours;
    }
    
    public Periode getPeriode(){
        return this.period;
    }
    
    public void setNote(Note note) {
        this.note = note;
    }
    
    public Note getNote() {
        return this.note;
    }
    
    public TypeEvaluation getTypeEvaluation() {
        return typeEvaluation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Float.floatToIntBits(this.bareme);
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evaluation other = (Evaluation) obj;
        if (Float.floatToIntBits(this.bareme) != Float.floatToIntBits(other.bareme)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.cours, other.cours)) {
            return false;
        }
        if (!Objects.equals(this.period, other.period)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.enseignement, other.enseignement)) {
            return false;
        }
        return Objects.equals(this.note, other.note);
    }
    
    @Override
    public String toString() {
        return getType();
    }
}
