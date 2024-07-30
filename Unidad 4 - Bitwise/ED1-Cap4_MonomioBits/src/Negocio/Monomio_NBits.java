
package Negocio;


public class Monomio_NBits {
    VectorNbits1 M;
    int signo;
    int coef;
    int exp;
    int cantBCoef;
    int cantBExp;
    
    public Monomio_NBits(char sig, int coefi, int expo){
        String repreBinCoef = Integer.toBinaryString(coefi);
        String repreBinExp = Integer.toBinaryString(expo);
        cantBCoef = repreBinCoef.length();
        cantBExp = repreBinExp.length();
        M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
        insertarMonomioNBits(sig, coefi, expo);
    }
    
    public Monomio_NBits(){
       M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
    }
    
    public void insertarMonomioNBits(char sig, int coefi, int expo){
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
           exp = exp<<cantBCoef+1;
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
            String repreBinCS = Integer.toBinaryString(coefi);
            int cantBCS = repreBinCS.length();
            char masksigno = getSigno();
            int maskexp = getExponente();
            cantBCoef = cantBCS;
            M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
            insertarMonomioNBits(masksigno, coefi, maskexp);
            
         }else{
             System.out.println("El coeficiente no puede ser cero");
             System.exit(1);
         }
    }
    
    public void setExponente(int expoo){
         if(expoo != 0){
            expoo = Math.abs(expoo);
            String repreBinES = Integer.toBinaryString(expoo);
            int cantBES = repreBinES.length();
            char masksigno = getSigno();
            int maskcoef = getCoeficiente();
            cantBExp = cantBES;
            M = new VectorNbits1(1, 1+cantBCoef+cantBExp);
            insertarMonomioNBits(masksigno, maskcoef, expoo);
            
         }else{
             System.out.println("El coeficiente no puede ser cero");
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
        int mask = ((int) Math.pow(2, cantBCoef)-1);
        mask = mask<<1;
        int x = M.get(1);
        mask&=x;
        mask>>>=1;
        return mask;
    }
    
    public int getExponente(){
        int mask = ((int) Math.pow(2, cantBExp)-1);
        mask = mask<<cantBCoef+1;
        int x = M.get(1);
        mask&=x;
        mask>>>=cantBCoef+1;
        return mask;
    }
    
    public void Sumar(Monomio_NBits A, Monomio_NBits B){
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
            setExponente(A.getExponente());
            //insertarMonomioNBits(sig, coef, exp);
        }else{
            System.out.println("Los monomios no pueden sumarse porque no tienen el mismo exponente");
        }
    }
    
    public void Restar(Monomio_NBits A, Monomio_NBits B){
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
            setExponente(A.getExponente());
            //insertarMonomio(sig, coef, exp);
        }else{
            System.out.println("Los monomios no pueden sumarse porque no tienen el mismo exponente");
        }
    }
    
    public void Multiplicar(Monomio_NBits A, Monomio_NBits B){
        coef = A.getCoeficiente()* B.getCoeficiente();
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
        setExponente(A.getExponente() + B.getExponente());

    }
    
    public void Dividir(Monomio_NBits A, Monomio_NBits B){
        if(A.getExponente() >= B.getExponente()){
            coef = A.getCoeficiente() / B.getCoeficiente() ;
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
            setExponente(A.getExponente() - B.getExponente());
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
        s = s + getSigno() + Math.abs(getCoeficiente()) + "x^" + getExponente() 
                +"\ncantidad de bits utilizados por el coeficiente: "+cantBCoef
                +"\ncantidad de bits utilizados por el coeficiente: "+cantBExp;
        return s;
    }
  
}

    

