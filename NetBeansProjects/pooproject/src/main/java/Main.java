/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author junior
 */
public class Main {
    
    public static void main(String[] args) {
        Enseignant prof1 = new Enseignant("Akakpo", "Floyd", 37, (float) 1.2);
        Eleve eleve = new Eleve("Akakpo", "Hamede", 17);
        Niveau niveau = Niveau.get(6);
        Matiere matiere = Matiere.getMatiere("Maths");
        Matiere matiere2 = Matiere.getMatiere("Chimie");
        Enseignement enseignement = new Enseignement(niveau, matiere, 3);
        Enseignement enseignement2 = new Enseignement(niveau, matiere2, 3);
        Classe classe = Classe.getClasse("A", 6);
        Cours cours = new Cours(prof1, enseignement, classe);
        Cours cours2 = new Cours(prof1, enseignement2, classe);
        
        System.out.println("Cours2: " + cours2.getLibelle());
        /*System.out.println(classe);
        System.out.println("Liste des enseignants:");
        /*marche/Enseignant.showAll();
        System.out.println("Liste des enseignements:");
        /*marche/Enseignement.showAll();
        
        /*System.out.println();
        classe.addEleve(eleve);
        prof1.addCours(cours);
        eleve.addCours(enseignement, prof1);
        /*marcheprof1.getInfo('n');
        /*marcheprof1.getInfo('Y');
        /*marcheclasse.getEleve();
        
        System.out.println("Liste des Matières:");
        Matiere.showAll();
        System.out.println("Liste des Cours dans l\'établissement");*/
        Cours.showAll();
        
    }
    
}
