/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author junior
 */
public class Cours {
    protected Enseignant enseignant;
    public Enseignement enseignement;
    public Classe classe;
    private final static List<Cours> listeDesCours = new ArrayList<>();
    
    static {
        for(Enseignant e: Enseignant.listeEnseignants) {
            for (Enseignement ens: Enseignement.listeEnseignement) {
                for(Classe classe: Classe.listeClasse) {
                    if (classe.getNiveau() == ens.getNiveau())
                        new Cours(e, ens, classe);
                }
            }
        }
    }
    
    
    public Cours(Enseignant enseignant, Enseignement enseignement, Classe classe) {
        this.enseignant = enseignant;
        this.classe = classe;
        this.enseignement = enseignement;
        add(this);
    }
    
    public static void add(Cours cours) {
        listeDesCours.add(cours);
    }
    
    public static void add(Enseignant e, Enseignement ens, Classe c) {
        add(new Cours(e, ens, c));
    }
    
    public static void remove(Cours cours) {
        listeDesCours.remove(cours);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.enseignant);
        hash = 97 * hash + Objects.hashCode(this.enseignement);
        hash = 97 * hash + Objects.hashCode(this.classe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (!Objects.equals(this.enseignant, other.enseignant)) {
            return false;
        }
        if (!Objects.equals(this.enseignement, other.enseignement)) {
            return false;
        }
        return Objects.equals(this.classe, other.classe);
    }
    
    /* setters et getters */
    
    public Enseignant getEnseignant() {
        return this.enseignant;
    }
    
    public Enseignement getEnseignement() {
        return this.enseignement;
    }
    
    public Classe getClasse() {
        return this.classe;
    }
    
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }
    
    public String getInfo() {
        return this.classe.getLibelle() + ": " + this.enseignant + " intervient dans " + this.enseignement.getLibelle();
    }
    
    public String getLibelle() {
        return this.classe.getLibelle() + ": " + this.enseignement.getLibelle();
    }
    
    public static void showAll() {
        for(Cours cours: listeDesCours) {
            System.out.println(cours.getInfo());
        }
    }
}
