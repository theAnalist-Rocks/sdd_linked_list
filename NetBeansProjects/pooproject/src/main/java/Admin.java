/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;

/**
 *
 * @author junior
 */
public class Admin extends Enseignant {
    
    public Admin(String nom, String prenom, int age, float base) {
        super(nom, prenom, age, base);
    }
    
    /* méthode pour comparer les dates à définir plus tard */
    public void meanEnseignement(Eleve e, Enseignement ens) {
        for(Note note: e.getNote()) {
            if(ens.getLibelle().equals(note.getEvaluation().getEnseignement().getLibelle())) {
                
            }
        }
     
    }
    
}
