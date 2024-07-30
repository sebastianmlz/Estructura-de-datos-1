
package Negocio;

import javax.swing.JOptionPane;
import jdk.jshell.Diag;

public class FechaBits { 
    VectorNbits1 f;
    int cant;
    
    public FechaBits(int cant){
        f = new VectorNbits1(cant, 14);
        this.cant = cant;
    }
    
    public void insertarf(int dia, int mes, int año, int pos){
        if(pos <= cant){
            int mask= 0;
            mask = dia;
            mes = mes<<5;
            mask = mask|mes;
            año = año-1990;
            año = año<<9;
            mask = mask|año;
            f.insertar(mask, pos);
        }else{
            JOptionPane.showMessageDialog(null, "Error Insertar: posicion fuera de rango");
        }
    }
    
    public void insertarf2(int dia, int mes, int año, int pos){
        if(mes==1 || mes ==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
            if(dia >= 1 && dia<=31){
                if(pos <= cant){
                    int mask= 0;
                    mask = dia;
                    mes = mes<<5;
                    mask = mask|mes;
                    año = año-1990;
                    año = año<<9;
                    mask = mask|año;
                    f.insertar(mask, pos);
                }else{
                    JOptionPane.showMessageDialog(null, "Error Insertar: posicion fuera de rango");
       
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error Insertar: Fecha no registrable");
            }
        }
        if(mes==4 || mes ==6 || mes==9 || mes==11){
            if(dia >= 1 && dia<=30){
                if(pos <= cant){
                    int mask= 0;
                    mask = dia;
                    mes = mes<<5;
                    mask = mask|mes;
                    año = año-1990;
                    año = año<<9;
                    mask = mask|año;
                    f.insertar(mask, pos);
                }else{
                    JOptionPane.showMessageDialog(null, "Error Insertar: posicion fuera de rango");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error Insertar: Fecha no registrable");
            }
        }
        if(mes==2){
            if(dia >= 1 && dia<=28){
                if(pos <= cant){
                    int mask= 0;
                    mask = dia;
                    mes = mes<<5;
                    mask = mask|mes;
                    año = año-1990;
                    año = año<<9;
                    mask = mask|año;
                    f.insertar(mask, pos);
                }else{
                    JOptionPane.showMessageDialog(null, "Error Insertar: posicion fuera de rango");       
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error Insertar: Fecha no registrable");
            }
        }
       
    }
    
    public int getdia(int pos){
        int mask = f.get(pos);
        int mask1 = ((int) Math.pow(2, 5)-1);
        mask1 = mask1&mask;
        return mask1;
    }
    
    public int getmes(int pos){
        int mask = f.get(pos);
        int mask1 = ((int) Math.pow(2, 4)-1);
        mask1 = mask1<<5;
        mask1 = mask1&mask;
        mask1 = mask1>>>5;
        return mask1;
    }
    
    public int getaño(int pos){
        int mask = f.get(pos);
        int mask1 = ((int) Math.pow(2, 5)-1);
        mask1 = mask1<<9;
        mask1 = mask1&mask;
        mask1 = mask1>>>9;
        return (mask1 + 1990);
    }
    
    @Override
    
    public String toString(){
        String s="F= { ";
        for(int i=1; i <= cant; i++){
            if(getdia(i) != 0){
                s = s + getdia(i) + "/" + getmes(i) + "/" + getaño(i) +" , ";
            }
        }
        return s + " }";
    }
    
}
