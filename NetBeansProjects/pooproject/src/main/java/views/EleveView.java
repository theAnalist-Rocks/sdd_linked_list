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
public class EleveView {
    public EleveView() {
        
    }
    
    
    public void setClasse(Classe c, Eleve e) {
        c.addEleve(e);
    }
    
    public Eleve selectEleve(int code) {
        return Eleve.getEleve(code);
    }
    
    public void showAll() {
        int i = 0;
        for(Eleve e: Eleve.getList()) {
            System.out.println(i++ + " - " + e.getPersonalInfo() + "[" + e.getIdCard() + "]");
        }
    }
    
    public void createView() {
        String nom, prenom;
        int age;
        Scanner scan = new Scanner(System.in);
        System.out.println("MENU DE CRÉATION D'ÉLÈVE");
        Eleve eleve;
        System.out.println("Entrez le nom: ");
        nom = scan.next();
        System.out.println("Entrez le prenom: ");
        prenom = scan.next();
        System.out.println("Entrez l'âge: ");
        age = scan.nextInt();
        eleve = new Eleve(nom, prenom, age);     
    }
}
