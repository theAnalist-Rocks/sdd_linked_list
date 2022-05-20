package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author junior
 */
public class Matiere {
    protected String intitulle;
    protected String code;
    public static final List<Matiere> listeMatiere = new ArrayList<>();

    static {
        listeMatiere.add(new Matiere("Maths", "MTH"));
        listeMatiere.add(new Matiere("Physiques", "PHY"));
        listeMatiere.add(new Matiere("Science de la terre", "SVT"));
        listeMatiere.add(new Matiere("Chimie", "CHM"));
        listeMatiere.add(new Matiere("Anglais", "ANG"));
        listeMatiere.add(new Matiere("Français", "FR"));
        listeMatiere.add(new Matiere("Histoire", "HIS"));
        listeMatiere.add(new Matiere("Géographie", "GEO"));
    }
    
    
    public Matiere() {
        
    }
    
    public Matiere(String intitulle) {
        this.intitulle = intitulle;
        this.code = "Pas spécifié";
    }
    
    public Matiere(String intitulle, String code) {
        this.intitulle = intitulle;
        this.code = code;
        Matiere.addMatiere(this);
    }
    
    /* setters et getters */
    
    public void setIntitulle(String intitule) {
        this.intitulle = intitule;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getLibelle() {
        return this. code + "/" + this.intitulle;
    }
    
    public static void addMatiere(Matiere matiere) {
        listeMatiere.add(matiere);
    }
    
    public static void addMatiere(String intitule, String code) {
        Matiere mat = new Matiere(intitule, code);
        addMatiere(mat);
    }
    
    public static void removeMatiere(Matiere matiere) {
        listeMatiere.remove(matiere);
    }
    
    public static Matiere getMatiere(String libelle) {
        for (Matiere matiere: listeMatiere) {
            if (matiere.intitulle.equals(libelle)) {
                return matiere;
            }
        }
        return null;
    }
    
    /*public static Matiere getMatiere(String libelle, String code) {
        for(Matiere matiere: listeMatiere) {
            if (matiere.code.equals(code)) {
                return matiere;
            }
        }
        System.out.println("Not found!");
        return null;
    }*/
    
    public static Matiere getMatiere(String code, String libelle) {
        for (Matiere matiere: listeMatiere) {
            if (matiere.code.equals(code) && matiere.intitulle.equals(libelle)) {
                return matiere;
            }
        }
        return null;
    }
    
    public static void showAll() {
        for(Matiere matiere: listeMatiere) {
            System.out.println(matiere.getLibelle());
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.intitulle);
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
        final Matiere other = (Matiere) obj;
        if (!this.code.equals(other.code)) {
            return false;
        }
        return Objects.equals(this.intitulle, other.intitulle);
    }
    
    @Override
    public String toString() {
        return this.intitulle;
    }
    
}
