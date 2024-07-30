/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author sebas
 */
public class Monomio {
    
    int coef;
    int exp;
    
    public Monomio(){
        coef = 0;
        exp = 1;
    }
    
    public Monomio(char signo, int coef, int exp){
        this.exp = exp;
        if(signo == '+')
            this.coef = Math.abs(coef);
        else{
            if(signo== '-')
                this.coef = - Math.abs(coef);
            else
                System.out.println("Error de signo");
        }
    }
    
    public void setCoeficiente(int coef){
         if(coef != 0){
            if(this.coef >= 0)
                this.coef = Math.abs(coef);
            else
                this.coef = - Math.abs(coef);
         }else{
             System.out.println("El coeficiente no puede ser cero");
             System.exit(1);
         }
    }
    
    public void setCoeficiente1(int coe){
        this.coef = coe;
    }
    
    public void setExponente(int exp){
        if(this.exp >= 0){
            this.exp = exp;
        }else{
            System.out.println("Error: exponente negativo");
            System.exit(1);
        }
    }
    
    public void setSigno(char signo){
        if(signo == '+')
            this.coef = Math.abs(coef);
        else
            this.coef = - Math.abs(coef);
    }
    
    //GETTERS
    
    public int getCoef(){
        return Math.abs(coef);
    }
    
    public int getExp(){
        return exp;
    }
    
    public char getSigno(){
        char r;
        if(coef >= 0)
            r = '+';
        else
            r = '-';
        return r;
    }
    
    public void Sumar(Monomio A, Monomio B){
        if(A.getExp() == B.getExp()){
            coef = A.getCoef() + B.getCoef();
            exp = A.getExp();
        }
    }
    
    public void Restar(Monomio A, Monomio B){
        if(A.getExp() == B.getExp()){
            coef = A.getCoef() - B.getCoef();
            exp = A.getExp();
        }
    }
    
    //5x^5 + 4x^2 = 20x^7
    public Monomio Multiplicar(Monomio A, Monomio B){
        Monomio m = new Monomio();
        coef = A.getCoef() * B.getCoef() ;
        exp = A.exp + B.exp ;
        if(A.getSigno() =='-'){
            if(B.getSigno() == '+')
                setSigno('-');
            else
                setSigno('+');
        }if(B.getSigno() =='-'){
            if(A.getSigno() == '+')
                setSigno('-');
            else
                setSigno('+');
        }
        m.coef = coef;
        m.exp = exp;
        return m;
    }
    
    //8x^7 / 2x^5 = 4x^2
    
    public void dividir(Monomio A, Monomio B){
        if(A.exp >= B.exp){
            coef = A.coef / B.coef ;
            exp = A.exp - B.exp ;
        }else
            System.out.println("Error: No se puede ejecutar la division");
    }
    
    public int Evaluar(int x){
        int valor;
        //Math.pow(base,potencia);
        if(x != 0)
            valor = (int) (coef * Math.pow(x, exp));
        else
            valor = 0;
        return valor;
    }
    
    public void derivar(){
        if(exp == 0){
            exp = 1;
            coef = 0;
        }else{
            coef = coef * exp;
            exp = exp - 1 ;
        }
    }
    
    public void integral(){
        if(exp == 0){
            coef = 0 ;
            exp = 1;
        }else{
            exp = exp + 1 ;
            coef = coef / exp ;
        }
    }
    
    public String toStringS(){
        String s = " ";
        s = s + getSigno() + Math.abs(coef) + "x^" + exp ;
        return s;
    }
    
    public String toStringss(){
        String s = " " + getSigno();
        if(getCoef() != 1)
            s = s + Math.abs(coef);
        if(getExp() != 0)
            s = s + "x^" + getExp();
        return s;
    }
    
    @Override
    public String toString(){
        String s = "";
        if(coef == 0 && exp == 0){
            s = "";
        }if(exp == 0)
            s = s + getSigno() + Math.abs(coef) ;
        else
            s = s + getSigno() + Math.abs(coef) + "x^" + exp;
        return s;    
    }
    
}
