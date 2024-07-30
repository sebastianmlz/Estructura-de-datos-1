
package Preg4_Fecha;


public class Presentacion {
    
    public static void main(String[] args) {
        
        //fecha corta 04/06/08
        char[] fechaCortaTexto = {'0','4','0','6','0','8'};
        
        // fecha completa 28/12/1969
        char[] fechaCompletaTexto = {'2','8','1','2','1','9','6','9'};
                
        Fecha fechaCorta = Fecha.crearDeseTextoAnioDosDigitos(fechaCortaTexto);
        Fecha fechaLarga = Fecha.crearDeseTextoAnioCompleto(fechaCompletaTexto);  
        
        System.out.println("Fecha corta creada: " + fechaCorta);
        System.out.println("Fecha larga creada: " + fechaLarga);
        
        System.out.println("\nDia de la fecha corta: "+ fechaCorta.getDia());
        System.out.println("mes de la fecha corta: "+ fechaCorta.getMes());
        System.out.println("anio de la fecha corta: "+ fechaCorta.getAnio());

        
        System.out.println("\nDia de la fecha larga: "+ fechaLarga.getDia());
        System.out.println("mes de la fecha larga: "+ fechaLarga.getMes());
        System.out.println("anio de la fecha larga: "+ fechaLarga.getAnio());
        
    }
    
}
