
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author junior
 * @update Dans une classe donnée, tous les élèves de cette classe suivent les mêmes cours
 */
public class Classe {
    public static final List<Classe> listeClasse = new ArrayList<>();
    public String subdivision;
    public Niveau niveau;
    public List<Eleve> listeEleve = new ArrayList<>();
    public List<Cours> listeCours = new ArrayList<>();
    //public final List<Char> sudbivisions = new ArrayList<>();
    
    static {
        Classe.add("A", 6);
        Classe.add("B", 6);
        Classe.add("A", 5);
        Classe.add("A", 4);
        Classe.add("A", 3);
        Classe.add("C", 6);
        Classe.add("B", 5);
        Classe.add("B", 4);
        Classe.add("B", 3);
        Classe.add("C", 3);
    }
    
    public Classe(String subdivision, Niveau niveau) {
        this.subdivision = subdivision;
        this.niveau = niveau;
    }
    
    public Classe(Niveau niveau) {
        this.niveau = niveau;
    }
    
    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }
    
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
    public String getSubdivision() {
        return this.subdivision;
    }
    
    public Niveau getNiveau() {
        return this.niveau;
    }
    
    public String getLibelle() {
        return this.niveau.label + ' ' + this.subdivision;
    }
    
    public static void addSubdivision(Classe c) {
        Pattern p = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
        boolean found;
        Matcher match;
        
    }
    
    public static int isUnique(Classe c) {
        int count = 0;
        if (listeClasse.contains(c)) {
            for (Classe classe: listeClasse) {
                if(classe.getLibelle().equals(c.getLibelle())) {
                    count ++;
                }
            }
        }
        return count;
    }
    
    public static void add(Classe classe) {
        int count = isUnique(classe);
        if (count == 0) {
            listeClasse.add(classe);
        }
    }
    
    public static void add(String subdivision, int numeroNiveau) {
        /*Vérifier l'unicité*/
        Classe c = new Classe(subdivision, Niveau.get(numeroNiveau));
        add(c);
    }
    
    public void addCours(Cours cours) {
        this.listeCours.add(cours);
    }
    
    public static void delete(Classe classe) {
        listeClasse.remove(classe);
    }
    
    public static Classe getClasse(String subdivision, int code) {
        Niveau level = Niveau.get(code);
        String form = level.getLibele() + ' ' + subdivision;
        for (Classe classe: listeClasse) {
            if (classe.getLibelle().equals(form))
                return classe;
        }
        System.out.println("Not found!");
        return null;
    }
    
    public void addEleve(Eleve eleve) {
        this.listeEleve.add(eleve);
    }
    
    public void getEleve() {
        System.out.println("Liste des élèves de la classe de " + this.getLibelle());
        for(Eleve eleve: listeEleve) {
            System.out.println(eleve.nom + ' ' + eleve.prenom);
        }
    }
      
    
    public static void afficherClasses() {
        System.out.println("Liste des Classes: ");
        for (Classe classe:listeClasse){
            System.out.println(classe);
        }
    }

    @Override
    public String toString() {
        return "Nom: " + this.getLibelle();
    }
    
}
