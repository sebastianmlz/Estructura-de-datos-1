
package Pregg11_Bolsa;


public class Presentacion {
    
    public static void main(String[] args) {
        
        Bolsa<String> B1 = new Bolsa<>();
        
        B1.Añadir("manzana");
        B1.Añadir("pera");
        B1.Añadir("manzana");
        B1.Añadir("uva");
        
        System.out.println("Bolsa B1 : "+B1.toString());
        
        System.out.println("La bolsa esta vacia? : "+B1.BolsaVacia());
        
        System.out.println("la banana esta dentro de la bolsa? : "+B1.Dentro("banana"));
        
        System.out.println("Cantidad de bananas en la bolsa : "+B1.Cuantos("banana"));
        
        System.out.println("Total de elementos en la bolsa: "+ B1.Total());
        
        Bolsa<String> B2 = new Bolsa<>();
        
        B2.Añadir("banana");
        B2.Añadir("fresa");
        
        System.out.println("Bolsa B2: "+B2.toString());
        
        System.out.println("Union de las 2 bolsas: "+B1.Union(B2));
    }
    
}
