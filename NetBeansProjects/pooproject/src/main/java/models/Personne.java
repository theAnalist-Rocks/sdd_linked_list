package models;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author junior
 */
abstract class Personne {
    protected String nom;
    protected String prenom;
    protected int age;
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getPersonalInfo() {
        return this.nom + " " + this.prenom;
    }
    
    
}
