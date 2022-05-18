package models;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junior
 */
public class Niveau {
    protected String label;
    protected int code;
    protected String description;
    private static final List<Niveau> liste = new ArrayList<>();
    
    static {
        liste.add(new Niveau("6e", 6, "Niveau d'étude 6eme"));
        liste.add(new Niveau("5e", 5, "Niveau d'étude 5eme"));
        liste.add(new Niveau("4e", 4, "Niveau d'étude 4eme"));
        liste.add(new Niveau("3e", 3, "Niveau d'étude 3eme"));
    }
    
    public static void addLevel(Niveau niveau) {
        liste.add(niveau);
    }
    
    public static void addLevel(String desc, int code, String label) {
        addLevel(new Niveau(desc, code, label));
    }
    
    public static void deleteLevel(Niveau niveau) {
           liste.remove(niveau);
    }
    
    public static Niveau get(int numero) {
        for (Niveau niveau: liste) {
            if (niveau.code == numero)
                return niveau;
        }
        return null;
    }
    
    /*public static void deleteLevel(int numero){
        //deletes at position numero
        liste.remove(numero);
        
    }*/
    
    /*public static void deleteLevel(int numero) {
        for (Niveau niveau: liste) {
            if (niveau.code == numero) {
                deleteLevel(niveau);
                return;
            }
        }
    }*/
    
    public static void deleteLevelV1(int numero) {
        int indice = -1;
        for(Niveau niveau: liste) {
            if (niveau.code == numero) {
                indice = liste.indexOf(niveau);
                
            }
        }
        deleteLevel(liste.get(indice));
    }
    
    public static void deleteLevel(int numero) {
        Niveau niveau = new Niveau(numero);
        deleteLevel(niveau);
    }
    
    
    public Niveau(int numero) {
        this.code = numero;
    }
    
    public Niveau() {
        
    }
    
    public Niveau(String label, int code, String desc) {
        this.label = label;
        this.code = code;
        this.description = desc;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public void setDescription(String desc) {
        this.description = desc;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getLibele() {
        return this.label;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public static List<Niveau> getListe() {
        return liste;
    }
    
    @Override
    public String toString() {
        return "Numero: " + this.code + " Libelle: " + this.label + " DESC: " + this.description;
    }
    
    public static void showList() {
        for(Niveau niveau: liste) {
            System.out.println(niveau);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.code;
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
        final Niveau other = (Niveau) obj;
        return this.code == other.code;
    }
    
    
}
