/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.util.Scanner;

/**
 *
 * @author junior
 */
public class Menu {
    public Menu() {
        
    }
    
    public static void main(String[] argv) {
        System.out.println("BIENVENUE DANS LE PROGRAMME DE GESTION DE NOTES");
        System.out.println("Note: Ceci est un menu interactif. Faites votre choix en choisissant seulement un numéro");
        
        System.out.println("1. Lister les élèves");
        System.out.println("2. Lister les enseignants");
        System.out.println("3. Lister les enseignements");
        System.out.println("4. Lister les classes de l'établissement");
        System.out.println("5. Ajouter un nouveau");
        System.out.println("6. Faire une évaluation");
        System.out.println("7. Afficher les résultats");
    }
    
    public void sousMenuAjouterPersonnage() {
        System.out.printf("%10s", "1. Ajouter un élève");
        System.out.printf("%10s", "2. Ajouter un enseignant");
    }
    
    public void menuEvaluation() {
        do {
            System.out.printf("%10s", "2. Ajouter un élève");
        }
        while(true);
    }
}
