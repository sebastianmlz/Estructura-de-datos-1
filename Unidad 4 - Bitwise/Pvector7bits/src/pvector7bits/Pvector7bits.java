/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvector7bits;

import Negocio.Vector7bits;
import Negocio.VectorNbits1;
import Negocio.certificado;
import Negocio.classhora;

/**
 *
 * @author Estefany
 */
public class Pvector7bits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    /*    VectorNbits1 C=new VectorNbits1(10,9);
        C.insertar(55,1);
        C.insertar(10,3);
        C.insertar(20,5);
        C.insertar(35,10);
        C.insertar(80,8);
        System.out.println(C);
        C.insertar(77,2);
        C.insertar(0,5);
        System.out.println(C);
        classhora V= new classhora(10);
        V.SETHORA(9,20,55);
        V.SETHORA(1,10,31);
        V.SETHORA(18,1,27);
        System.out.println(V); */
        certificado c= new certificado(3);
        c.insertar(123456, 6, 6, 1919, 0, 1, 3, 0, 2, 23, 5, 5, 2025, "sebastian");
        System.out.println("ci: "+c.getCi(1));
        System.out.println("dia: "+c.getDia(1));
        System.out.println("mes: "+c.getMes(1));
        System.out.println("year: "+c.getAño(1));
        System.out.println("nombre: "+c.getNombre(1));
        System.out.println("sedes: "+c.getSedes(1));
        System.out.println("Municipio: "+c.getMuni(1));
        System.out.println("Lugar: "+c.getLugar(1));
        System.out.println("Vacuna: "+c.getVacuna(1));
        System.out.println("Proveedor: "+c.getProveedor(1));
        System.out.println("dia vacuna: "+c.getdiaVacu(1));
        System.out.println("mes vacuna: "+c.getmesVacu(1));
        System.out.println("lote: "+c.getLote(1));
        System.out.println("año vacuna: "+c.getAñoVacu(1));
        
        
    }
    
}
