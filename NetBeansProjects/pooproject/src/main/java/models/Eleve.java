/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author junior
 * @problems pas encore de methodes equal et hashCode
 */
public class Eleve extends Personne {
    /* dès qu'un élève est dans une classe, il est inscrit dans tous les cours de cette classe 
    mais il peut décider de suivre par lui-mêe d'autres cours */
    private static List<Eleve> listeDesEleve = new ArrayList<>();
    private int idCard;
    protected Classe classe; /* un élève ne eput être que dans une classe */
    private List<Cours> listeDesCours = new ArrayList<>();
    private List<Evaluation> listeDesEvaluations = new ArrayList<>();
    private List<Note> listeDesNotes = new ArrayList<>();

    public Eleve() {
        this.idCard = new Random().nextInt(10000000);
    }
    
    public Eleve(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.idCard = new Random().nextInt(1000000);
        add(this);
    }
    
    public Eleve(String nom, String prenom, int age, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.classe = classe;
        this.idCard = new Random().nextInt(1000000);
        add(this);
    }
    
    public static void add(Eleve eleve) {
        listeDesEleve.add(eleve);
    }
    
    public static void remove(Eleve eleve) {
        listeDesEleve.remove(eleve);
    }
    
    public static List<Eleve> getList() {
        return listeDesEleve;
    }
    
    public static Eleve getEleve(int code) {
        for(Eleve e: listeDesEleve) {
            if(e.getIdCard() == code) {
                return e;
            }
        }
        return null;
    }
     
    /* methodes 
       @methode d'ajout: 
        - Note
        - Cours
    */
    public void addNote(Note note) {
        this.listeDesNotes.add(note);
    }
    
    public void removeNote(Note note) {
        this.listeDesNotes.remove(note);
    }
    
    public void addCours(Enseignement enseignement, Enseignant enseignant) {
        this.listeDesCours.add(new Cours(enseignant, enseignement, this.classe));
    }
    
    
    public void removeCours(Enseignement enseignement, Enseignant enseignant) {
        int index = 0;
        for(Cours cours: listeDesCours) {
            if (cours.getEnseignement().getLibelle().equals(enseignement.getLibelle()) && cours.getEnseignant().getIdCard() == enseignant.getIdCard()) {
                this.listeDesCours.remove(index);
            }
            index ++;
        }
    }
    
    public void addEvaluation(Evaluation eval) {
        this.listeDesEvaluations.add(eval);
    }
    
    public void removeEvaluation(Evaluation eval) {
        listeDesEvaluations.remove(eval);
    }
    
    /* liste des enseignements */
    public List<Enseignement> getEnseignements() {
        List<Enseignement> listeEnseignements = new ArrayList<>();
        for(Cours c: getCours()) {
            listeEnseignements.add(c.getEnseignement());
        }
        return listeEnseignements;
    }
    
    public void getNotes() {
        System.out.println("|Date        |" + " Libellé de la période |" + " type d'évaluation |" + " cours concerné |" + " enseignant en charge |" + " note obtenue |");
        for(Note note: listeDesNotes) {
            Evaluation evaluation = note.getEvaluation();
            Cours cours = evaluation.getCours();
            Enseignant enseignant = cours.getEnseignant();
            Periode periode = evaluation.getPeriode();
            
            System.out.println(evaluation.getDate() + " |" + periode.libelle + " |" + evaluation.getType() + " |" + cours.getLibelle() + "|" + enseignant);
        }
    }
    
        /* pour avoir une note, on se sert de l'évaluation qui la concerne */
    public Note getNote(Evaluation evaluation) {
        for(Note note: listeDesNotes) {
            if (note.getEvaluation().getDate() == evaluation.getDate()) {
                return note;
            }
        }
        return null;
    }
    
    public List<Evaluation> getEvaluation(Periode p, Enseignement ens) {
        List<Evaluation> listeEval = new ArrayList<>();
        for(Evaluation eval: listeDesEvaluations) {
            if(eval.getEnseignement().equals(ens) && eval.getPeriode().equals(p))
                listeEval.add(eval);
        }
        return listeEval;
    }
    
    public List<Note> getNote() {
        return this.listeDesNotes;
    }
    
    public List<Evaluation> getEvaluation() {
        return this.listeDesEvaluations;
    }
    
    public void addCours(Cours cours) {
        this.listeDesCours.add(cours);
    }
    
    /* getters et setters hérités de Personne */
    
    public void setIdCard(int id) {
        this.idCard = id;
    }
    
    public int getIdCard() {
        return this.idCard;
    }
    
    public void setCours(List<Cours> c) {
        this.listeDesCours = c;
    }
    
    
    public List<Cours> getCours() {
        return this.listeDesCours;
    }
    
    public void setClasse(Classe c) {
        classe = c;
    }
    
    public Classe getClasse() {
        return classe;
    }
    
}
