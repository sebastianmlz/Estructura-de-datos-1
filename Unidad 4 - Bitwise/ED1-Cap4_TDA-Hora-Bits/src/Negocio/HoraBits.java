
package Negocio;


public class HoraBits {
    VectorNbits1 h;
    int cant;
    
    public HoraBits(int cant){
        h = new VectorNbits1(cant, 17);
        this.cant = cant;
    }
    
    public void insertar(int hora, int minuto, int segundo, int pos){
        if(pos <= cant){
            if(hora<=24 && minuto<=60 && segundo<=60 ){
                int mask = 0;
                mask = hora;
                minuto = minuto<<5;
                mask = mask|minuto;
                segundo = segundo<<11;
                mask = mask|segundo;
                h.insertar(mask, pos);
            }else{
                System.out.println("Error Insertar: hora no registrable");
            }
        }else{
            System.out.println("Error Insertar: posicion inexiatente");
        }
    }
    
    public int getHora(int pos){
        int mask = h.get(pos);
        int mask1 = ((int) Math.pow(2, 5)-1);
        mask1 = mask1&mask;
        return mask1;
    }
    public int getMinuto(int pos){
        int mask = h.get(pos);
        int mask1 = ((int) Math.pow(2, 6)-1);
        mask1 = mask1<<5;
        mask1 = mask1&mask;
        mask1 = mask1>>>5;
        return mask1;
    }
    public int getSegundo(int pos){
        int mask = h.get(pos);
        int mask1 = ((int) Math.pow(2, 6)-1);
        mask1 = mask1<<11;
        mask1 = mask1&mask;
        mask1 = mask1>>>11;
        return mask1;
    }
    
    @Override
    public String toString(){
        String s="H = { ";
        for(int i=1 ; i <= cant ; i++){
            if(getHora(i) > 0){
                s = s + getHora(i) + ":" + getMinuto(i) + ":" + getSegundo(i) + " , " ;
            }
        }
        return s + " }";
    }
    
}
