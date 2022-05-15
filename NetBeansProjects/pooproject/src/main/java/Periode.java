/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;
// import java.util.concurrent.TimeUnit;

/**
 *
 * @author junior
 */
public class Periode {
    public String libelle;
    public Date debut;
    public Date fin;
    
    public Periode() {
        start();
    }
    
    public Periode(String libelle) {
        this.fin = new Date();
        this.libelle = libelle;
    }
    
    public void end() {
        this.fin = new Date();
    }
    
    public void start() {
        this.debut = new Date();
    }
    
    /* getters et setters */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
