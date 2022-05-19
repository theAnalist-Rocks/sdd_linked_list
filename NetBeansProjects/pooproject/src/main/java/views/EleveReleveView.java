/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import models.*;

/**
 *
 * @author junior
 */
public final class EleveReleveView {
    
    public EleveReleveView(Classe c, Periode p) {
        getReleve(c, p);
    }
    
    public void getReleve(Classe c, Periode p) {
        System.out.println("Classe : " + c);
        for(Eleve e: c.getEleves()) {
            getReleve(e, p);
        }
    }
    
    public void getReleve(Eleve e, Periode p) {
        System.out.println("BULLETIN DE NOTES DE " + e.getPersonalInfo() + " en classe de " + e.getClasse().toString() + " Période:" + p.libelle);
        System.out.println("Les cours de l'élève: "  + e.getCours());
        for(Cours c: e.getCours()) {
            if (c != null) {
                System.out.printf("%15s :", c.getEnseignement().getMatiere());
                for(Evaluation eval: p.getEvaluationByEnseignement(e, c.getEnseignement())) {
                    System.out.printf(" %10.2f", eval.getNote().getValue());
                }
                System.out.println("\n");
            }
        }
    }
    
}
