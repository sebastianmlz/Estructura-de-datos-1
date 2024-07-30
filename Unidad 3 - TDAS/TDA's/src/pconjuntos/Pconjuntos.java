/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pconjuntos;

import negocios.Conjunto;
import negocios.fraccion;
import negocios.Complejo;
import negocios.Monomio;
import negocios.Polinomio;

/**
 *
 * @author sebas
 */
public class Pconjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Polinomio p = new Polinomio(4);
        Monomio B = new Monomio('-', 5, 8);
        p.insertar(B);
        Monomio C = new Monomio('+', 1, 4);
        p.insertar(C);
         Monomio D = new Monomio('+',3,0);
        p.insertar(D);
        System.out.println("P = " + p);
        System.out.println("x = "+p.valorX(1));
        //System.out.println("grado = "+p.grado());
        //System.out.println("Elemento = "+p.obtenerElemento(5));
        Polinomio Q = new Polinomio(4);
        Monomio B1 = new Monomio('+', 5, 2);
        Q.insertar(B1);
        Monomio C1 = new Monomio('+', 1, 4);
        Q.insertar(C1);
        Monomio D1 = new Monomio('+', 3, 0);
        Q.insertar(D1);
        System.out.println("Q = "+Q.toString());
        Polinomio R = new Polinomio(4);
        R.multiplicar(p, Q);
        System.out.println("R = "+R.toString());
        //System.out.println(Q.getMonomio(4));
       
    }
    
    /*
    R.insertarP(p);
        Monomio E1 = new Monomio('+', 10, 9);
        R.insertar(E1);
        Monomio F = new Monomio('+', 11, 6);
        R.insertar(F);
        Monomio G1 = new Monomio('+', 12, 7);
        R.insertar(G1);
    
    Conjunto A = new Conjunto();
        A.insertar(2);
        A.insertar(8);
        A.insertar(2);
        A.insertar(7);
        System.out.println("A = " + A);
        A.eliminar(2);
        A.eliminar(5);
        System.out.println("A = " + A);
        A.insertar(3);
        System.out.println("A = " + A);
        Conjunto B = new Conjunto();
        B.insertar(2);
        B.insertar(8);
        B.insertar(21);
        B.insertar(35);
        B.insertar(3);
        System.out.println("B = " +B);
        Conjunto C = new Conjunto();
        C.union(A,B);
        System.out.println("C = " + C);
    
        fraccion A = new fraccion(1,4,'+');
        System.out.println(A.ToString());
        fraccion B= new fraccion(1,2,'-');
        System.out.println(B.ToString());
        fraccion C = new fraccion();
        C.Dividir(A, B);
        System.out.println(C.ToString());
        fraccion D = new fraccion();
        D.Multipicar(A, B);
        System.out.println(D.ToString());
    
       
        Complejo A = new Complejo();
        A.setPral(2);
        A.setPimag(5);
        Complejo B = new Complejo(4,-2);
        Complejo C = new Complejo();
        System.out.println(A);
        System.out.println(B);
        C.suma(A, B);
        System.out.println(C);
        Complejo D = new Complejo();
        D.resta(A, B);
        System.out.println(D);
        
        
    
        Monomio M = new Monomio();
        M.setCoeficiente(10);
        M.setSigno('+');
        M.setExponente(5);
        System.out.println(M.toString());
        // salida +3x^5, -3x^5
        //M.derivar();
        //System.out.println(M.toString());
        //System.out.println(M.Evaluar(3));
        Monomio B = new Monomio();
        B.setCoeficiente(5);
        B.setSigno('+');
        B.setExponente(2);
        System.out.println(B.toString());
        Monomio H = new Monomio();
        H.Multiplicar(M, B);
        System.out.println(H.toString());
    
     
        
    
    */
}
