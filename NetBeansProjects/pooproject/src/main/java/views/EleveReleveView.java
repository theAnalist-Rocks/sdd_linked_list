/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import models.*;

/**
 *
 * @author junior
 */
public final class EleveReleveView {
    
    public EleveReleveView(Classe c, Periode p) {
        
    }
    
    public void getReleve(Classe c, Periode p) {
        System.out.println("Classe : " + c);
        for(Eleve e: c.getEleves()) {
            getReleve(e, p);
            System.out.println("------------------------------------------");
        }
    }
    
    // function to sort hashmap by values
    public static HashMap<Eleve, Float> sortByValue(HashMap<Eleve, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Eleve, Float> > list =
               new LinkedList<Map.Entry<Eleve, Float> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Eleve, Float> >() {
            public int compare(Map.Entry<Eleve, Float> o1,
                               Map.Entry<Eleve, Float> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<Eleve, Float> temp = new LinkedHashMap<Eleve, Float>();
        for (Map.Entry<Eleve, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
            
    public HashMap<Eleve, Float> rankings(Classe c, Periode p) {
        HashMap<Eleve, Float> listeDesMoyennes = new HashMap<Eleve, Float>();
        for(Eleve e: c.getEleves()) {
            listeDesMoyennes.put(e, p.moyenne(e));
        }
        
        return sortByValue(listeDesMoyennes);
    }
    
    public void rank(Classe c, Periode p) {
        HashMap<Eleve, Float> hm1 = rankings(c, p);
        int rank = 0;
        for (Eleve e: hm1.keySet()) {
            System.out.println(rank ++ + " - " + e + " " + hm1.get(e));
        }
    }
    
    public HashMap<Eleve, Float> getRank(Classe c, Eleve e, Periode p) {
        //HashMap<Eleve, Float> result = new HashMap<Eleve, Float>();
        return rankings(c, p);
    }
    
    public void getReleve(Eleve e, Periode p) {
        System.out.println("\n\n     ###################################");
        System.out.println("     ######## BULLETIN DE NOTES ########");
        System.out.println("     ###################################\n\n");
        System.out.println("=============================================");
        System.out.printf("NOM: %17s \nClasse: %17s\nPériode: %17s",e.getPersonalInfo(),e.getClasse().toString(), p.libelle +'\n');
        
        System.out.println("=============================================");
        System.out.printf("%10s %15s %15s\n\n", "MATIERE", "DEVOIR", "EXAMEN");
        for(Cours c: e.getCours()) {
            if (c != null) {
                System.out.printf("%10s", c.getEnseignement().getMatiere());
                for(Evaluation eval: p.getEvaluationByEnseignement(e, c.getEnseignement())) {
                    System.out.printf("%15.2f", eval.getNote().getValue());
                }
                System.out.printf("\n");
            }
        }
        System.out.println("=============================================");
        System.out.printf("%10s %30.2f\n", "MOYENNE", p.moyenne(e));
        System.out.println("=============================================");
    }
}
