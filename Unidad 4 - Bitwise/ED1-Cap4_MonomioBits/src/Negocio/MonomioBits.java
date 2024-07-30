
package Negocio;

public class MonomioBits {
    VectorNbits1 M;
    int signo;
    int coef;
    int exp;
    
    public MonomioBits(char sig, int coefi, int expo){
       M = new VectorNbits1(1, 11);
        insertarMonomio(sig, coefi, expo);
    }
    
    public MonomioBits(){
       M = new VectorNbits1(1, 11);
    }
    
    public void insertarMonomio(char sig, int coefi, int expo){
        if(sig =='+' || sig=='-'){
           if(sig == '+'){
                signo = 1;
            }else{
                if(sig== '-'){
                    signo = 0;
                }
           }
           coef = Math.abs(coefi);
           exp = expo;
           coef = coef<<1;
           coef = coef|signo;
           exp = exp<<6;
           exp = exp|coef;
           M.insertar(exp, 1);
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
    
    public void setCoeficiente(int coefi){
         if(coefi != 0){
            coefi = Math.abs(coefi);
            int mask = ((int) Math.pow(2, 5)-1);
            mask = mask<<1;
            mask = ~mask;
            int x = M.get(1);
            x = mask&x;
            coefi = coefi<<1;
            x = coefi|x;
            M.insertar(x, 1);
 
         }else{
             System.out.println("El coeficiente no puede ser cero");
             System.exit(1);
         }
    }
    
    public void setExponente(int expo){
         if(expo != 0){
            expo = Math.abs(expo);
            int mask = ((int) Math.pow(2, 5)-1);
            mask = mask<<6;
            mask = ~mask;
            int x = M.get(1);
            x = mask&x;
            expo = expo<<6;
            x = expo|x;
            M.insertar(x, 1);
 
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
    
    public int getCoeficiente(){
        int mask = ((int) Math.pow(2, 5)-1);
        mask = mask<<1;
        int x = M.get(1);
        mask&=x;
        mask>>>=1;
        return mask;
    }
    
    public int getExponente(){
        int mask = ((int) Math.pow(2, 5)-1);
        mask = mask<<6;
        int x = M.get(1);
        mask&=x;
        mask>>>=6;
        return mask;
    }
    
    public void Sumar(MonomioBits A, MonomioBits B){
        int sigg =-1;
        char sig='s';
        if(A.getExponente() == B.getExponente()){
            if(A.getSigno()=='-' || B.getSigno()=='-'){
                if(A.getSigno() == '-'){
                    if(B.getSigno() =='+')
                        coef = -A.getCoeficiente() + B.getCoeficiente();
                    else
                        coef = -A.getCoeficiente() - B.getCoeficiente();
                }else{
                    if(B.getSigno() == '-'){
                        if(A.getSigno() =='+')
                            coef = A.getCoeficiente() - B.getCoeficiente();
                        else
                            coef = -A.getCoeficiente() - B.getCoeficiente();
                    }
                }
            }else{
                coef = A.getCoeficiente() + B.getCoeficiente();
            }
            exp = A.getExponente();
            if(coef >= 0){
                sig = '+';
                sigg = 1;
            }else{
                sig = '-';
                sigg = 0;
            }
            setSigno(sig);
            coef = Math.abs(coef);
            setCoeficiente(coef);
            setExponente(exp);
            //insertarMonomio(sig, coef, exp);
        }else{
            System.out.println("Los monomios no pueden sumarse porque no tienen el mismo exponente");
        }
    }
    
    public void Restar(MonomioBits A, MonomioBits B){
        int sigg =-1;
        char sig='s';
        if(A.getExponente() == B.getExponente()){
            if(A.getSigno()=='-' || B.getSigno()=='-'){
                if(A.getSigno() == '-'){
                    if(B.getSigno() =='+')
                        coef = -A.getCoeficiente() - B.getCoeficiente();
                    else
                        coef = -A.getCoeficiente() + B.getCoeficiente();
                }else{
                    if(B.getSigno() == '-'){
                        if(A.getSigno() =='+')
                            coef = A.getCoeficiente() + B.getCoeficiente();
                        else
                            coef = -A.getCoeficiente() + B.getCoeficiente();
                    }
                }
            }else{
                coef = A.getCoeficiente() - B.getCoeficiente();
            }
            exp = A.getExponente();
            if(coef >= 0){
                sig = '+';
                sigg = 1;
            }else{
                sig = '-';
                sigg = 0;
            }
            coef = Math.abs(coef);
            setCoeficiente(coef);
            setExponente(exp);
            //insertarMonomio(sig, coef, exp);
        }else{
            System.out.println("Los monomios no pueden sumarse porque no tienen el mismo exponente");
        }
    }
    
    public void Multiplicar(MonomioBits A, MonomioBits B){
        coef = A.getCoeficiente()* B.getCoeficiente();
        exp = A.getExponente() + B.getExponente() ;
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
        setCoeficiente(coef);
        setExponente(exp);

    }
    
    public void Dividir(MonomioBits A, MonomioBits B){
        if(A.getExponente() >= B.getExponente()){
            coef = A.getCoeficiente() / B.getCoeficiente() ;
            exp = A.getExponente() - B.getExponente() ;
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
            setCoeficiente(coef);
            setExponente(exp);
        }else
            System.out.println("Error: No se puede ejecutar la division");
    }
    
    public int Evaluar(int x){
        int valor;
        //Math.pow(base,potencia);
        if(x == 0)
            valor = getCoeficiente();
        else
            valor = ((int) Math.pow(x, getExponente()));
            valor = valor * getCoeficiente();
        return valor;
    }
    
    public void derivar(){
        if(getExponente() == 0){
            exp = 1;
            coef = 0;
        }else{
            coef = getCoeficiente() * getExponente();
            exp = getExponente() - 1 ;
        }
        setCoeficiente(coef);
        setExponente(exp);
    }
    
    public void integral(){
        if(getExponente() == 0){
            coef = 0 ;
            exp = 1;
        }else{
            exp = getExponente() + 1 ;
            coef = getCoeficiente() / getExponente() ;
        }
        setCoeficiente(coef);
        setExponente(exp);
    }
    
    @Override
    
    public String toString(){
        String s = " ";
        s = s + getSigno() + Math.abs(getCoeficiente()) + "x^" + getExponente() ;
        return s;
    }

    
    
}
