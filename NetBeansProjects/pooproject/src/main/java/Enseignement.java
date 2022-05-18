/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author junior
 */
public class Enseignement {
    private float coefficient;
    protected Niveau niveau;
    protected Matiere matiere;
    public static final List<Enseignement> listeEnseignement = new ArrayList<>(); // liste de tous les enseignements de l'établissement
    
    public Enseignement() {
        this.coefficient = 1; // par défaut, on met le cœfficient à 1
        addEnseignement(this);
    }
    
    public Enseignement(Niveau niveau, Matiere matiere, float coefficient) {
        this.coefficient = coefficient;
        this.matiere = matiere;
        this.niveau = niveau;
        addEnseignement(this);
    }
    
    /* setters et getters */
    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }
    
    public Niveau getNiveau() {
        return this.niveau;
    }
    
    public float getCoefficient() {
        return this.coefficient;
    }
    
    public String getLibelle() {
        return this.matiere.getLibelle() + " - " +this.niveau.label;
    }
    
    public static void addEnseignement(Enseignement enseignement) {
        listeEnseignement.add(enseignement);
    }
    
    public static Enseignement getEnseignement(int index) {
        return listeEnseignement.get(index);
    }
    
    public static void showAll() {
        for(Enseignement ens: listeEnseignement) {
            System.out.println(ens.getLibelle());
        }
    }
    
    public void getMoyenne(Eleve e, Periode p) {
        
    }
/*    public static Enseignement getEnseignement(Enseignement enseignement) {
        for (Enseignement _enseignement: listeEnseignement) {
            if(true) {
                pass
            }
        }
    }*/
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Float.floatToIntBits(this.coefficient);
        hash = 97 * hash + Objects.hashCode(this.niveau);
        hash = 97 * hash + Objects.hashCode(this.matiere);
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
        final Enseignement other = (Enseignement) obj;
        if (Float.floatToIntBits(this.coefficient) != Float.floatToIntBits(other.coefficient)) {
            return false;
        }
        if (!Objects.equals(this.niveau, other.niveau)) {
            return false;
        }
        return Objects.equals(this.matiere, other.matiere);
    }
}
