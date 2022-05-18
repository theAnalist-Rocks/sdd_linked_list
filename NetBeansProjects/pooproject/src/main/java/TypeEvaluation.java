
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
public class TypeEvaluation {
    public String type;
    public float poidsType;
    public static final List<TypeEvaluation> listeTypeEvaluation = new ArrayList<>();
    
    public TypeEvaluation(String type, float poids) {
        this.poidsType = poids;
        this.type = type;
        addTypeEvaluation(this);
    }
    
    public static void addTypeEvaluation(TypeEvaluation tEva) {
        if (TypeEvaluation.notInList(tEva))
            listeTypeEvaluation.add(tEva);
    }
    
    public static boolean notInList(TypeEvaluation tEva) {
        int count = 0;
        for(TypeEvaluation eva: listeTypeEvaluation) {
            if (tEva.equals(eva)) {
                count ++;
            }
        }
        return count == 0;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setPoids(float poids) {
        this.poidsType = poids;
    }
    
    public float getPoids() {
        return poidsType;
    }
    
    public String getType() {
        return type;
    }
    
    public static List<TypeEvaluation> getListe() {
        return listeTypeEvaluation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.type);
        hash = 13 * hash + Float.floatToIntBits(this.poidsType);
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
        final TypeEvaluation other = (TypeEvaluation) obj;
        if (Float.floatToIntBits(this.poidsType) != Float.floatToIntBits(other.poidsType)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }
}
