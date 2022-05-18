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
    
    public Periode() {
        start();
    }
    
    public Periode(String libelle) {
        this.fin = new Date();
        this.libelle = libelle;
    }
    
    public void end() {
        this.fin = new Date();
    }
    
    public void start() {
        this.debut = new Date();
    }
    
    /* getters et setters */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
            if (eval.getEnseignement().equals(enseignement)) {
                listeEval.add(eval);
            }
        }
        return listeEval;
    }
    
    /* vérifie si la somme des poids fait bien 1 */
    public boolean checkWeights(Eleve e, Enseignement ens) {
        float poids = 0;
        for(Evaluation eval: getEvaluationByEnseignement(e, ens)) {
            System.out.println(eval.getType());
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
                System.out.println("La moyenne: " + eval.getNote());
                nbEval ++;
            }
            return moyenne;
        }
        else {
            System.out.println("Attention au poids: Différent de 1!");
        }
        return -1;
    }
    
    /* avoir la moyenne générale pour la période */
    public float moyenne(Eleve e) {
        float moyenne = 0;
        for(Enseignement ens: e.getEnseignements()) {
            moyenne += moyenne(e, ens);
        }
        return moyenne;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.debut);
        hash = 41 * hash + Objects.hashCode(this.fin);
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
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.debut, other.debut)) {
            return false;
        }
        return Objects.equals(this.fin, other.fin);
    }
    
}
