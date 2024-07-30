/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;

/**
 *
 * @author USUARIO
 */
public class PolinomioFraccion {

    VectorNbits V;
    int cant;

    public PolinomioFraccion(int cantidadElementos) {
        this.cant = 0;
        this.V = new VectorNbits(cantidadElementos, 18);
    }

    public void Insertar(char signoCoeficiente, int numeradorCoeficiente, int denominadorCoeficiente,
            char signoExponente,int numeradorExponente, int denominadorExponente) {
        cant++;
        int S = 0;
        if (signoCoeficiente == '+') {
            S = 1;
        }
        int mask = S;
        mask = mask << 4;
        mask = mask | numeradorCoeficiente;
        mask = mask << 4;
        mask = mask | denominadorCoeficiente;
        int Sig=0;
        if (signoExponente=='+') {
            Sig=1;
        }
        mask=mask<<1;
        mask=mask|Sig;
        mask=mask<<4;
        mask=mask|numeradorExponente;
        mask=mask<<4;
        mask=mask|denominadorExponente;
        
        V.insertar(mask, cant);
        
    }
    public char getSignoCoeficiente(int pos){
        int valor=V.sacar(pos);
        //18-1=17
        int mask=(int) (Math.pow(2, 1)-1);
        valor=valor>>>17;
        valor=valor&mask;
        if (valor==1) {
            return '+';
        }else
            return '-';
    }
    
    public int getNumeradorCoeficiente(int pos){
        int valor=V.sacar(pos);
        //17-4=13
        int mask=(int) (Math.pow(2, 4)-1);
        valor=valor>>>13;
        valor=valor&mask;
        return valor;
    }
    
    public int getDenominadorCoeficiente(int pos){
        int valor=V.sacar(pos);
        //13-4=9
        int mask=(int) (Math.pow(2, 4)-1);
        valor=valor>>>9;
        valor=valor&mask;
        return valor;
    }
    public char getSignoExponente(int pos){
        int valor=V.sacar(pos);
        //9-1=8
        int mask=(int) (Math.pow(2, 1)-1);
        valor=valor>>>8;
        valor=valor&mask;
        if (valor==1) {
            return '+';
        }else
        {
            return '-';
        }
    }
    
    public int getNumeradorExponente(int pos){
        int valor=V.sacar(pos);
        //8-4=4
        int mask=(int) (Math.pow(2, 4)-1);
        valor=valor>>>4;
        valor=valor&mask;
        return valor;
    }
    public int getDenominadorExponente(int pos){
        int valor=V.sacar(pos);
        //4-4=0
        int mask=(int) (Math.pow(2, 4)-1);
        valor=valor>>>0;
        valor=valor&mask;
        return valor;
    }
    
    public String toString(){
        String S=" ";
        for (int i = 1; i <= cant; i++) {
            S=S+" "+getSignoCoeficiente(i)+" "+getNumeradorCoeficiente(i)+"/"+getDenominadorCoeficiente(i)
               +" X^"+getSignoExponente(i)+getNumeradorExponente(i)+"/"+getDenominadorExponente(i);
        }
        return S;
    }
    
    public static void main(String[] args) {
        PolinomioFraccion A=new PolinomioFraccion(2);
        A.Insertar('+', 10, 10,'+',10,10);
        System.out.println(A.toString());
    }
}
