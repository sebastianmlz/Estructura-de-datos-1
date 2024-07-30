
package Preg1_Jerarquia;

public class Piolin extends Canario{
    int numeroPeliculas;
   
    public Piolin(char sexo, int edad, int numeroPeliculas){
       super(sexo, edad);
       this.numeroPeliculas = numeroPeliculas;
    }
    
    public static void main(String[] args) {
        Piolin P = new Piolin('H', 5, 10);
        Loro L = new Loro('N', "verde", 'M', 3);
        P.QuienSoy();
        L.QuienSoy();
        P.Altura();
        L.DeDondeEres();
        P.setTamaño(35);
        P.Altura();
        L.setRegion('O');
        L.DeDondeEres();
        System.out.println("Numero de aves creadas: "+Loro.numAves_Creadas() );
    }
    
}

