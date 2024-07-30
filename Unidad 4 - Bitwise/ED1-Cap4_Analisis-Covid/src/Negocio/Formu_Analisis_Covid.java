
package Negocio;


public class Formu_Analisis_Covid {
    VectorNbits1 f[];
    int cant = 100;
    int cantR;
    String vnombre[];
    
    public Formu_Analisis_Covid(){
        f = new VectorNbits1[3];
        f[0] = new VectorNbits1(cant, 24);
        f[1] = new VectorNbits1(cant, 19);
        f[2] = new VectorNbits1(cant, 9);
        vnombre = new String[cant];
        cantR = 0;
    }
    public void insertar(int ci, int edad, int sexo, int peso, String nombre,int fiebre, int dolorC, int dolorM, int tos,
                         int faltaR, int perdidaO, int dolorG, int diarr, int perdidaG){
        cantR++;
        f[0].insertar(ci, cantR);
        sexo = sexo<<7;
        sexo = sexo|edad;
        peso = peso<<8;
        peso = peso|sexo;
        f[1].insertar(peso, cantR);
        dolorC = dolorC<<1;
        dolorC = dolorC|fiebre;
        dolorM = dolorM<<2;
        dolorM = dolorM|dolorC;
        tos = tos<<3;
        tos = tos|dolorM;
        faltaR = faltaR<<4;
        faltaR = faltaR|tos;
        perdidaO = perdidaO<<5;
        perdidaO = perdidaO|faltaR;
        dolorG = dolorG<<6;
        dolorG = dolorG|perdidaO;
        diarr = diarr<<7;
        diarr = diarr|dolorG;
        perdidaG = perdidaG<<8;
        perdidaG = perdidaG|diarr;
        f[2].insertar(perdidaG, cantR);
        vnombre[cantR-1] = nombre;
    }
    
    public int getCi(int pos){
        return f[0].get(pos);
    }
    
    public String getNombre(int pos){
        String nom = vnombre[pos-1];
        return nom;
    }
    
    public int getEdad(int pos){
        int mask = ((int) Math.pow(2, 7)-1);
        int x = f[1].get(pos);
        mask&=x;
        return mask;
    }
    
    public String getSexo(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<7;
        int x = f[1].get(pos);
        mask&=x;
        mask>>>=7;
        if(mask == 1)
            return "Masculino";
        else
            return "Femenino";
    }
    
    public float getPeso(int pos){
        int mask = ((int) Math.pow(2, 11)-1);
        mask = mask<<8;
        int x = f[1].get(pos);
        mask&=x;
        mask>>>=8;
        return mask;
    }
    public boolean fiebre(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        int x = f[2].get(pos);
        mask&=x;
        return (mask==1);
    }
    public boolean dolorC(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<1;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>1;
        return (mask==1);
    }
    public boolean dolorM(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<2;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>2;
        return (mask==1);
    }
    public boolean tos(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<3;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>3;
        return (mask==1);
        
    }public boolean faltaR(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<4;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>4;
        return (mask==1);
    }
    public boolean perdidaO(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<5;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>5;
        return (mask==1);
    }
    public boolean dolorG(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<6;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>6;
        return (mask==1);
    }
    public boolean diarr(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<7;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>7;
        return (mask==1);
    }
    public boolean perdidaG(int pos){
        int mask = ((int) Math.pow(2, 1)-1);
        mask = mask<<8;
        int x = f[2].get(pos);
        mask&=x;
        mask = mask>>>8;
        return (mask==1);
    }
    
    @Override
    
    public String toString(){
        String s = "Formulario Analisis Covid:\n";
        for(int i=1 ; i <=cantR ; i++){
            if(getCi(i) > 0){
                s = s + "\n---------- "+i+" ---------\n"+
                        "\nNro: "+getCi(i)+"\nNombre: "+getNombre(i)+"\nEdad: "+getEdad(i)+" años\n" +"Sexo: "+getSexo(i)+
                        "\nPeso: "+getPeso(i) +"kg\nSINTOMAS:\nFiebre: "+fiebre(i)+"\ndolor de cabeza: "+dolorC(i)+
                        "\ndolor muscular: "+dolorM(i)+"\ntos: "+tos(i)+"\nfalta de respiracion: "+faltaR(i)+
                        "\nperdida de olfato: "+perdidaO(i)+"\ndolor de garganta: "+dolorG(i)+"\ndiarrea: "+diarr(i)+
                        "\nPerdida del gusto: "+perdidaG(i)+"\n";
            }
        }
        return s;
    }
    
    
    
}
