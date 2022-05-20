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
        System.out.println("\n\n        ###################################");
        System.out.println("        ######## BULLETIN DE NOTES ########");
        System.out.println("        ###################################\n\n");
        System.out.println("=============================================");
        System.out.printf("NOM: %17s \nClasse: %17s\nPériode: %17s",e.getPersonalInfo(),e.getClasse().toString(), p.libelle +'\n');
        
        System.out.println("=============================================");
        System.out.printf("%10s %15s %15s\n\n", "MATIERE", "DEVOIR", "EXAMEN");
        for(Cours c: e.getCours()) {
            if (c != null) {
                System.out.printf("%10s:", c.getEnseignement().getMatiere());
                for(Evaluation eval: p.getEvaluationByEnseignement(e, c.getEnseignement())) {
                    System.out.printf("%15.2f", eval.getNote().getValue());
                }
                System.out.println("\n");
            }
        }
        System.out.printf("%10s %30.2f\n", "MOYENNE", p.moyenne(e));
    }
}
