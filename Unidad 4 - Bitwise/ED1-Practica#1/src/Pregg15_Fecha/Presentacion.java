
package Pregg15_Fecha;

public class Presentacion {
    
    public static void main(String[] args) {
        Fecha2 f1 = new Fecha2(2000, 2, 29);
        System.out.println(f1.toString());
        
        //proxima fecha
        System.out.println("Proxima fecha: "+ f1.proximaF().toString());
        
        //cambiar dia,mes,año
        f1.setDia(10);
        f1.setMes(12);
        f1.setAño(2010);
        System.out.println("cambiar a d10,m12,a2010: "+f1.toString());
        
        //recuperar dia,mes,año
        System.out.println("dia: "+f1.getDia()+"\nmes: "+f1.getMes()+"\naño: "+f1.getAño());
        
        //reiniciar fecha a 06/06/2004
        f1.reiniciar(1, 11, 2004);
        System.out.println("fecha reiniciada a 1d, 11m, 2004a : "+f1.toString());
        
        //adelantar fecha 100 dias
        f1.adelantar(15, 0, 0);
        System.out.println("Fecha adelantada 15 dias : "+f1.toString());
    }
    
    
}
