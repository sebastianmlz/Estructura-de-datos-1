/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author sebas
 */
public class fraccion {
    
    int nume;
    int deno;

    public fraccion() {
        this.nume = 0;
        this.deno = 1;
    }
    
    public fraccion(int nume, int deno, char signo){
        this.deno = Math.abs(deno);
        if(signo == '+')
            this.nume = + Math.abs(nume);
        else
            this.nume = - Math.abs(nume);
    }

    public int getNume() {
        return Math.abs(nume);
    }

    public int getDeno() {
        return deno;
    }
    
    public char getSigno(){
        if(nume >= 0)
            return '+';
        else
            return '-';
    }

    public void setNume(int nume) {
        if(this.nume >= 0)
            this.nume = nume;
        else
            this.nume = - nume;
    }

    public void setDeno(int deno) {
        this.deno = deno;
    }
    
    public void setSigno(char signo){
        if( signo =='+')
            nume = Math.abs(nume);
        else
            nume = - Math.abs(nume);
    }
    
    public void Suma(fraccion A, fraccion B){
        deno = A.getDeno() * B.getDeno();
        nume = (A.nume * B.getDeno()) + (B.nume * A.getDeno());
        Simplificar();
    }
    
    public void Resta(fraccion A, fraccion B){
        deno = A.getDeno() * B.getDeno() ;
        nume = (A.nume * B.getDeno()) - (B.nume * A.getDeno());
        Simplificar();
    }
    
    public void Multipicar(fraccion  A, fraccion B){
        deno = A.getDeno() * B.getDeno();
        nume = A.nume * B.nume;
        Simplificar();
    }
    
    public void Dividir(fraccion A,  fraccion B){
        deno = A.deno * B.nume ;
        nume = A.nume * B.deno ;
        if(deno < 0){
            nume = nume * (-1);
            deno = Math.abs(deno);
        }
        Simplificar();   
    }
    
    public void Simplificar(){
        int x = MCD();
        nume = nume / x;
        deno = deno / x;
    }
    
    public int MCD(){
        int u = Math.abs(nume);
        int v = Math.abs(deno);
        if(v == 0)
            return u;
        else{
            int z;
            while(v != 0){
                z = u % v;
                u = v;
                v = z;
            }
            return u ;
        }
    }
    
    public String ToString(){
        String c = "C = ";
        c = "        " + getNume() + "\n"+c+getSigno()+" -----"+"\n        "+getDeno();
        return c;
    }
    
    public String ToStringF(){
        String c = "C = ";
        c = "             " + getNume() + "\n"+c+getSigno()+" ------"+"\n             "+getDeno();
        return c;
    }
    
    public String AString(){
        String c = "C = " + getSigno() + " "+getNume()+"/"+getDeno();
        return c;
    }
    
      
}
