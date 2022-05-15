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
        /* valeurs sont par défaut /10 */
        this.value = evaluation.getBareme() * value;
    }
    
    public float getValue() {
        return this.value;
    }
    
    public Eleve getEleve() {
        return this.eleve;
    }
    
    public Evaluation getEvaluation() {
        return this.evaluation;
    }
    
    
    
}
