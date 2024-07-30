
package Negocio;

public class certificado {
    VectorNbits1 c[];
    int i;
    public int bus;
    String vnombre[];
    
    public certificado(int ele){
        c = new VectorNbits1[3];
        c[0] = new VectorNbits1(ele, 24);
        c[1] = new VectorNbits1(ele, 31);
        c[2] = new VectorNbits1(ele, 15);
        vnombre = new String[ele];
        i = 0;
    }
    
    public void insertar(int ci, int d, int m, int a, int s, int mun, int lug, int vac,
                         int p, int dv, int mv, int lot, int av, String nombre){
        
        i++ ;
        c[0].insertar(ci, i);
        vac<<=3;
        vac|=p;
        lug<<=6;
        lug|=vac;
        mun<<=9;
        lug|=mun;
        s<<=11;
        lug|=s;
        d<<=4;
        d|=m;
        a<<=9;
        d|=a;
        d<<=15;
        lug|=d;
        c[1].insertar(lug, i);
        lot<<=3;
        lot|=av;
        mv<<=6;
        lot|=mv;
        dv<<=10;
        lot|=dv;
        c[2].insertar(lot, i);
        vnombre[i-1] = nombre;
    }
    
    public int getCi(int p){
        return c[0].get(p);
    }
    
    public int getDia(int n){
        int mask = ((int) Math.pow(2, 5)) -1;
        mask<<=19;
        int x = c[1].get(n);
        mask&= x;
        mask >>>=19;
        return mask;
    }
    
    public int getMes(int n){
        int mask = ((int) Math.pow(2, 4)) -1;
        mask<<=15;
        int x =c[1].get(n);
        mask&=x;
        mask>>>=15;
        return mask;
    }
    
    public String getNombre(int pos){
        String nam = vnombre[pos-1];
        return nam;
    }
    
    public int getAño(int n){
        int x = c[1].get(n);
        x = x>>>24;
        return (2003-x);
    }
    
    public String getSedes(int n){
        int mask = ((int) Math.pow(2, 4)) -1;
        mask<<=11;
        int x = c[1].get(n);
        mask&=x;
        mask>>>=11;
        String t="";
        switch(mask){
            case 0: t = "Santa Cruz";break;
            case 1: t = "Beni";break;
            case 2: t = "Pando";break;
            case 3: t = "Tarija";break;
            case 4: t = "Potosi";break;
            case 5: t = "Oruro";break;
            case 6: t = "Cochabamba";break;
            case 7: t = "La Paz";break;
            case 8: t = "Chuquisaca";break;
        }
        return t;
    }
    
    public String getMuni(int n){
        int mask = ((int) Math.pow(2, 2)) -1;
        mask<<=9;
        int x = c[1].get(n);
        mask&=x;
        mask>>>=9;
        String t="";
        switch(mask){
            case 0: t = "Santa Cruz";break;
            case 1: t = "Cotoca";break;
            case 2: t = "La guardia";break;
        }
        return t;
    }
    
    public String getLugar(int n){
        int mask = ((int) Math.pow(2, 3))-1;
        mask<<= 6;
        int x = c[1].get(n);
        mask &= x;
        mask>>>=6;
        String t = "";
        switch (mask){
            case 0: t = "C.S LAS AMERICAS";break;
            case 1: t = "UPDS";break;
            case 2: t = "EMI";break;
            case 3: t = "C.S VIRGEN DE COTOCA";break;
            case 4: t = "C.S PLAN 4000";break;
            case 5: t = "C.S FEXPOCRUZ";break;
            case 6: t = "C.S EL RECREO";break;
        }
        return t;
    }
    
    public String getVacuna(int n){
        int mask = ((int) Math.pow(2, 3))-1;
        mask<<=3;
        int x = c[1].get(n);
        mask&=x;
        mask>>>=3;
        String t = "";
        switch (mask) {
            case 0: t = "Covid19";break;
            case 1: t = "Fiebre amarilla";break;
            case 2: t = "Sarampion";break;
        }
        return t;
    }
    
    public String getProveedor(int n){
        int mask = ((int) Math.pow(2, 3))-1;
        int x = c[1].get(n);
        mask&=x;
        String t = "";
        switch(mask){
            case 0: t = "AstraZeneca";break;
            case 1: t = "Sputnik V";break;
            case 2: t = "Pfizer";break;
            case 3: t = "Moderna";break;
            case 4: t = "Jhonson & jhonson";break;
            case 5: t = "Sinopharm";break;
            case 6: t = "Sinovac";break;
        }
        return t;
    }
    
    public int getdiaVacu(int n){
        int x= c[2].get(n);
        x>>>=10;
        return x;
    }
    
    public int getmesVacu(int n){
        int mask = ((int) Math.pow(2, 4))-1;
        mask<<=6;
        int x = c[2].get(n);
        mask&=x;
        mask>>>=6;
        return mask;
    }
    
    public int getLote(int n){
        int mask = ((int) Math.pow(2, 3))-1;
        mask<<=3;
        int x = c[2].get(n);
        mask&=x;
        mask>>>=3;
        return mask;
    }
    
    public int getAñoVacu(int n){
        int mask = ((int) Math.pow(2, 3))-1;
        int x = c[1].get(n);
        mask&=x;
        return mask + 2021;
    }
    
    public boolean pertenece(int ci){
        boolean x = false;
        int j = 1;
        while(x==false && j<this.i){
            int sa = c[0].get(j);
            int mask = ((int) Math.pow(2, 24))-1;
            mask&=sa;
            if(ci==mask){
                x = true;
                bus = j;
            }
            j++ ;
        }
        return x;
    }
    
}
