
package Pregg16_Cinta;

public class Presentacion {
    
    public static void main(String[] args) {
        Cinta c1 = new Cinta("unas frases nuevas");
        System.out.println(c1.toString());
        System.out.println("Posicion: "+c1.getCabezal());
        System.out.println("Caracter de posicion "+c1.getCabezal()+" es: "+c1.caracterCorriente());
        
        c1.avanzarPosSig();
        System.out.println("Posicion: "+c1.getCabezal());
        System.out.println("Caracter de posicion "+c1.getCabezal()+" es: "+c1.caracterCorriente());
        
        c1.REG('f');
        System.out.println("Cambiando caracter en la posicion "+c1.getCabezal()+": "+c1.toString());
        
        c1.siguientePal();
        System.out.println("Posicion de la siguiente palabra: "+c1.getCabezal());
        
        c1.avanzarPosSig();
        System.out.println("Posicion: "+c1.getCabezal());
        System.out.println("Caracter de posicion "+c1.getCabezal()+" es: "+c1.caracterCorriente());
        
        c1.siguientePal();
        System.out.println("Posicion de la siguiente palabra: "+c1.getCabezal());
        
        c1.retrocederPos();
        System.out.println("Posicion: "+c1.getCabezal());
        System.out.println("Caracter de posicion "+c1.getCabezal()+" es: "+c1.caracterCorriente());
      
        c1.retrocederBlanco();
        System.out.println("Posicion de la anterior palabra o caracter en blanco: "+c1.getCabezal());
    }
}
