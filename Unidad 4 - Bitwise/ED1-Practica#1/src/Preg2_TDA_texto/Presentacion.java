
package Preg2_TDA_texto;

public class Presentacion {
    
    public static void main(String[] args) {
        Texto miTexto = new Texto();
        miTexto.agregarCaracter('H');
        miTexto.agregarCaracter('o');
        miTexto.agregarCaracter('l');
        miTexto.agregarCaracter('a');

        System.out.println("Texto actual: " + miTexto.toString2());
        System.out.println("Tamaño del texto: " + miTexto.tamanio());

       
        System.out.println("Carácter en posición 2: " + miTexto.caracterEn(2));
   
   
        miTexto.eliminarCaracterEn(2);
        System.out.println("Texto después de eliminar un carácter: " + miTexto.toString2());

        // Limpiar el texto
        miTexto.Destruir();
        System.out.println("Texto después de destruir: " + miTexto.toString2());
    }
    
}
