/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;

/**
 *
 * @author junior
 */
public class Evaluation {
    private Cours cours;
    private Periode period;
    private float bareme; /* si sur 5 alors 1/2, si sur 10 alors 1, si sur 20 alors 2 ... etc ... */
    private Date date;
    private String type;
    private Enseignement enseignement;
    
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
    
}
