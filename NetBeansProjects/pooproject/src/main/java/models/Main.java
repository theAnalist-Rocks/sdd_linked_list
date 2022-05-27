/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
/**
 *
 * @author junior
 */
public class Main {
    
    public Main() {
        warmUp();
    }
    
    public void warmUp() {
        
        Enseignant prof1 = new Enseignant("Akakpo", "Floyd", 37, (float) 1.2);
        Eleve eleve = new Eleve("Akakpo", "Hamede", 17);
        Niveau niveau = Niveau.get(6);
        
        Matiere matiere = Matiere.getMatiere("Maths");
        Matiere matiere2 = Matiere.getMatiere("Anglais");
        Matiere matiere3 = Matiere.getMatiere("Histoire");
        Matiere matiere4 = Matiere.getMatiere("Physiques");
        Matiere matiere5 = Matiere.getMatiere("Géographie");
        Matiere matiere6 = Matiere.getMatiere("Français");
        Matiere matiere7 = Matiere.getMatiere("Chimie");
        
        
        Enseignement enseignement = new Enseignement(niveau, matiere, 3);
        Enseignement enseignement2 = new Enseignement(niveau, matiere2, 2);
        Enseignement enseignement3 = new Enseignement(niveau, matiere3, 2);
        Enseignement enseignement4 = new Enseignement(niveau, matiere4, 3);
        Enseignement enseignement5 = new Enseignement(niveau, matiere5, 2);
        Enseignement enseignement6 = new Enseignement(niveau, matiere6, 2);
        Enseignement enseignement7 = new Enseignement(niveau, matiere7, 3);
        
        
        Classe classe = Classe.getClasse("A", 6);
        Cours cours = new Cours(prof1, enseignement, classe);
        Cours cours2 = new Cours(prof1, enseignement2, classe);
        Evaluation eva = new Evaluation();
        Periode p = new Periode("PremierTrimestre");
        
        classe.addCours(cours);
        classe.addCours(cours2);
        classe.addEleve(eleve);
        classe.addEleve(new Eleve("ADENYO", "Junior", 19));
        classe.addEleve(new Eleve("ADENYO", "Michel", 19));
        classe.addEleve(new Eleve("NAYO", "Philipe", 19));
        /*classe.addEleve(new Eleve("AMEGANVI", "Philomène", 19));
        classe.addEleve(new Eleve("YOVO", "Amèvi", 19));
        classe.addEleve(new Eleve("KOMBEDE", "Magloire", 19));
        classe.addEleve(new Eleve("MITCHUM", "Michelle", 19));
        classe.addEleve(new Eleve("KRUGENSTEIN", "Yvone", 20));
        classe.addEleve(new Eleve("BENISSAN-ADODJISSI", "Winner", 19));
        classe.addEleve(new Eleve("ATTITSOGBE", "Daniel", 19));
        classe.addEleve(new Eleve("ATTITSO", "Emilie", 19));
        classe.addEleve(new Eleve("AGBOVI", "Rodolphe", 20));
        classe.addEleve(new Eleve("NAYO", "Philipine", 19));
        classe.addEleve(new Eleve("OURO-BANGN'A", "Ridoine", 19));
        classe.addEleve(new Eleve("AGBEKOSSI", "Junior", 19));
        classe.addEleve(new Eleve("WILSON", "Joseph", 19));*/
        
        /*Evaluation eval = new Evaluation("Devoir - Angalais 1", (float) 0.4, enseignement2, cours2, p);
        Evaluation eval2 = new Evaluation("Examen - Angalais 2", (float) 0.6, enseignement2, cours2, p);
        
        Evaluation evalMaths = new Evaluation("Devoir - Maths 1", (float) 0.4, enseignement, cours, p);
        Evaluation evalMaths2 = new Evaluation("Examen - Maths 2", (float) 0.6, enseignement, cours, p);
        
        
        Note note1math = new Note(eleve, evalMaths2, 15);
        Note note2Amth = new Note(eleve, evalMaths, 20);
        Note note1Ang = new Note(eleve, eval, 10);
        Note note2Ang = new Note(eleve, eval2, 20);*/
        
    }
    
    /* public static void main(String[] args) {
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
        
        classe.addCours(cours);
        classe.addCours(cours2);
        classe.addEleve(eleve);
        
        
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
        /*Cours.showAll();
        System.out.println("Liste des évaluations en Maths: \n");
        System.out.println(p.getEvaluationByEnseignement(eleve, enseignement));
                
        System.out.println("La moyenne en Maths de Hamede:\n");
        System.out.println(p.moyenne(eleve, enseignement));
        System.out.println("Moyenne de Hamede:");
        System.out.println(p.moyenne(eleve));
        
    }*/
    
}
