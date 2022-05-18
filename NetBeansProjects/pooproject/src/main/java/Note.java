
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author junior
 */
public class Note {
    private Evaluation evaluation;
    private float value;
    private Eleve eleve;
    
    public Note() {
        
    }
    
    public Note(Eleve eleve, Evaluation evaluation, float valeur) {
        this.eleve = eleve;
        this.evaluation = evaluation;
        this.value = valeur;
        this.eleve.addEvaluation(evaluation);
        this.evaluation.setNote(this);
    }
    
    /** accesseurs
     * @param evaluation **/
    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
    
    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
    
    public void setValue(float value) {
        this.value = evaluation.getEnseignement().getCoefficient() * value;
    }
    
    public float getValue() {
        return this.value * evaluation.getEnseignement().getCoefficient();
    }
    
    public Eleve getEleve() {
        return this.eleve;
    }
    
    public Evaluation getEvaluation() {
        return this.evaluation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.evaluation);
        hash = 89 * hash + Float.floatToIntBits(this.value);
        hash = 89 * hash + Objects.hashCode(this.eleve);
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
        final Note other = (Note) obj;
        if (Float.floatToIntBits(this.value) != Float.floatToIntBits(other.value)) {
            return false;
        }
        if (!Objects.equals(this.evaluation, other.evaluation)) {
            return false;
        }
        return Objects.equals(this.eleve, other.eleve);
    }
    
    
    
}
