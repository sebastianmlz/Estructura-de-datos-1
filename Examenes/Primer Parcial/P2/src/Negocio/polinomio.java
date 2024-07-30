/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class polinomio {
    
    vectorNbits p;
    int dim;
    int coef[];
    char signo[];
    
    public polinomio(int cantElementos){
        p = new vectorNbits(cantElementos, 8);
        this.dim = 0;
        this.signo = new char[cantElementos];
        this.coef = new int[cantElementos];
    }
    
    public void insertar(char signo, int coeficiente, int expEnt, int expDec){
        if(pertenece(expEnt, expDec)){
            int nuevoEnt;
            int pos = posicion(expEnt, expDec);
            if(signo=='-'){
                if(getSigno(pos-1)=='-'){
                    nuevoEnt = coef[posicion(expEnt, expDec)-1] + coeficiente;
                }else{
                    nuevoEnt = coef[posicion(expEnt, expDec)-1] - coeficiente;
                }
            }else{
                if(getSigno(pos-1)=='-'){
                    nuevoEnt = -coef[posicion(expEnt, expDec)-1] + coeficiente;
                }else{
                    nuevoEnt = coef[posicion(expEnt, expDec)-1] + coeficiente;
                }
            }
            coef[posicion(expEnt, expDec)-1] = Math.abs(nuevoEnt);
        }else{
            dim++;
            expDec = expDec<<4;
            expDec = expDec|expEnt;
            p.insertar(expDec, dim);
            this.signo[dim-1] = signo;
            this.coef[dim-1] = coeficiente;
        }
    }
    
    
    public char getSigno(int pos){
        return signo[pos];
    }
    
    public int getCoeficiente(int pos){
        return coef[pos];
    }
    
    public int getExpEnt(int pos){
        int mascara = (int)(Math.pow(2, 4)-1);
        int x = p.sacar(pos);
        mascara = mascara&x;
        return mascara;
    }
    
    public int getExpDec(int pos){
        int mascara = (int)(Math.pow(2, 4)-1);
        int x = p.sacar(pos);
        mascara = mascara<<4;
        mascara = mascara&x;
        mascara = mascara>>>4;
        return mascara;
    }
    
    public boolean pertenece(int expEnt, int expDec){
        boolean p = false;
        for(int i=1; i<=dim; i++){
            if((getExpEnt(i)==expEnt) && (getExpDec(i)==expDec))
                p = true;
        }
        return p;
    }
    
    public boolean vacia(){
        return dim==0;
    }    
    
    public int posicion(int expEnt, int expDec){
        int pos=-1;
        for(int i=1; i<=dim; i++){
            if((getExpEnt(i)==expEnt) && (getExpDec(i)==expDec))
                pos = i;
        }
        return pos;
    }
    
    public String mostrar(){
        String s="P(x)= ";
        for(int i=0; i<dim; i++){
            s = s + getSigno(i) +getCoeficiente(i) +"x^("+ getExpEnt(i+1) +"." + getExpDec(i+1) +") ";
        }
        return s;
    }
    
    
}
