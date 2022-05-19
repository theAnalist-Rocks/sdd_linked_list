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
    public Classe getClasse() {
        Scanner scan = new Scanner(System.in);
        int code;
        String label;
        System.out.println("Entrez le code de la classe: ");
        code = scan.nextInt();
        System.out.println("Entrez le label de la classe: ");
        label = scan.next();
        return Classe.getClasse(label, code);
    }
}
