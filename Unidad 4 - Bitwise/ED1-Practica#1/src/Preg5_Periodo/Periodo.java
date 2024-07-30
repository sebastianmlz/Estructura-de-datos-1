
package Preg5_Periodo;


public class Periodo {
    
    int dias;
    int meses;
    int anios;

    public Periodo(int dias) {
        this.dias = dias;
    }

    
    public Periodo(int meses, int dias) {
        this.meses = meses ;
        this.dias = dias ;
    }

    public Periodo(int anios, int meses, int dias) {
        this.anios = anios ;
        this.meses = meses ;
        this.dias = dias ;
    }
    
    public static int  traducirADias(Periodo p){
        int anioaDias = p.anios * 365;
        int mesesaDias = p.meses * 30;
        int diasT= anioaDias + mesesaDias + p.dias;
        return diasT;
    }
    
    
           
   
    
}
