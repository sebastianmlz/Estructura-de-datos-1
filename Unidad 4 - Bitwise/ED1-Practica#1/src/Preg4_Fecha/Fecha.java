
package Preg4_Fecha;


public class Fecha {
    int anio, mes, dia;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public static Fecha crearDeseTextoAnioDosDigitos(char [] fechaenTexto){
        int dia = Integer.parseInt(new String(fechaenTexto,0,2));
        int mes = Integer.parseInt(new String(fechaenTexto,2,2));
        int anio = Integer.parseInt(new String(fechaenTexto,4,2));
        return new Fecha(dia,mes,anio);
    }
    
    public static Fecha crearDeseTextoAnioCompleto(char [] fechaenTexto){
        int dia = Integer.parseInt(new String(fechaenTexto,0,2));
        int mes = Integer.parseInt(new String(fechaenTexto,2,2));
        int anio = Integer.parseInt(new String(fechaenTexto,4,4));
        return new Fecha(dia,mes,anio);
    }
    
   // @Override
    
    public String toString(){
       String s = "";
       s = s + getDia() + "/" + getMes() + "/" + getAnio();
       return s;
    }
    
    public String toString2(){
        return String.format("Fecha: %02d/%02d/%d", dia, mes, anio);
    }
    
}
