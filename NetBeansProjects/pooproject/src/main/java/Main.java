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
        Matiere matiere2 = Matiere.getMatiere("Anglais");
        Enseignement enseignement = new Enseignement(niveau, matiere, 3);
        Enseignement enseignement2 = new Enseignement(niveau, matiere2, 3);
        Classe classe = Classe.getClasse("A", 6);
        Cours cours = new Cours(prof1, enseignement, classe);
        Cours cours2 = new Cours(prof1, enseignement2, classe);
        Evaluation eva = new Evaluation();
        Periode p = new Periode("Trimestre 1");
        
        
        Evaluation eval = new Evaluation("Test - Angalais 1", (float) 0.3, enseignement2, cours2, p);
        Evaluation eval2 = new Evaluation("Test - Angalais 2", (float) 0.3, enseignement2, cours2, p);
        Evaluation eval3 = new Evaluation("Test - Angalais 3", (float) 0.4, enseignement2, cours2, p);
        Evaluation evalMaths = new Evaluation("Test - Maths 1", (float) 0.4, enseignement, cours, p);
        Evaluation evalMaths2 = new Evaluation("Test - Maths 2", (float) 0.6, enseignement, cours, p);
        
        
        Note note1math = new Note(eleve, evalMaths2, 15);
        Note note2Amth = new Note(eleve, evalMaths, 20);
        Note note1Ang = new Note(eleve, eval, 10);
        Note note2Ang = new Note(eleve, eval2, 20);
        Note note3Ang = new Note(eleve, eval3, 15);
        
        
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
        System.out.println("Liste des évaluations en Maths: \n");
        System.out.println(p.getEvaluationByEnseignement(eleve, enseignement));
                
        System.out.println("La moyenne en Maths de Hamede:\n");
        System.out.println(p.moyenne(eleve, enseignement));
        
    }
    
}
