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
    public void evalEachOnTeaching(List<Eleve> listeEleve, Enseignement ens) {
        Evaluation eval;
        Note note;
        Scanner scan =;
        for(Eleve e: listeEleve) {
            System.out.println("Entrez la note pour [" + e.getPersonalInfo() + "]: ");
        }
        
    }
}
