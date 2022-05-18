/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author junior
 */
public class Enseignant extends Personne {
    
    public static final List<Enseignant> listeEnseignants = new ArrayList<>(); // liste de tous les enseignants de l'école
    /* un enseignant peut enseigner dans plusieurs classes plusieurs cours */
    private int idCard;
    public final List<Cours> listeCours = new ArrayList<>();
    public final List<Evaluation> listeEvaluation = new ArrayList<>();  
    private float baseSalary;
    
    static {
        addEnseignant("HOETOWOU", "Yaovi", 27, (float)1.4);
        addEnseignant("HOETOWOU", "Yao", 27, (float)1.4);
        addEnseignant("ADENYO", "Yaovi", 23, (float)1.4);
        addEnseignant("KOFFIVI", "Yaogan", 27, (float)1.4);
        addEnseignant("PORCHER", "Ryan", 22, (float)1.3);
        addEnseignant("PORCHER", "Bryan", 22, (float)1.3);
        addEnseignant("DELAPORTE", "Pierre", 22, (float)1.3);
        addEnseignant("DUVALEY", "Roger", 25, (float)1.7);
        addEnseignant("AKOUME", "Sans-sauce", 22, (float)1.3);
        addEnseignant("LEBOULANGER", "Expert", 19, (float)2.5);
    }
    
    public Enseignant() {
        this.idCard = new Random().nextInt(10000000);
        addEnseignant(this);
    }
    
    public Enseignant(String nom, String prenom, int age, float base) {
        this.idCard = new Random().nextInt(10000000);
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.baseSalary = base;
        /*addEnseignant(this);*/
    }
    
    public void setIdCard(int id) {
        this.idCard = id;
    }
    
    public void setSalaryBase(float base) {
        this.baseSalary = base;
    }
    
    public void addCours(Cours cours) {
        this.listeCours.add(cours);
    }
    
    public void addEvaluation(Evaluation e) {
        this.listeEvaluation.add(e);
    }
    
    public static void removeEnseignant(Enseignant e) {
        listeEnseignants.remove(e);
    }

    
    public static void addEnseignant(Enseignant enseignant) {
        listeEnseignants.add(enseignant);
    }
    
    public static void addEnseignant(String nom, String prenom, int age, float base) {
        addEnseignant(new Enseignant(nom, prenom, age, base));
    }
    
    /* setters et getters */
    
    public static Enseignant getEnseigenant(Enseignant enseignant) {
        for(Enseignant e: listeEnseignants) {
            if (e.idCard == enseignant.idCard) {
                return e;
            }
        }
        return null;
    }
    
    public static Enseignant getEnseignant(int code) {
        for(Enseignant e: listeEnseignants) {
            if(e.idCard == code) {
                return e;
            }
        }
        return null;
    }
    
    public int getIdCard() {
        return this.idCard;
    }
    
    public void getCours() {
        for(Cours _cours: listeCours) {
            System.out.println(_cours.classe.getLibelle() + ' ' + _cours.enseignement.getLibelle());
        }
    }
    
    public void getInfo(char complete) {
        if (complete == 'Y') {
            System.out.println(this.nom + ' ' + this.prenom + " Intervient dans:");
            this.getCours();
        }
        
        else {
            System.out.println(this.nom + ' ' + this.prenom);
        }
    }
    
    public static void showAll() {
        for(Enseignant ens: listeEnseignants) {
            System.out.println(ens);
        }
    }
    
    public float getSalaray(int base) {
        return this.baseSalary * base;
    }
    
    @Override
    public String toString() {
        return this.nom + " " + this.prenom;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idCard;
        hash = 23 * hash + Objects.hashCode(this.listeCours);
        hash = 23 * hash + Float.floatToIntBits(this.baseSalary);
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
        final Enseignant other = (Enseignant) obj;
        return this.idCard == other.idCard;
    }

}
