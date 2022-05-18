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
    
    /*
        @method Parcourir les types d'évaluations disponibles dans Evaluation
                Et pour chaque type, vérifier que la somme des poids fait 1, faire la moyenne
    */
    
    /* obtenir la liste des évaluations à partir de la période */
    public List<Evaluation> getEvaluationByPeriod(Eleve e) {
        List<Evaluation> listeEvaluations = new ArrayList<>();
        for(Evaluation eva: e.getEvaluation()) {
            if(eva.getPeriode().equals(this))
            listeEvaluations.add(eva);
        }
        return listeEvaluations;
    }
    
    /* on choisit les évaluations par type */
    public List<Evaluation> getEvaluationByType(Eleve e, TypeEvaluation typeEval) {
        List<Evaluation> listeDesEvaluations = getEvaluationByPeriod(e);
        List<Evaluation> listeDesEvaluationsParType = new ArrayList<>();
        
        for(Evaluation eval: listeDesEvaluations) {
            if (eval.getTypeEvaluation().equals(typeEval)) {
                listeDesEvaluationsParType.add(eval);
            }
        }
        return listeDesEvaluationsParType;
    }
    
    /* ce sont ici des Evaluations de même type */
    public float mean(List<Evaluation> listeEval, float poidsUnitaire) {
        float poids = 0, sum = 0;
        for(Evaluation eval: listeEval) {
            sum += eval.getNote().getValue();
            poids += poidsUnitaire;
        }
        if (poids != 1.0) {
            System.out.printf("Une erreur s'est produite: \033[91;1mLa somme des poids diffère de \033[0m");
            return -1;
        }
        return sum/listeEval.size();
    }
    
    public void getMoyenne(Eleve e) {
        float mean_ = 0;
        for(TypeEvaluation typeEval: TypeEvaluation.listeTypeEvaluation) {
            List<Evaluation> listeTypeEval = getEvaluationByType(e, typeEval);
            mean_ += mean(listeTypeEval, typeEval.getPoids());
        }
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
