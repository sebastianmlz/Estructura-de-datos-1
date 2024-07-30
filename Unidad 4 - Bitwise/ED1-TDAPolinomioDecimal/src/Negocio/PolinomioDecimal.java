/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class PolinomioDecimal {
    VectorNbits1 p;
    int dim;
    public int posi;
    
    public PolinomioDecimal(int cantEle){
        this.dim = cantEle;
        posi = 0;
        p = new VectorNbits1(cantEle, 17);
    }
    
    public void insertar(char signo, int coefEnt, int coefDec, int expEnt, int expDec){
        if(pertenece(expEnt, expDec)){
            operaciones(signo, coefEnt, coefDec, expEnt, expDec);
        }else{
            if(posi<dim){
                int sig =0;
                if(signo=='+')
                    sig=1;
                coefEnt = coefEnt<<1;
                coefEnt = coefEnt|sig;
                coefDec = coefDec<<5;
                coefDec = coefDec|coefEnt;
                expEnt = expEnt<<9;
                expEnt = expEnt|coefDec;
                expDec = expDec<<13;
                expDec = expDec|expEnt;
                posi++;
                p.insertar(expDec, posi);
                ordenar();
            }else
                System.out.println("Polinomio lleno");
                
        }
  
    }
    
    public void operaciones(char signo, int coefEnt, int coefDec, int expEnt, int expDec){
        int pos = 0;
        if(pertenece(expEnt, expDec)){
            pos = posicion(expEnt, expDec);
        }
        if(pos>0){
            int newDec=10;
            int newInt=10;
            if(signo == '-'){
                if(getSigno(pos) == '-'){
                    newDec = getCoefDec(pos) + coefDec;
                    newInt = getCoefEnt(pos) + coefEnt;
                    if(newDec>9){
                        newDec = newDec-10;
                        newInt = newInt+1;
                    }
                }else{
                    if(coefEnt>getCoefEnt(pos) && (coefDec<getCoefDec(pos))){
                        newDec = coefDec-getCoefDec(pos) +10;
                        newInt = -coefEnt+getCoefEnt(pos)+1;
                    }
                    if(coefEnt>getCoefEnt(pos) && (coefDec>getCoefDec(pos))){
                        newDec = coefDec-getCoefDec(pos);
                        newInt = -coefEnt+getCoefEnt(pos);
                    }
                    if(coefEnt<getCoefEnt(pos) && (coefDec<getCoefDec(pos))){
                        newDec = getCoefDec(pos) - coefDec;
                        newInt = getCoefEnt(pos)- coefEnt;
                    }
                    if(coefEnt<getCoefEnt(pos) && (coefDec>getCoefDec(pos))){
                        newDec = getCoefDec(pos)-coefDec +10;
                        newInt = getCoefEnt(pos)-coefEnt-1;
                    }
                    if(newInt>0)
                        setSigno('+', pos);
                    else
                        setSigno('-', pos);
                }
            }else{
                if(coefEnt>getCoefEnt(pos) && (coefDec<getCoefDec(pos))){
                        newDec = coefDec-getCoefDec(pos) +10;
                        newInt = coefEnt-getCoefEnt(pos)-1;
                    }
                    if(coefEnt>getCoefEnt(pos) && (coefDec>getCoefDec(pos))){
                        newDec = coefDec-getCoefDec(pos);
                        newInt = coefEnt-getCoefEnt(pos);
                    }
                    if(coefEnt<getCoefEnt(pos) && (coefDec<getCoefDec(pos))){
                        newDec = getCoefDec(pos) - coefDec;
                        newInt = -getCoefEnt(pos) + coefEnt;
                    }
                    if(coefEnt<getCoefEnt(pos) && (coefDec>getCoefDec(pos))){
                        newDec = getCoefDec(pos)-coefDec +10;
                        newInt = -getCoefEnt(pos)+coefEnt+1;
                    }
                    if(newInt>0)
                        setSigno('+', pos);
                    else
                        setSigno('-', pos);
            }
            if((newInt> (-10) && newInt<10) && (newDec> (-10) && newDec<10)){
                setCoefInt(newInt, pos);
                setCoefDec(newDec, pos);
            }
        }
    }
    
    public void ordenar(){
        int i=1;
        while(i<posi){
            
            if(getExpEnt(i)<=getExpEnt(i+1)){
                while((getExpEnt(i)<=getExpEnt(i+1)) && getExpDec(i)<=getExpDec(i+1)){
                    char auxSigno = getSigno(i);
                    int auxCoefEnt = getCoefEnt(i);
                    int auxCoefDec = getCoefDec(i);
                    int auxExpEnt = getExpEnt(i);
                    int auxExpDec = getExpDec(i);
                    setSigno(getSigno(i+1), i);
                    setCoefInt(getCoefEnt(i+1), i);
                    setCoefDec(getCoefDec(i+1), i);
                    setExpEnt(getExpEnt(i+1), i);
                    setExpDec(getExpDec(i+1), i);
                    
                    setSigno(auxSigno, i+1);
                    setCoefInt(auxCoefEnt, i+1);
                    setCoefDec(auxCoefDec, i+1);
                    setExpEnt(auxExpEnt, i+1);
                    setExpDec(auxExpDec, i+1);
                }
            }
            if(getExpEnt(i)>getCoefEnt(i-1)){
                char auxSigno = getSigno(i-1);
                int auxCoefEnt = getCoefEnt(i-1);
                int auxCoefDec = getCoefDec(i-1);
                int auxExpEnt = getExpEnt(i-1);
                int auxExpDec = getExpDec(i-1);
                setSigno(getSigno(i), i-1);
                setCoefInt(getCoefEnt(i), i-1);
                setCoefDec(getCoefDec(i), i-1);
                setExpEnt(getExpEnt(i), i-1);
                setExpDec(getExpDec(i), i-1);

                setSigno(auxSigno, i);
                setCoefInt(auxCoefEnt, i);
                setCoefDec(auxCoefDec, i);
                setExpEnt(auxExpEnt, i);
                setExpDec(auxExpDec, i);
            }
            i++;
        }
    }
    
    public float grado(){
        float max = Float.parseFloat(getExpEnt(1)+"."+getExpDec(1));
        for(int i=1; i<=posi; i++){
            if(max < Float.parseFloat(getExpEnt(i)+"."+getExpDec(i))){
                max = Float.parseFloat(getExpEnt(i)+"."+getExpDec(i));
            }
        }
        return max;
    }
    
    public void setSigno(char signo, int pos){
        int sigg=-1;
        if(signo =='+' || signo=='-'){
           if(signo == '+'){
                sigg = 1;
            }else{
                if(signo== '-'){
                    sigg = 0;
                }
           }
           if(sigg != getSigno(pos)){
               int mask = ((int) Math.pow(2, 1)-1);
                mask = ~mask;
                int x = p.get(1);
                x = mask&x;
                x = sigg|x;
                p.insertar(x, pos);
           }
        }else{
            System.out.println("Error de cambiar signo");
        }
    }
    
    public void setCoefInt(int newCoef, int pos){
        newCoef = Math.abs(newCoef);
        if(newCoef>=0 && newCoef<10 && pos<=posi){
            int mask = ((int) Math.pow(2, 4)-1);
            mask = mask<<1;
            mask = ~mask;
            int x = p.get(pos);
            x = mask&x;
            newCoef = newCoef<<1;
            x = newCoef|x;
            p.insertar(x, pos);
        }else{
            System.out.println("no se puede cambiar coeficiente entero porque los valores deseados no pertenecen al rango o no existe posicion");
        }
        
    }
    
    public void setCoefDec(int newCoefDec, int pos){
        if(newCoefDec>=0 && newCoefDec<10 && pos<=posi){
            int mask = ((int) Math.pow(2, 4)-1);
            mask = mask<<5;
            mask = ~mask;
            int x = p.get(pos);
            x = mask&x;
            newCoefDec = newCoefDec<<5;
            x = newCoefDec|x;
            p.insertar(x, pos);
        }else{
            System.out.println("no se puede cambiar coeficiente  decimal porque los valores deseados no pertenecen al rango o no existe posicion");
        }
        
    }
    
    public void setExpEnt(int newExpEnt, int pos){
        if(newExpEnt>=0 && newExpEnt<10 && pos<=posi){
            int mask = ((int) Math.pow(2, 4)-1);
            mask = mask<<9;
            mask = ~mask;
            int x = p.get(pos);
            x = mask&x;
            newExpEnt = newExpEnt<<9;
            x = newExpEnt|x;
            p.insertar(x, pos);
        }else{
            System.out.println("no se puede cambiar coeficiente  decimal porque los valores deseados no pertenecen al rango o no existe posicion");
        }
        
    }
    
    public void setExpDec(int newExpDec, int pos){
        if(newExpDec>=0 && newExpDec<10 && pos<=posi){
            int mask = ((int) Math.pow(2, 4)-1);
            mask = mask<<13;
            mask = ~mask;
            int x = p.get(pos);
            x = mask&x;
            newExpDec = newExpDec<<13;
            x = newExpDec|x;
            p.insertar(x, pos);
        }else{
            System.out.println("no se puede cambiar coeficiente  decimal porque los valores deseados no pertenecen al rango o no existe posicion");
        }
        
    }
    
    public boolean vacia(){
        return posi==0;
    }
    
    public char getSigno(int pos){
        int mask = (int)(Math.pow(2, 1)-1);
        int x = p.get(pos);
        mask = mask&x;
        if(mask==1)
            return '+';
        else
            return '-';
    }
    
    public int getCoefEnt(int pos){
        int mask = (int)(Math.pow(2, 4)-1);
        int x = p.get(pos);
        mask = mask<<1;
        mask = mask&x;
        mask = mask>>>1;
        return mask;
    }
    
    public int getCoefDec(int pos){
        int mask = (int)(Math.pow(2, 4)-1);
        int x = p.get(pos);
        mask = mask<<5;
        mask = mask&x;
        mask = mask>>>5;
        return mask;
    }
    
    public int getExpEnt(int pos){
        int mask = (int)(Math.pow(2, 4)-1);
        int x = p.get(pos);
        mask = mask<<9;
        mask = mask&x;
        mask = mask>>>9;
        return mask;
    }
    
    public int getExpDec(int pos){
        int mask = (int)(Math.pow(2, 4)-1);
        int x = p.get(pos);
        mask = mask<<13;
        mask = mask&x;
        mask = mask>>>13;
        return mask;
    }
    
    public int getPosi(){
        return posi;
    }
    
    public float valorEnt(int pos){
        int entero = getCoefEnt(pos);
        int decimal = getCoefDec(pos);
        float valor = Float.parseFloat(entero+"."+decimal);
        return valor;
    }
    
    public float valorExp(int pos){
        int entero = getExpEnt(pos);
        int decimal = getExpDec(pos);
        float valor = Float.parseFloat(entero+"."+decimal);
        return valor;
    }
    
    public boolean pertenece(int expEnt, int expDec){
        boolean p = false;
        for(int i=1; i<=posi; i++){
            if((getExpEnt(i)==expEnt) && (getExpDec(i)==expDec))
                p = true;
        }
        return p;
    }
    
    public int posicion(int expEnt, int expDec){
        int pos=-1;
        for(int i=1; i<=posi; i++){
            if((getExpEnt(i)==expEnt) && (getExpDec(i)==expDec))
                pos = i;
        }
        return pos;
    }
    
    public String toStringg(){
        String s = "P(x)= ";
        for(int i=1; i<=posi ; i++){
            if((getExpEnt(i)==0) && (getExpDec(i)==0))
                s =  s + getSigno(i) + getCoefEnt(i) +"." + getCoefDec(i) ;
            else{
                if((getCoefEnt(i)!=0) && (getCoefDec(i)!=0)){
                    s =  s + getSigno(i) + "(" + getCoefEnt(i) +"." + getCoefDec(i) + ") x^(" + getExpEnt(i)+ "." + getExpDec(i) + ") ";
                }
                
            }
        }        
        return s;
    }
    
    public static void main(String[] args) {
        PolinomioDecimal p = new PolinomioDecimal(3);
        p.insertar('-', 7,9, 2, 1);
        p.insertar('+', 5, 7, 0, 0);
        p.insertar('+', 6, 3, 7,1);
        //p.insertar('-', 7,9, 3, 0);
        
        System.out.println(p.toStringg());
        //System.out.println(p.valorExp(1));
    }
}
