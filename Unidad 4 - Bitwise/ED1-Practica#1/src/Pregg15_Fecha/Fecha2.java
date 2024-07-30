
package Pregg15_Fecha;


public class Fecha2 {
    int año, mes, dia;

    public Fecha2(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        normalizar();
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
        normalizar();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
        normalizar();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        normalizar();
    }
    
    public String nombreMes(){
        int num = getMes();
        String[] nombreM={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre",
                            "Octubre","Noviembre","Diciembre"};
        return nombreM[num-1];
    }
    
    public boolean AñoBisiesto(){
        return ((getAño() % 4 == 0) && ((getAño() % 100 != 0) || (getAño() % 400 == 0)));
    }
    
    public int diasMes(){
        int cant = 0;
        if(getMes()==1 || getMes()==3 || getMes()==5 || getMes()==7 || getMes()==8 || getMes()==10 || getMes()==12)
            cant = 31;
        
        if(getMes()==4 || getMes()==6 || getMes()==9 || getMes()==11)
            cant = 30;
        if(getMes() ==2){
            if(AñoBisiesto())
                cant = 29;
            else
                cant = 28;
        }
        if(getMes()<1 || getMes()>12){
            System.out.println("Error: mes inexistente");
            throw new ExceptionInInitializerError();
        }
        return cant;
    }
    
    public Fecha2 proximaF(){
        if(getDia() < diasMes()){
            return new Fecha2(año, mes, dia+1);
        }else if(getMes() < 12){
            return new Fecha2(año, mes+1,1);
        }else{
            return new Fecha2(año+1, 1, 1);
        }
    }
    
    public void proximaFYO(){
        if(getDia() < diasMes())
            dia = dia + 1;
        else{
            dia = 1;
            if(getMes() < 12)
                mes = mes + 1;
            else
                mes = 1;
                año = año +1;
        }
    }
    
    public void reiniciar(int d, int m, int a){
        int di=dia; int me = mes; int aa = año;
        dia = d;
        mes = m;
        año = a; 
        if(normalizarB() == false){
           dia = di;
           mes = me;
           año = aa;
           System.out.println("Error: no se puede reiniciar a la nueva fecha porque no es normal");
        }
        
    }
    
    public void adelantar(int d, int m, int a){
        dia += d;
        mes += m;
        año += a;
        normalizar();
    }
    
    public void normalizar(){
        int diasM = diasMes();
        while(dia > diasM){
            dia = dia - diasM;
            mes++;
            if(mes > 12){
                mes = 1;
                año++;
            }
            diasM = diasMes();
        }
    }
    
    public boolean normalizarB(){
        return (getAño() >=1 && (getMes() >= 1 && getMes() <=12) && getDia() <= diasMes());
    }
    
    
    
    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAño());
    }
    
    public String toString2(){
        return getDia() + " de " + nombreMes() + " de " + getAño();
    }
    
    /*
    switch (mes) {
            case 1: 
                    s = "Enero";
                break;
            case 2: 
                    s = "Febrero";
                break;
            case 3: 
                    s =  "Marzo";
                break;
            case 4: 
                    s =  "Abril";
                break;
            case 5: 
                    s =  "Mayo";
                break;
            case 6: 
                    s =  "Junio";
                break;
            case 7: 
                    s =  "Julio";
                break;
            case 8: 
                    s = "Agosto";
                break;
            case 9: 
                    s = "Septiembre";
                break;
            case 10: 
                    s = "Octubre";
                break;
            case 11: 
                    s = "Noviembre";
                break;
            case 12: 
                    s = "Diciembre";
                break;
            default:
                return "Mes inexistente";
        }
        return s;
    
    
    
    if(normalizar() == false){
            dia -= d;
            mes -= m;
            año -= a;
            System.out.println("Error: no se puede adelantar porque la fecha no seria normal");
        }
    */
    
}
