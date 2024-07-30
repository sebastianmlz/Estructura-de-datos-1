/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Libro {
    
    VectorNbits1[] L;
    String[] titulo;
    String[] autor;
    int cant;
    
    public Libro(int cantidad){
        L = new VectorNbits1[2];
        L[0] = new VectorNbits1(cantidad, 17);
        L[1] = new VectorNbits1(cantidad, 15);
        titulo = new String[cantidad];
        autor = new String[cantidad];
        cant = 0;
    }
    
    public void insertar(int codLibro, String titulo, String autor, int Edicion, int NPaginas, int dia, int mes, int año){
        cant++;
        int mask = 0;
        mask = codLibro;
        Edicion = Edicion<<7;
        mask = mask|Edicion;
        NPaginas = NPaginas<<9;
        mask = mask|NPaginas;
        L[0].insertar(mask, cant);
        año = año-1980;
        mes = mes<<6;
        mes = mes|año;
        dia = dia<<10;
        dia = dia|mes;
        L[1].insertar(dia, cant);
        this.titulo[cant-1] = titulo;
        this.autor[cant-1] = autor;

    }
    
    public int getCodigoLibro(int pos){
        int mask = ((int) Math.pow(2, 7)-1);
        int x = L[0].get(pos);
        mask&=x;
        return mask;
    }
    
    public int getEdicion(int pos){
        int mask = ((int) Math.pow(2, 2)-1);
        mask = mask<<7;
        int x = L[0].get(pos);
        mask = mask&x;
        mask = mask>>>7;
        return mask;
    }
    
    public int getNPaginas(int pos){
        int mask = ((int) Math.pow(2, 8)-1);
        mask = mask<<9;
        int x = L[0].get(pos);
        mask = mask&x;
        mask = mask>>>9;
        return mask;
    }
    
    public int getAño(int pos){
        int mask = ((int) Math.pow(2, 6)-1);
        int x = L[1].get(pos);
        mask = mask&x;
        mask = mask+1980;
        return mask;
    }
    
    public int getMes(int pos){
        int mask = ((int) Math.pow(2, 4)-1);
        mask = mask<<6;
        int x = L[1].get(pos);
        mask = mask&x;
        mask = mask>>>6;
        return mask;
    }
    
    public int getDia(int pos){
        int mask = ((int) Math.pow(2, 5)-1);
        mask = mask<<10;
        int x = L[1].get(pos);
        mask = mask&x;
        mask = mask>>>10;
        return mask;
    }

    public String getTitulo(int pos){
        return titulo[pos-1];
    }
    
    public String getAutor(int pos){
        return autor[pos-1];
    }

    public int getCantidad(){
        return cant;
    }
    
    public boolean existe(int codigo){
        for(int i=1; i<=cant ; i++){
            if(getCodigoLibro(i) == codigo){
                return true;
            }
        }
        return false;
    }
    
    public int posicionCod(int codigo){
        int x=0;
        for(int i=1; i<=cant ; i++){
            if(getCodigoLibro(i) == codigo){
                x = i;
            }
        }
        return x;
    }
    
    public String toString(int pos){
        String s="Libro:\n";
        s = s+"Codigo del Libro: "+getCodigoLibro(pos)+"\nTitulo: "+getTitulo(pos)+"\nAutor: "+getAutor(pos)+"\nEdicion: "
                +getEdicion(pos)+"\nNro de Paginas: "+getNPaginas(pos)+"\nfecha: "+getDia(pos)+"/"+getMes(pos)+"/"+getAño(pos);
        return s;
    }
    
    public static void main(String[] args) {
        Libro l = new Libro(2);
        l.insertar(19, "Harry Potter", "Sebastian Mendez", 1, 200, 31, 12, 2024);
        l.insertar(2, "Star Wars", "Wilder Rioja", 3, 156, 31, 2, 1990);
        System.out.println(l.toString(2));
    }
    
    
}
