
package Negocio;

public class FraccionBits {
    VectorNbits1 F ;
    int signo;
    int numerador;
    int denominador;
    int cantBNume;
    int cantBDeno;
    
    public FraccionBits(char sig, int nume, int deno){
        if(nume == 0 || deno ==0){
            if(nume==0){
                numerador = 0;
                denominador = 0;
                String repreBinNS = Integer.toBinaryString(numerador);
                int cantBNS = repreBinNS.length();
                String repreBinDS = Integer.toBinaryString(denominador);
                int cantBDS = repreBinDS.length();
                cantBNume = cantBNS;
                cantBDeno = cantBDS;
                F = new VectorNbits1(1, 1+cantBNume+cantBDeno);
                insertarFraccionNBits('+', numerador, denominador);
            }else{
                if(deno == 0){
                    System.out.println("Error de creacion,denominador no puede ser 0");
                }
            }
        }else{
            String repreBinNume = Integer.toBinaryString(nume);
            String repreBinDeno = Integer.toBinaryString(deno);
            cantBNume = repreBinNume.length();
            cantBDeno = repreBinDeno.length();
            F = new VectorNbits1(1, 1+cantBNume+cantBDeno);
            insertarFraccionNBits(sig, nume, deno);
        }
        
    }
    
    public FraccionBits() {
        F = new VectorNbits1(1, 1+cantBNume+cantBDeno);

    }
    
    public void insertarFraccionNBits(char sig, int nume, int deno){
        if(sig =='+' || sig=='-'){
           if(sig == '+'){
                signo = 1;
            }else{
                if(sig== '-'){
                    signo = 0;
                }
           }
           numerador = Math.abs(nume);
           denominador = Math.abs(deno);
           numerador = numerador<<1;
           numerador = numerador|signo;
           denominador = denominador<<cantBNume+1;
           denominador = denominador|numerador;
           F.insertar(denominador, 1);
       }else 
           System.out.println("Error de signo");
    }
    
    public char getSigno(){
        int mask = ((int) Math.pow(2, 1)-1);
        int x = F.get(1);
        mask&=x;
        if(mask ==1){
            return '+';
        }else{
            return '-';
        }
    }
    
    public int getNumerador(){
        int mask = ((int) Math.pow(2, cantBNume)-1);
        mask = mask<<1;
        int x = F.get(1);
        mask = mask&x;
        mask = mask>>>1;
        return mask;
    }
    
    public int getDenominador(){
        int mask = ((int) Math.pow(2, cantBDeno)-1);
        mask = mask<<1+cantBNume;
        int x = F.get(1);
        mask = mask&x;
        mask = mask>>>1+cantBNume;
        return mask;
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
               int x = F.get(1);
               x = mask&x;
               x = sigg|x;
               F.insertar(x, 1);
           }
        }else{
            System.out.println("Error de cambiar signo");
        }
    }
    
    public void setNumerador(int nume){
        
        if(nume != 0){
            nume = Math.abs(nume);
            String repreBinNS = Integer.toBinaryString(nume);
            int cantBNS = repreBinNS.length();
            char masksigno = getSigno();
            int maskdeno = getDenominador();
            cantBNume = cantBNS;
            F = new VectorNbits1(1, 1+cantBNume+cantBDeno);
            insertarFraccionNBits(masksigno, nume, maskdeno);
        }else{
            numerador = 0;
            denominador = 0;
            String repreBinNS = Integer.toBinaryString(numerador);
            int cantBNS = repreBinNS.length();
            String repreBinDS = Integer.toBinaryString(denominador);
            int cantBDS = repreBinDS.length();
            cantBNume = cantBNS;
            cantBDeno = cantBDS;
            F = new VectorNbits1(1, 1+cantBNume+cantBDeno);
            insertarFraccionNBits('+', numerador, denominador);
         }
    }
    
    public void setDenominador(int deno){
        if(deno != 0){
           deno = Math.abs(deno);
           String repreBinDS = Integer.toBinaryString(deno);
           int cantBDS = repreBinDS.length();
           char masksigno = getSigno();
           int masknume = getNumerador();
           cantBDeno = cantBDS;
           F = new VectorNbits1(1, 1+cantBNume+cantBDeno);
           insertarFraccionNBits(masksigno, masknume, deno);
            
        }else
            System.out.println("Error cambiar denominador: No puede ser 0");
    }
    
    public void Sumar(FraccionBits A, FraccionBits B){
        int sigg =-1;
        char sig = ' ';
        int deno = A.getDenominador() * B.getDenominador() ;
        int nume = getNumerador();
        if(A.getSigno()=='-' || B.getSigno()=='-'){
                if(A.getSigno() == '-'){
                    if(B.getSigno() =='+')
                        nume = -(A.getNumerador() * B.getDenominador()) + (B.getNumerador() * A.getDenominador());
                    else
                        nume = -(A.getNumerador() * B.getDenominador()) - (B.getNumerador() * A.getDenominador());
                }else{
                    if(B.getSigno() == '-'){
                        if(A.getSigno() =='+')
                            nume = (A.getNumerador() * B.getDenominador()) - (B.getNumerador() * A.getDenominador());
                        else
                            nume = -(A.getNumerador() * B.getDenominador()) - (B.getNumerador() * A.getDenominador());
                    }
                }
        }else{
            nume = (A.getNumerador() * B.getDenominador()) + (B.getNumerador() * A.getDenominador());
        }
        if(nume >= 0){
            sig = '+';
            sigg = 1;
        }else{
            sig = '-';
            sigg = 0;
        }
        setSigno(sig);
        nume = Math.abs(nume);
        setNumerador(nume);
        setDenominador(deno);
        Simplificar();
    }
        
    public void Restar(FraccionBits A, FraccionBits B){
        int sigg =-1;
        char sig = ' ';
        int deno = A.getDenominador() * B.getDenominador() ;
        int nume = getNumerador();
        if(A.getSigno()=='-' || B.getSigno()=='-'){
                if(A.getSigno() == '-'){
                    if(B.getSigno() =='+')
                        nume = -(A.getNumerador() * B.getDenominador()) - (B.getNumerador() * A.getDenominador());
                    else
                        nume = -(A.getNumerador() * B.getDenominador()) + (B.getNumerador() * A.getDenominador());
                }else{
                    if(B.getSigno() == '-'){
                        if(A.getSigno() =='+')
                            nume = (A.getNumerador() * B.getDenominador()) + (B.getNumerador() * A.getDenominador());
                        else
                            nume = -(A.getNumerador() * B.getDenominador()) + (B.getNumerador() * A.getDenominador());
                    }
                }
        }else{
            nume = (A.getNumerador() * B.getDenominador()) - (B.getNumerador() * A.getDenominador());
        }
        if(nume >= 0){
            sig = '+';
            sigg = 1;
        }else{
            sig = '-';
            sigg = 0;
        }
        setSigno(sig);
        nume = Math.abs(nume);
        setNumerador(nume);
        setDenominador(deno);
        Simplificar();
    }
    
    public void Multiplicar(FraccionBits A, FraccionBits B){
        int sigg =-1;
        char sig = 's';
        int deno = A.getDenominador() * B.getDenominador() ;
        int nume = getNumerador();
        if(A.getSigno()=='-' || B.getSigno()=='-'){
                if(A.getSigno() == '-'){
                    if(B.getSigno() =='+')
                        nume = -(A.getNumerador() * B.getNumerador());
                    else
                        nume = (A.getNumerador() * B.getNumerador());
                }else{
                    if(B.getSigno() == '-'){
                        if(A.getSigno() =='+')
                            nume = -(A.getNumerador() * B.getNumerador());
                        else
                            nume = (A.getNumerador() * B.getNumerador());
                    }
                }
        }else{
            nume = (A.getNumerador() * B.getNumerador());
        }
        if(nume >= 0){
            sig = '+';
            sigg = 1;
        }else{
            sig = '-';
            sigg = 0;
        }
        setSigno(sig);
        nume = Math.abs(nume);
        setNumerador(nume);
        setDenominador(deno);
        Simplificar();
    }
    
    public void Dividir(FraccionBits A, FraccionBits B){
        int sigg =-1;
        char sig = 's';
        int deno = A.getDenominador() * B.getNumerador();
        int nume = getNumerador();
        if(A.getSigno()=='-' || B.getSigno()=='-'){
                if(A.getSigno() == '-'){
                    if(B.getSigno() =='+')
                        nume = -(A.getNumerador() * B.getDenominador());
                    else
                        nume = (A.getNumerador() * B.getDenominador());
                }else{
                    if(B.getSigno() == '-'){
                        if(A.getSigno() =='+')
                            nume = -(A.getNumerador() * B.getDenominador());
                        else
                            nume = (A.getNumerador() * B.getDenominador());
                    }
                }
        }else{
            nume = (A.getNumerador() * B.getDenominador());
        }
        if(nume >= 0){
            sig = '+';
            sigg = 1;
        }else{
            sig = '-';
            sigg = 0;
        }
        setSigno(sig);
        nume = Math.abs(nume);
        setNumerador(nume);
        setDenominador(deno);
        Simplificar();
    }
        
    public int MCD(){
        int u = Math.abs(getNumerador());
        int v = Math.abs(getDenominador());
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
        
    public void Simplificar(){
        int x = MCD();
        int nume = getNumerador() / x;
        int deno = getDenominador() / x;
        setNumerador(nume);
        setDenominador(deno);
    }
    
    @Override
    
    public String toString(){
        String c = "C = ";
        c = "             " + getNumerador()+ "\n"+c+getSigno()+" ------"+"\n             "+getDenominador();
        /*+"\ncantidad de bits utilizados por el numerador: "+cantBNume
        +"\ncantidad de bits utilizados por el denominador: "+cantBDeno + "\n";*/
        return c;
    }
}
