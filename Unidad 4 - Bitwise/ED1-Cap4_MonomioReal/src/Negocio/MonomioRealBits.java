
package Negocio;


public class MonomioRealBits {

    VectorNbits1 M;
    int signo;
    FraccionBits coef ;
    FraccionBits exp;
    public int cantBCoef;
    public int cantBExp;
    
    public MonomioRealBits(char sig, int coefiNume, int coefiDeno, int expNume, int expDeno){
        coef = new FraccionBits(sig, coefiNume, coefiDeno);
        exp = new FraccionBits('+', expNume, expDeno);
        cantBCoef = coef.cantBNume + coef.cantBDeno;
        cantBExp = exp.cantBNume + exp.cantBDeno;
        M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
        insertarMonomioRealNBits(sig, coefiNume, coefiDeno, expNume, expDeno);
    }
    
    public MonomioRealBits(){
        coef = new FraccionBits('+', 0, 0);
        exp = new FraccionBits('+', 0, 0);
       M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
    }
    
    public void insertarMonomioRealNBits(char sig, int coefiNume, int coefiDeno, int expNume, int expDeno){
        if(sig =='+' || sig=='-'){
           if(sig == '+'){
                signo = 1;
                //coef.setSigno('+');
            }else{
                if(sig== '-'){
                    signo = 0;
                    //coef.setSigno('-');
                }
           }
           coef.numerador = Math.abs(coefiNume);
           coef.denominador = Math.abs(coefiDeno);
           exp.numerador = Math.abs(expNume);
           exp.denominador = Math.abs(expDeno);
           coef.numerador = coef.numerador<<1;
           coef.numerador = coef.numerador | signo;
           coef.denominador = coef.denominador << coef.cantBNume+1;
           coef.denominador = coef.denominador | coef.numerador;
           exp.numerador = exp.numerador<<cantBCoef+1;
           exp.numerador = exp.numerador|coef.denominador;
           exp.denominador = exp.denominador<<cantBCoef+exp.cantBNume+1;
           exp.denominador = exp.denominador | exp.numerador;
           M.insertar(exp.denominador, 1);
       }else 
           System.out.println("Error de signo");
    }
    
    public void setSigno(char sig){
        int sigg=-1;
        if(sig =='+' || sig=='-'){
           if(sig == '+'){
                sigg = 1;
            }else{
                if(sig== '-'){
                    sigg = 0;
                }
           }
           if(sigg != getSigno()){
               int mask = ((int) Math.pow(2, 1)-1);
               mask = ~mask;
               int x = M.get(1);
               x = mask&x;
               x = sigg|x;
               M.insertar(x, 1);
           }
        }else{
            System.out.println("Error de cambiar signo");
        }
    }
    
    public void setCoeficiente(int coefiNume, int coefiDeno){
         if(coefiNume!=0 || coefiDeno!=0){
            coef.setNumerador(coefiNume);
            coef.setDenominador(coefiDeno);
            int cantBCS = coef.cantBNume + coef.cantBDeno;
            char masksigno = getSigno();
            FraccionBits maskexp = getExponente();
            cantBCoef = cantBCS;
            M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
            insertarMonomioRealNBits(masksigno, coefiNume, coefiDeno, maskexp.getNumerador(), maskexp.getDenominador());
            
         }else{
             System.out.println("El coeficiente no puede ser cero");
             System.exit(1);
         }
    }
    
    public void setExponente(int expNume, int expDeno){
        if(expNume!=0 || expDeno!=0){
            exp.setNumerador(expNume);
            exp.setDenominador(expDeno);
            int cantBCS = exp.cantBNume + exp.cantBDeno;
            char masksigno = getSigno();
            FraccionBits maskcoef = getCoeficiente();
            cantBExp = cantBCS;
            M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
            insertarMonomioRealNBits(masksigno, maskcoef.getNumerador(), maskcoef.getDenominador(), expNume, expDeno);
            
         }else{
             System.out.println("El exponente no puede ser cero");
             System.exit(1);
         }
    }
    
    public char getSigno(){
        int mask = ((int) Math.pow(2, 1)-1);
        int x = M.get(1);
        mask&=x;
        if(mask ==1){
            return '+';
        }else{
            return '-';
        }
    }
    
    public FraccionBits getCoeficiente(){
        int mask1 = ((int) Math.pow(2, coef.cantBNume)-1);
        int mask2 = ((int) Math.pow(2, coef.cantBDeno)-1);
        mask1 = mask1<<1;
        int x = M.get(1);
        mask1 = mask1&x;
        mask1 = mask1>>>1;
        mask2 = mask2<<coef.cantBNume+1;
        mask2 = mask2&x;
        mask2 = mask2>>>coef.cantBNume+1;
        FraccionBits f = new FraccionBits(getSigno(), mask1, mask2);
        return f;
    }

    public FraccionBits getExponente(){
        int mask1 = ((int) Math.pow(2, exp.cantBNume)-1);
        int mask2 = ((int) Math.pow(2, exp.cantBDeno)-1);
        mask1 = mask1<<cantBCoef+1;
        int x = M.get(1);
        mask1 = mask1&x;
        mask1 = mask1>>>cantBCoef+1;
        mask2 = mask2<<cantBCoef+exp.cantBNume+1;
        mask2 = mask2&x;
        mask2 = mask2>>>cantBCoef+exp.cantBNume+1;
        FraccionBits f = new FraccionBits('+', mask1, mask2);
        return f;
    }
    
    public void Sumar(MonomioRealBits A, MonomioRealBits B){
    int sigg =-1;
        char sig='s';
        if((A.getExponente().getNumerador() == B.getExponente().getNumerador()) && (A.getExponente().getDenominador()== B.getExponente().getDenominador())){
            
            coef.Sumar(A.getCoeficiente(), B.getCoeficiente());
            exp = A.getExponente();
            if(coef.getSigno() == '+'){
                sig = '+';
                sigg = 1;
            }else{
                sig = '-';
                sigg = 0;
            }
            setSigno(sig);
            setCoeficiente(coef.getNumerador(), coef.getDenominador());
            setExponente(A.getExponente().getNumerador(), A.getExponente().getDenominador());
        }else{
            System.out.println("Los monomios no pueden sumarse porque no tienen el mismo exponente");
        }
    }
    
    public void Restar(MonomioRealBits A, MonomioRealBits B){
        int sigg =-1;
        char sig='s';
        if((A.getExponente().getNumerador() == B.getExponente().getNumerador()) && (A.getExponente().getDenominador()== B.getExponente().getDenominador())){
            
            coef.Restar(A.getCoeficiente(), B.getCoeficiente());
            exp = A.getExponente();
            if(coef.getSigno() == '+'){
                sig = '+';
                sigg = 1;
            }else{
                sig = '-';
                sigg = 0;
            }
            setSigno(sig);
            setCoeficiente(coef.getNumerador(), coef.getDenominador());
            setExponente(A.getExponente().getNumerador(), A.getExponente().getDenominador());
        }else{
            System.out.println("Los monomios no pueden sumarse porque no tienen el mismo exponente");
        }
    }
    
    public void Multiplicar(MonomioRealBits A, MonomioRealBits B){
        //MonomioRealBits m1 = new MonomioRealBits();
        coef.Multiplicar(A.getCoeficiente(), B.getCoeficiente());
        if(A.getSigno()=='-' || B.getSigno()=='-'){
            if(A.getSigno() == '-'){
                if(B.getSigno()=='+'){
                    setSigno('-');
                }else{
                    setSigno('+');
                }
            }else{
                if(A.getSigno()=='+'){
                    setSigno('-');
                }else{
                    setSigno('+');
                }
            }
        }else{
            setSigno('+');
        }
        exp.Sumar(A.getExponente(), B.getExponente());
        setCoeficiente(coef.getNumerador(), coef.getDenominador());
        setExponente(exp.getNumerador(), exp.getDenominador());
      
    }
    
    public void Dividir(MonomioRealBits A, MonomioRealBits B){
        if((A.getExponente().getNumerador()/A.getExponente().getDenominador()) >= (B.getExponente().getNumerador()/B.getExponente().getDenominador())){
            coef.Dividir(A.getCoeficiente(), B.getCoeficiente());
            if(A.getSigno() =='-'){
                if(B.getSigno() == '+')
                    setSigno('-');
                else
                    setSigno('+');
            }else{
                if(B.getSigno() == '-'){
                    setSigno('-');
                }else{
                    setSigno('+');
                }
            }
            if(B.getSigno() =='-'){
                if(A.getSigno() == '+')
                    setSigno('-');
                else
                    setSigno('+');
            }else{
                if(A.getSigno() == '-'){
                    setSigno('-');
                }else{
                    setSigno('+');
                }
            
            }
            exp.Restar(A.getExponente(), B.getExponente());
            setCoeficiente(coef.getNumerador(), coef.getDenominador());
            setExponente(exp.getNumerador(), exp.getDenominador());
        }else
            System.out.println("Error: No se puede ejecutar la division");
    }
    
    public float Evaluar(int x){
        float valor;
        //Math.pow(base,potencia);
        if(x == 0)
            valor = getCoeficiente().getNumerador() / getCoeficiente().getDenominador();
        else
            if(getExponente().getNumerador()==0){
                valor = 0;
            }else{
                float val = getExponente().getNumerador() / getExponente().getDenominador();
                valor = ((int) Math.pow(x, val));
            }
            if(getSigno() == '-'){
                valor = - valor * getCoeficiente().getNumerador() / getCoeficiente().getDenominador();
            }else{
                valor = valor * getCoeficiente().getNumerador() / getCoeficiente().getDenominador();
            }
        return valor;
    }
    
    public void derivar(){
        if(getExponente().getNumerador() == 0){
            exp.setNumerador(1);
            exp.setDenominador(1);
            coef.setNumerador(0);
            coef.setDenominador(0);
        }else{
            coef.Multiplicar(getCoeficiente(), getExponente());
            FraccionBits f = new FraccionBits('+', 1, 1);
            exp.Restar(getExponente(), f);
        }
        setCoeficiente(coef.getNumerador(),coef.getDenominador());
        setExponente(exp.getNumerador(), exp.getDenominador());
    }
    
    public void integral(){
        if(getExponente().getNumerador() == 0){
            coef.setNumerador(0);
            coef.setDenominador(0);
            exp.setNumerador(1);
            exp.setDenominador(1);
        }else{
            FraccionBits f = new FraccionBits('+', 1, 1);
            exp.Sumar(getExponente(), f);
            coef.Dividir(getCoeficiente(), getExponente());
        }
        setCoeficiente(coef.getNumerador(), coef.getDenominador());
        setExponente(exp.getNumerador(), exp.getDenominador());
    }
    
    @Override
    
    public String toString(){
        String s = " ";
        s = s + "       " + getCoeficiente().getNumerador() + "         " + getExponente().getNumerador() 
                +"\nC= "+getSigno() + " (-----) x^(-----)"
                +"\n        "+getCoeficiente().getDenominador()+"         "+getExponente().getDenominador();

        return s;
    }
    
    public String toString2(){
        String s = " ";
        s = s + getSigno() + getCoeficiente() + "x^" + getExponente() ;
                /*+"\ncantidad de bits utilizados por el coeficiente: "+cantBCoef
                +"\ncantidad de bits utilizados por el coeficiente: "+cantBExp;*/
        return s;
    }
  
    
}
