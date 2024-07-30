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
public class Alarma {
    
    VectorNbit a;
    String Vnombre[];
    int cant;
    
    //dia     5b
    //mes     4
    //anio    1
    //hora    5
    //minutos 6
    //timbrar 1
    //repetir 2
   //duracion 3
    
    public Alarma(int cantidad){
        a = new VectorNbit(cantidad,31);
        Vnombre = new String[cantidad];
        cant = 1;
    }
    
    public void insertar(int dia, int mes, int anio, int hora, int minuto, String nombre, int timbrar, int repetir,
                         int duracion, int nro){
        mes = mes<<5;
        mes = mes|dia;
        anio = anio<<9;
        anio = anio|mes;
        hora = hora<<10;
        hora = hora|anio;
        minuto = minuto<<15;
        minuto = minuto|hora;
        timbrar = timbrar<<21;
        timbrar = timbrar|minuto;
        repetir = repetir<<22;
        repetir = repetir|timbrar;
        duracion = duracion<<24;
        duracion = duracion|repetir;
        nro = nro<<27;
        nro = nro|duracion;
        a.Insertar(nro, cant);
        Vnombre[cant-1] = nombre;
        cant++;
    }
    
    public int getDia(int pos){
        int mask = (int) (Math.pow(2,5)-1);
        int x = a.Sacar(pos);
        mask = mask & x;
        return mask;
    }
    
    public int getMes(int pos){
        int mask = (int) (Math.pow(2,4)-1);
        mask = mask<<5;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>5;
        return mask;
    }
    public int getAnio(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<9;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>9;
        return mask+2020;
    }
    public int getHora(int pos){
        int mask = (int) (Math.pow(2,5)-1);
        mask = mask<<10;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>10;
        return mask;
    }
    public int getMinuto(int pos){
        int mask = (int) (Math.pow(2,6)-1);
        mask = mask<<15;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>15;
        return mask;
    }
    public String getTimbrar(int pos){
        int mask = (int) (Math.pow(2,1)-1);
        mask = mask<<21;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>21;
        if(mask==0){
            return "no";
        }else{
            return "si";
        }
    }
    public String getRepetir(int pos){
        int mask = (int) (Math.pow(2,2)-1);
        mask = mask<<22;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>22;
        if(mask==0){
            return "5 min";
        }else{
            if(mask==1){
                return "10 min";   
            }else{
                return "15 min";
            }
            
        }
    }
    public String getDuracion(int pos){
        String s= "";
        int mask = (int) (Math.pow(2,3)-1);
        mask = mask<<24;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>24;
        switch(mask){
            case 0: return s="1 min";
            case 1: return s="2 min";
            case 2: return s="3 min";
            case 3: return s="4 min";
            case 4: return s="5 min";
        }   
        return s;
    }
    
    public int getNro(int pos){
        int mask = (int) (Math.pow(2,4)-1);
        mask = mask<<27;
        int x = a.Sacar(pos);
        mask = mask & x;
        mask = mask>>>27;
        return mask;
    }
    
    public String getNombre(int pos){
        return Vnombre[pos-1];
    }
    
    public int getCant(){
        return cant;
    }
    
    public String toString(int pos){
        String s = "ALARMA\n";
        s = s+"Nro: "+ getNro(pos)+"\n";
        s = s+"Fecha: "+ getDia(pos)+"/" + getMes(pos)+"/" + getAnio(pos)+"\n";
        s = s+"Hora: "+ getHora(pos)+" : " + getMinuto(pos) + "\n";
        s = s+"Nombre: "+ getNombre(pos)+"\n";
        s = s+"Timbrar: "+ getTimbrar(pos)+"\n";
        s = s+"Repetir: "+ getRepetir(pos)+"\n";
        s = s+"Duracion: "+ getDuracion(pos)+"\n";

        return s;
    }
    
    
    
}
