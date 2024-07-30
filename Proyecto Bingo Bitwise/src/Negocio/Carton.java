/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.Random;

/**
 *
 * @author sebas
 */
public class Carton {
    
    int rangoInicial=1;
    int rangoFinal;
    int cantNumero;
    int cant=0;
    ConjuntoBtw c;
    ConjuntoBtw copia;
    int filas;
    int columnas;
    
    Random random = new Random();
    int numeroAleatorio ;
    
    public Carton(int rangoF,int cantNumero){
        if(cantNumero <= rangoF){
            this.rangoFinal= rangoF;
            this.cantNumero = cantNumero;
            c = new ConjuntoBtw(rangoF);
            copia = new ConjuntoBtw(rangoF);
            int j=1;
            boolean dimensionado = false;
            while(dimensionado == false){
                if(((j*j)<=cantNumero) && (((j+1)*(j+1))>cantNumero)){
                    if(((j*j)==cantNumero)){
                        this.filas = j;
                        this.columnas = j;
                    }else{
                        if(cantNumero <= ((j+1)*j)){
                            this.filas = j+1;
                            this.columnas = j;
                        }else{
                            if(cantNumero <= ((j+1)*(j+1))){
                                this.filas = j+1;
                                this.columnas = j+1;
                            }
                        }
                    }
                    dimensionado= true;
                }
                j++;
            }
            for(int i=0; i<getCantNumero(); i++){
                numeroAleatorio = random.nextInt(rangoFinal - rangoInicial + 1) + rangoInicial;
                if(i>0){
                    while(c.Pertenece(numeroAleatorio)){
                        numeroAleatorio= random.nextInt(rangoFinal - rangoInicial + 1) + rangoInicial;
                    }
                    c.insertar(numeroAleatorio);
                }else{
                    c.insertar(numeroAleatorio);
                }
            }
            
        }else{
            System.out.println("Error de creacion: El numero maximo a encontrar no puede ser menor que la cantidad de numeros en el carton");
        }
    }

    public int getCantNumero() {
        return this.cantNumero;
    }

    public void setCantNumero(int cantNumero) {
        this.cantNumero = cantNumero;
    }
    
    public ConjuntoBtw getC() {
        return c;
    }
    
    public ConjuntoBtw getCopia() {
        return copia;
    }

    public int getCantMarcados(){
        return cant;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    
    public void marcarCarton(int numero){
        if(c.Pertenece(numero)){
            copia.insertar(numero);
            c.eliminar(numero);
            cant++;
        }
    }
    
    public boolean estaMarcado(int num){
        return copia.Pertenece(num);
    }
    
    public int ultimoValorPF(){
        int valor=-1;
        int cont=0;
        for (int i = 1; i <= c.cant; i++) {
            if(c.Pertenece(i)){
                cont++;
                
            }else{
                if(copia.Pertenece(i)){
                    cont++; 
                }
            }
            i= i + getColumnas();
            if(cont != 0){
                if ((cont) % getFilas()== 0) {
                    valor = i;
                    i = c.cant;
                }
            }
        }
        return valor;
    }
    
    public boolean PrimeraFilaLlena() {
        int co=0;
        for(int i=1; i<=ultimoValorPF(); i++){
            if (estaMarcado(i)) {
                co++;
                }
        }
        if(co==getColumnas()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean cartonLleno(){
        return cant == cantNumero;
    }
    
    @Override
    public String toString(){
      String s="";
      for(int i=1; i<=c.cant; i++){
          if(c.Pertenece(i)|| copia.Pertenece(i)){
                if(estaMarcado(i)){
                    s = s +" X ";
                }else{
                    s = s + i + "  ";
                }
            }      
      }
      return s;
    }
    
    public String mostrarCarton() {
        StringBuilder sb = new StringBuilder();
        int cont=0;
        for (int i = 1; i <= c.cant; i++) {
            if(c.Pertenece(i)|| copia.Pertenece(i)){
                if(copia.Pertenece(i)){
                    if(estaMarcado(i)){
                        sb.append(" X ");
                        cont++;
                    }
                }else{
                    if(c.Pertenece(i)){
                        sb.append(String.format("%2d ", i));
                        cont++;
                    }
                }
                if ((cont) % getColumnas() == 0) {
                    sb.append("\n");
                }
            }
    
        }
        return sb.toString();
    }
     

    public static void main(String[] args) {
        Carton A = new Carton(20,18);
        
        System.out.println(A.mostrarCarton());
        System.out.println("Cantidad de numeros marcados: "+A.getCantMarcados());
        System.out.println("Filas: "+A.getFilas()+" Columnas: "+A.getColumnas());
        A.marcarCarton(1);
        A.marcarCarton(2);
        A.marcarCarton(3);
        A.marcarCarton(4);
        A.marcarCarton(5);
        A.marcarCarton(6);
        A.marcarCarton(7);
        A.marcarCarton(8);
        A.marcarCarton(9);
        A.marcarCarton(10);
       System.out.println(A.mostrarCarton());
       System.out.println("Cantidad de numeros marcados: "+A.getCantMarcados());
        System.out.println("valor: "+A.ultimoValorPF());
    }
    
}
