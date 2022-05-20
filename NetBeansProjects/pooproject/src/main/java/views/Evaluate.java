/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.util.List;
import models.*;
import java.util.Scanner;

/**
 *
 * @author junior
 */
public class Evaluate {
    
    public Evaluate() {
        setParamsForEval();
    }
    
    public Classe chooseClasse(){
        Scanner scan = new Scanner(System.in);
        int code;
        String label;
        System.out.println("Dans quelle classee voulez-vous faire l'évaluation ?: ");
        System.out.println(">>>> Entrez le code de la classe: ");
        code = scan.nextInt();
        System.out.println(">>>> Entrez le label de la classe: ");
        label = scan.next();
        return Classe.getClasse(label,code);
    }
    
    public Cours chooseCours(Classe classe) {
        Scanner scan = new Scanner(System.in);
        List<Cours> listeCours = classe.getCours();
        int code;
        if (listeCours != null) {
            System.out.println("Choisissez un Cours dans la liste avec son code en crochets:");
            for(Cours c: listeCours) {
                System.out.println(c.getInfo());
            }

            System.out.println(">>>> Votre choix: ");
            code = scan.nextInt();
            return Cours.getCours(code);
        }
        System.out.println("\033[91mAttention! Pas encore de cours dans cette classe!\033[0m");
        return null;
    }
    
    public void setParamsForEval() {
        Classe classe;
        Periode p;
        Cours c;
        Scanner scan = new Scanner(System.in);
        String type, periode;
        System.out.println("Type d'évaluation: ");
        type = scan.next();
        classe = chooseClasse();
        System.out.println("Classe: " + classe.getLibelle());
        c = chooseCours(classe);
        System.out.println("Dans quelle période êtes-vous ?: ");
        periode = scan.next();
        p = new Periode(periode);
        System.out.println("");
        System.out.println(">>>> " + c.getInfo() + " <<<<");
        evalEachOnTeaching(classe.getEleves(), c.getEnseignement(), c, p, type);
    }
    
    public void evalEachOnTeaching(List<Eleve> listeEleve, Enseignement ens, Cours cours, Periode periode, String type) {
        Evaluation eval;
        Note note;
        float value, poids;
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le poids de l'évaluation: ");
        poids = scan.nextFloat();
        System.out.println("Notes pour L'évaluation en " + cours.getLibelle() + ":");
        for(Eleve e: listeEleve) {
            System.out.println("Entrez la note pour [" + e.getPersonalInfo() + "]: ");
            value = scan.nextFloat();
            eval = new Evaluation(type, poids, ens, cours, periode);
            note = new Note(e, eval, value);
        }
        
        System.out.printf("\033[92mSUCCESS\033[0m\n");
        
    }
}
