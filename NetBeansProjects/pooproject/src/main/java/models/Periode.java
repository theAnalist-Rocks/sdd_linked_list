package models;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
// import java.util.concurrent.TimeUnit;

/**
 *
 * @author junior
 */
public class Periode {
    public String libelle;
    public Date debut;
    public Date fin;
    public static List<Periode> listeDesPeriodes = new ArrayList<>();
    
    public Periode() {
        start();
        listeDesPeriodes.add(this);
    }
    
    public Periode(String libelle) {
        this.fin = new Date();
        this.libelle = libelle;
        listeDesPeriodes.add(this);
    }
    
    public void end() {
        this.fin = new Date();
    }
    
    public void start() {
        this.debut = new Date();
    }
    
    public static void add(Periode p) {
        listeDesPeriodes.add(p);
    }
    
    public static void add(String libelle) {
        listeDesPeriodes.add(new Periode(libelle));
    }
    
    public static void remove(Periode p) {
        listeDesPeriodes.remove(p);
    }
    
    public static Periode getPeriode(String libelle) {
        for(Periode p: listeDesPeriodes) {
            if(p.libelle.equals(libelle)) 
                return p;
        }
        return null;
    }
    
    /* liste des évaluations à la période */
    public List<Evaluation> getEvaluation(Eleve e) {
        List<Evaluation> listeEval = new ArrayList<>();
        for(Evaluation eval: e.getEvaluation()) {
            if(eval.getPeriode().equals(this)) {
                listeEval.add(eval);
            }
        }
        return listeEval;
    }
    
    /* liste des évaluations à la période courrante pour un esneignement */
    public List<Evaluation> getEvaluationByEnseignement(Eleve e, Enseignement enseignement) {
        List<Evaluation> listeEval = new ArrayList<>();
        for(Evaluation eval: e.getEvaluation()) {
            //System.out.println(eval.getType() + " - Periode: " + this.libelle + eval.getPeriode().libelle);
            if (eval.getEnseignement().equals(enseignement) && eval.getPeriode().equals(this)) {
                listeEval.add(eval);
            }
        }
        return listeEval;
    }
    
    /* vérifie si la somme des poids fait bien 1 */
    public boolean checkWeights(Eleve e, Enseignement ens) {
        float poids = 0;
        for(Evaluation eval: getEvaluationByEnseignement(e, ens)) {
            //System.out.println(eval.getType());
            poids += eval.getBareme();
        }
        return poids == 1;
    }
    
    /* moyenne dans un enseignement à une période donnée */
    public float moyenne(Eleve e, Enseignement ens) {
        float moyenne = 0;
        int nbEval = 0;
        if(checkWeights(e, ens)) {
            for(Evaluation eval: getEvaluationByEnseignement(e, ens)) {
                moyenne += eval.getNote().getValue() * eval.getBareme();
                //System.out.println("La note obtenue: " + eval.getNote().getValue() + "/" + ens.getCoefficient()*20);
                nbEval ++;
            }
            /* on le ramène sur 20 */
            return moyenne / ens.getCoefficient();
        }
        else {
            System.out.println("Attention au poids: Différent de 1!");
        }
        return -1;
    }
    
    /* avoir la moyenne générale pour la période */
    public float moyenne(Eleve e) {
        float moyenne = 0;
        int nbEnseignements = 0;
        for(Enseignement ens: e.getEnseignements()) {
            moyenne += moyenne(e, ens);
            nbEnseignements ++;
        }
        return moyenne / nbEnseignements;
    }
    
    /* getters et setters */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.libelle);
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
        final Periode other = (Periode) obj;
        return Objects.equals(this.libelle, other.libelle);
    }
    
}
