/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author USUARIO
 */
public class TDALibro {
    
    VectorNbits V1;
    int Cant;
    String[] Titulo;
    String[] Autor;
    
    public TDALibro(int cantidad) {
        V1 = new VectorNbits(cantidad, 32);
        this.Cant = 1;
        Titulo = new String[cantidad];
        Autor = new String[cantidad];
    }
    
    public void Insertar(int codigoLibro, String titulo, String autor, int Edicion,
            int NroPaginas, int dia, int mes, int año) {
        int mask = codigoLibro;
        //System.out.println(Integer.toBinaryString(mask));
        mask = mask << 2;
        // System.out.println(Integer.toBinaryString(mask));
        mask = mask | Edicion;
        // System.out.println(Integer.toBinaryString(mask));
        mask = mask << 8;
        mask = mask | NroPaginas;
        mask = mask << 5;
        mask = mask | dia;
        mask = mask << 4;
        mask = mask | mes;
        mask = mask << 6;
        año = año - 1980;
        mask = mask | año;
        //  System.out.println(Integer.toBinaryString(mask));
        V1.insertar(mask, Cant);
         System.out.println(V1.toString());
        Titulo[Cant - 1] = titulo;
        Autor[Cant - 1] = autor;
        Cant++;
    }
    
    public String getTitulo(int pos)
    {
        return Titulo[pos-1];
    }
    
    public String getAutor(int pos)
    {
        return Autor[pos-1];
    }
    
    public int getCantidad() {
        return Cant;
    }
    
    public int getCodigoLibro(int pos) {
        int dato = V1.sacar(pos);
        //32-7=25
        int mask = (int) (Math.pow(2, 7) - 1);
        dato = dato >>> 25;
        dato = dato & mask;
        return dato;
    }
    
    public int getEdicion(int pos) {
        int dato = V1.sacar(pos);
        //25-2=23
        int mask = (int) (Math.pow(2, 2) - 1);
        dato = dato >>> 23;
        dato = dato & mask;
        return dato;
    }
    
    public int getNroPaginas(int pos) {
        int dato = V1.sacar(pos);
        //23-8=15
        int mask = (int) (Math.pow(2, 8) - 1);
        dato = dato >>> 15;
        dato = dato & mask;
        return dato;
    }
    
    public int getDia(int pos) {
        int dato = V1.sacar(pos);
        //15-5=10
        int mask = (int) (Math.pow(2, 5) - 1);
        dato = dato >>> 10;
        dato = dato & mask;
        return dato;
    }
    public int getMes(int pos)
    {
        int dato=V1.sacar(pos);
        //10-4=6
        int mask=(int)(Math.pow(2, 4)-1);
        dato=dato>>>6;
        dato=dato&mask;
        return dato;
    }
    public int getAño(int pos)
    {
        int dato=V1.sacar(pos);
        //6-6=0
        int mask=(int)(Math.pow(2, 6)-1);
        dato=dato>>>0;
        dato=dato&mask;
        dato=dato+1980;
        return dato;
    }
    
    public String Mostrar(int pos)
    {
        String s="";
        s=s+"\nCodigoLibro: "+ getCodigoLibro(pos)
          +"\nTitulo: "+getTitulo(pos)
          +"\nAutor: "+getAutor(pos)
          +"\nEdicion: "+getEdicion(pos)
          +"\nNroDePaginas: "+getNroPaginas(pos)
          +"\nFecha: "+ getDia(pos)+"/"+getMes(pos)+"/"+getAño(pos);            
        return s;
    }
    
    public static void main(String[] args) {
        TDALibro A = new TDALibro(10);
        A.Insertar(10, "Star War", "Pedro Rodriguez", 3, 105, 31, 12, 2023);
       /* System.out.println(A.getCodigoLibro(1));
        System.out.println(A.getEdicion(1));
        System.out.println(A.getNroPaginas(1));
        System.out.println(A.getDia(1));
        System.out.println(A.getMes(1));
        System.out.println(A.getAño(1));
        System.out.println(A.getTitulo(1));*/
        System.out.println(A.Mostrar(1));
    }
}
