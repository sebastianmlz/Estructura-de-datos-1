/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;

import java.util.Random;

/**
 *
 * @author sebas
 */
public class Juego {
    
    int cantidadCartones;
    int rangoF;
    int cantidadNumeros;
    int contador;
    public int nume;
    Carton carton[];
    ConjuntoBtw ran;
    Random random = new Random();
        
    public Juego(int cantidadCartones,int rangoF,int cantidadNumeros){
        this.cantidadCartones = cantidadCartones;
        this.rangoF = rangoF;
        this.cantidadNumeros = cantidadNumeros;
        carton = new Carton[cantidadCartones];
        ran = new ConjuntoBtw(rangoF);
        for(int i=0 ; i<cantidadCartones; i++){
            carton[i] = new Carton(rangoF, cantidadNumeros);
        }
    }
    
    public Carton getCarton(int posicion){
        return carton[posicion-1];
    }

    public int getCantidadCartones() {
        return cantidadCartones;
    }

    public int getCantidadNumeros() {
        return cantidadNumeros;
    }

    public int getRangoF() {
        return rangoF;
    }
    
    public void marcarCartones(int numero){
        for(int i=0; i<cantidadCartones; i++){
            carton[i].marcarCarton(numero);
            if(carton[i].cartonLleno()){
                System.out.println("Carton "+(i+1)+" ganador: "+carton[i].getCopia().toString());
                i= cantidadCartones;
            }
        }
    }
    
    public boolean cartonLle(){
        for(int i=0; i<cantidadCartones; i++){
            if(carton[i].cartonLleno()){
                return true;
            }
        }
        return false;
    }
    
    public void jugar() {
        if (!cartonLle()) {
            do {
                nume = random.nextInt(rangoF - 1 + 1) + 1;
            } while (ran.Pertenece(nume));

            ran.insertar(nume);
            contador++;
            marcarCartones(nume);
        }
    }

    public static void main(String[] args) {
        Juego bingo = new Juego(3, 10, 5);
        
        System.out.println("Carton 1: "+bingo.getCarton(1)+"Cantidad de numeros marcados del carton 1: "+bingo.getCarton(1).getCantMarcados());
        System.out.println("Carton 2: "+bingo.getCarton(2)+"Cantidad de numeros marcados del carton 2: "+bingo.getCarton(2).getCantMarcados());
        System.out.println("Carton 3: "+bingo.getCarton(3)+"Cantidad de numeros marcados del carton 3: "+bingo.getCarton(3).getCantMarcados());
        
        bingo.jugar();
        bingo.jugar();
        bingo.jugar();
        bingo.jugar();
        bingo.jugar();
        bingo.jugar();
        bingo.jugar();
        bingo.jugar();
        
        /*bingo.marcarCartones(1);
        bingo.marcarCartones(2);
        bingo.marcarCartones(3);
        bingo.marcarCartones(4);
        bingo.marcarCartones(5);
        bingo.marcarCartones(6);
        bingo.marcarCartones(7);
        bingo.marcarCartones(8);
        bingo.marcarCartones(9);
        //bingo.marcarCartones(3);
        */
        //System.out.println("Carton 1: "+bingo.getCarton(1)+"Cantidad de numeros marcados del carton 1: "+bingo.getCarton(1).getCantMarcados());
        //System.out.println("Carton 2: "+bingo.getCarton(2)+"Cantidad de numeros marcados del carton 2: "+bingo.getCarton(2).getCantMarcados());
        //System.out.println("Carton 3: "+bingo.getCarton(3)+"Cantidad de numeros marcados del carton 3: "+bingo.getCarton(3).getCantMarcados());


        
    }

}
