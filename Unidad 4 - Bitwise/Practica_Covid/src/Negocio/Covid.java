/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class Covid {
    
    VectorNbit v[];
    String Vnombre[];
    int cant;
    
    public Covid(int cantidad){
        v = new VectorNbit[2];
        v[0] = new VectorNbit(cantidad,26);
        v[1] = new VectorNbit(cantidad,9);
        Vnombre = new String[cantidad];
        cant = 1;
    }
    
    public void insertar(int Nro, String nombre, int edad, int sexo, double peso,
                          int fiebre, int tos, int dolorGarganta, int dolorCabeza,
                          int faltaRespiracion, int diarrea, int dolorMuscular,
                          int perdidaOlfato, int perdidaGusto){
        int parteEntera = (int) peso;
        int parteDecimal = (int) ((peso - parteEntera) * 10); 
        edad = edad<<7;
        edad = edad|Nro;
        sexo = sexo<<14;
        sexo = sexo|edad;
        parteEntera = parteEntera<<15;
        parteEntera = parteEntera|sexo;
        parteDecimal = parteDecimal<<22;
        parteDecimal = parteDecimal|parteEntera;
        v[0].Insertar(parteDecimal, cant);
        tos = tos<<1;
        tos = tos|fiebre;
        dolorGarganta = dolorGarganta<<2;
        dolorGarganta = dolorGarganta| tos;
        dolorCabeza = dolorCabeza<<3;
        dolorCabeza = dolorCabeza|dolorGarganta;
        faltaRespiracion = faltaRespiracion<<4;
        faltaRespiracion = faltaRespiracion|dolorCabeza;
        diarrea = diarrea<<5;
        diarrea = diarrea| faltaRespiracion;
        dolorMuscular = dolorMuscular<<6;
        dolorMuscular = dolorMuscular|diarrea;
        perdidaOlfato = perdidaOlfato<<7;
        perdidaOlfato = perdidaOlfato|dolorMuscular;
        perdidaGusto = perdidaGusto<<8;
        perdidaGusto = perdidaGusto|perdidaOlfato;
        v[1].Insertar(perdidaGusto, cant);
        Vnombre[cant-1] = nombre;
        cant++;
    }
    
    public int getCant(){
        return cant;
    }
    
    public String getNombre(int pos){
        return Vnombre[pos-1];
    }
    public int getNro(int pos){
        int mask = (int) (Math.pow(2,7)-1);
        int x = v[0].Sacar(pos);
        mask = mask & x;
        return mask;
    }
    
    public int getEdad(int pos){
        int mask = (int) (Math.pow(2,7)-1);
        mask = mask<<7;
        int x = v[0].Sacar(pos);
        mask = mask & x;
        mask = mask>>>7;
        return mask;
    }
    public char getSexo(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        char s;
        mask = mask<<14;
        int x = v[0].Sacar(pos);
        mask = mask & x;
        mask = mask>>>14;
        if(mask==1){
            s = 'M';
        }else{
            s = 'F';
        }
        return s;
    }
    public double getPeso(int pos){
        int mask = (int) (Math.pow(2,7)-1);
        int mask2 = (int) (Math.pow(2,4)-1);
        double decimal;
        mask = mask<<15;
        mask2 = mask2<<22;
        int x = v[0].Sacar(pos);
        mask = mask & x;
        mask = mask>>>15;
        mask2 = mask2 & x;
        mask2 = mask2>>>22;
        decimal = mask2 / 10.0f; 
        double numeroCompleto = mask + decimal;
        return numeroCompleto;
    }
    public String getFiebre(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        int x = v[1].Sacar(pos);
        mask = mask & x;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getTos(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<1;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>1;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getDolorGarganta(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<2;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>2;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getDolorCabeza(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<3;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>3;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getfaltaRespiracion(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<4;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>4;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getDiarrea(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<5;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>5;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getDolorMuscular(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<6;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>6;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getPerdidaOlfato(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<7;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>7;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    public String getPerdidaGusto(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<8;
        int x = v[1].Sacar(pos);
        mask = mask & x;
        mask = mask>>>8;
        if(mask == 1)
            return "si";
        else
            return "no";
    }
    
    public String toString(int pos){
        String s = "Formulario Covid\n";
        s = s+"Nro: "+ getNro(pos)+"\n";
        s = s+"Nombre: "+ getNombre(pos)+"\n";
        s = s+"Edad: "+ getEdad(pos)+"\n";
        s = s+"Sexo: "+ getSexo(pos)+"\n";
        s = s+"Peso: "+ getPeso(pos)+"\n";
        s = s+"SINTOMAS\n";
        s = s+"Fiebre: "+ getFiebre(pos)+"\n";
        s = s+"Tos: "+ getTos(pos)+"\n";
        s = s+"Dolor de garganta: "+ getDolorGarganta(pos)+"\n";
        s = s+"Dolor de cabeza: "+ getDolorCabeza(pos)+"\n";
        s = s+"Falta de respiracion: "+ getfaltaRespiracion(pos)+"\n";
        s = s+"Diarrea: "+ getDiarrea(pos)+"\n";
        s = s+"Dolor muscular: "+ getDolorMuscular(pos)+"\n";
        s = s+"Perdida del olfato: "+ getPerdidaOlfato(pos)+"\n";
        s = s+"Perdida del gusto: "+ getPerdidaGusto(pos)+"\n";
        return s;
    }
}
