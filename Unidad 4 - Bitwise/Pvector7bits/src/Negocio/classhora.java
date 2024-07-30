/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Estefany
 */
public class classhora {VectorNbits1 H;
                        int cant;
                        int pos;

    public classhora(int cant) {
        this.cant = cant;
        H=new VectorNbits1(cant,17);
        pos=0;
    }
   public void SETHORA(int hora, int minuto, int segundo){
       pos++;
       int mask=segundo;
       minuto=minuto<<6;
       mask=mask|minuto;
       hora=hora<<12;
       mask=mask|hora;
       H.insertar(mask,pos);
   }                     
    public int getHORA(int pos){
       int mask=H.get(pos);
       mask=mask>>>12;
      return mask;
   }   
   public int getMinuto(int pos){
       int mask=H.get(pos);
       int mask1=63;
       mask1=mask1<<6;
       mask1=mask1&mask;
       mask1=mask1>>>6;
      return mask1;
   }  
   public int getsegundo(int pos){
       int mask=H.get(pos);
       int mask1=63;
       mask1=mask1&mask;
       return mask1;
   }  

    @Override
    public String toString() {
       
        String S="H{";
        for (int i = 1; i <=pos; i++) {
            S=S+getHORA(i)+":"+getMinuto(i)+":"+getsegundo(i)+"  ,  ";
            
        }
        S=S+"]";
        return S;
    }
   
   
}
