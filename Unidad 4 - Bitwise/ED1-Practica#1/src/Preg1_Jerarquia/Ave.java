
package Preg1_Jerarquia;


public class Ave {
    char sexo;
    int edad;
    static int numeroAves;

    public Ave(char sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
        numeroAves++ ;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    public static int numAves_Creadas(){
        return numeroAves;
    }
    
    public void QuienSoy(){
        System.out.println("Sexo: "+getSexo());
        System.out.println("Edad: "+getEdad());
        System.out.println("--------");
    }
    
    /*
    public String QuienSoy(){
        String s ="";
        s = s +"Sexo: "+ getSexo() + "\nEdad: "+ getEdad() ;
        return s;
    } */

    
    
}

