
package Preg1_Jerarquia;

public class Canario extends Ave{
    
    private float tamaño;
    
    public Canario(char sexo, int edad){
        super(sexo, edad);
    }
    
    public Canario(char sexo, int edad, float tamaño){
        super(sexo, edad) ;
        this.tamaño = tamaño ;
    }

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }
    
    
    
    /*
    public String Altura(){
        String s="";
        if(tamaño > 30)
             return s ="Alto";
        else{
            if(tamaño >= 15 && tamaño <= 30)
                return s = "Mediano";
            else{
                if(tamaño < 15)
                    return s = "Bajo";
            }
        }
        return s;
    } */
    
    public void Altura(){
        if(getTamaño() > 30)
             System.out.println("Alto");
        else{
            if(getTamaño() >= 15 && getTamaño() <= 30)
                System.out.println("Mediano");
            else{
                if(getTamaño() < 15)
                    System.out.println("Bajo");;
            }
        }
    } 
           
    
}
