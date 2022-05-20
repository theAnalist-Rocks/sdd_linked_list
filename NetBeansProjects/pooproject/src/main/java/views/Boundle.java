/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.util.Scanner;
import models.*;

/**
 *
 * @author junior
 */
public class Boundle {
    
    public Boundle() {
        mainMenu();
    }
    
    public void mainMenu() {
        int choice, choiceIn;
        String exit, exitIn;
        Scanner scan = new Scanner(System.in);
        
        do {
            
            do {
            System.out.printf("%3d - %20s\n", 1, "Menu élève");
            System.out.printf("%3d - %20s\n", 2, "Menu enseignants");
            System.out.printf("%3d - %20s\n", 3, "Menu des classes");
            System.out.printf("%3d - %20s\n", 4, "Quitter");
            System.out.println("Votre choix: ");
            choice = scan.nextInt();
            
            }while(choice<1 && choice>4);
            switch(choice) {
                case 1:
                    System.out.printf("%10d - %20s\n",1, "Créer un élève");
                    System.out.printf("%10d - %20s\n", 2, "Supprimer un élève");
                    System.out.printf("%10d - %20s\n", 3, "Bulletin pour un élève");
                    System.out.printf("%10d - %20s\n", 4, "Afficher tout");
                    choiceIn = scan.nextInt();
                    
                     switch(choiceIn) {
                        case 1:
                            System.out.println("Ouverture de la ligne de commande interactive ...\n\n");
                            new EleveView().createView();
                            break;
                            
                        case 2:
                            System.out.println("Not ready yet!");
                            break;
                            
                        case 3:
                            System.out.println("Liste des élèves de la classe de 6e A par défaut");
                            EleveView view = new EleveView();
                            Periode p;
                            int cardId;
                            String periode;
                            
                            
                            view.showAll();
                            System.out.println("Quel élève avez-vous choisi ?(Choisir juste le numéro de carte): ");
                            cardId = scan.nextInt();
                            Eleve eleve = view.selectEleve(cardId);
                            System.out.println("Bulletin pour la période: ");
                            periode = scan.next();
                            p = Periode.getPeriode(periode);
                            new EleveReleveView(eleve.getClasse(), p);
                            break;
                            
                        case 4:
                            new EleveView().showAll();
                            break;
                    }
                 break;
                     
                case 2:
                    System.out.printf("%10d - %20s\n", 1, "Créer un enseignant");
                    System.out.printf("%10d - %20s\n", 2, "Supprimer un enseignant");
                    System.out.printf("%10d - %20s\n", 3, "Afficher tout");
                    choiceIn = scan.nextInt();
                    
                    switch(choiceIn) {
                        case 1:
                            System.out.println("Not ready yet!");
                            break;
                        case 2:
                            System.out.println("Not ready yet!");
                            break;
                        case 3:
                            System.out.println("Not ready yet!");
                            break;
                    }
                break;
                
                case 3:
                    System.out.printf("%10d - %20s\n", 1, "Créer une classe");
                    System.out.printf("%10d - %20s\n", 2, "Supprimer une classe");
                    System.out.printf("%10d - %20s\n", 3, "Faire une évaluation");
                    System.out.printf("%10d - %20s\n",4 , "Afficher tout");
                    choiceIn = scan.nextInt();
                    
                    switch(choiceIn) {
                        case 1:
                            System.out.println("Not ready yet!");
                            break;
                        case 2:
                            System.out.println("Not ready yet!");
                            break;
                        case 3:
                            System.out.println("Ouverture de la ligne de commande interactive ...\n\n");
                            new Evaluate();
                            break;
                        case 4:
                            System.out.println("Not ready yet!");
                    }
            }
            
            System.out.println("Quitter ?: ");
         exit = scan.next();
        }while("n".equals(exit));
    }
}
