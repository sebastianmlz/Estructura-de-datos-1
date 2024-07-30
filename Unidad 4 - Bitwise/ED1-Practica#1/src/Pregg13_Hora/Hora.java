
package Pregg13_Hora;


public class Hora {
    int horas, minutos, segundos ;

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    public void adelantar(int h, int m, int s){
        segundos = segundos + s;
        minutos = minutos + m;
        horas = horas + h;
       
        minutos = minutos + segundos/60 ;
        segundos = segundos % 60;
        
        horas = horas + minutos/60;
        minutos = minutos % 60;
        
        horas = horas % 24;
    }
    
    public void reiniciar(int h, int m, int s){
        if(s > 59){
           minutos = m + s/60 ;
           segundos = s % 60  ; 
        }else
           segundos = s % 60 ;
        if(m > 59){
            if(s <= 59){
                horas = h + m/60 ;
                minutos = m % 60;   
            }else{
                horas = h + m/60 ;
                minutos = m%60 + s / 60 ;
            }
        }else{
            if(s <= 59){
                horas = h % 24 ;
                minutos = m % 60;
            }else{
                horas = h % 24 ;
                minutos = m%60 + s / 60 ;
            }
        }
    }
    
    public String imprimir(){
        return String.format("Hora: %02d:%02d:%02d", getHoras(),
                getMinutos(), getSegundos());
    }
    
}
