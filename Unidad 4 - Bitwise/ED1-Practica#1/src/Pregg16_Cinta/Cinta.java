
package Pregg16_Cinta;


public class Cinta {
    String cinta;
    int cabezal;

    public Cinta(String cinta) {
        this.cinta = cinta;
        this.cabezal = 0;
    }

    public int getCabezal() {
        return cabezal;
    }

    public void setCabezal(int cabezal) {
        this.cabezal = cabezal;
    }
    
    
    public void avanzarPosSig(){
        if(cabezal < cinta.length()-1)
            cabezal++ ;
    }
    
    public void retrocederPos(){
        if(cabezal > 0)
            cabezal-- ;
    }
    
    public char caracterCorriente(){
        return cinta.charAt(cabezal);
    }
    
    public void REG(char caracter){
        StringBuilder s = new StringBuilder(cinta);
        s.setCharAt(cabezal, caracter);
        cinta = s.toString() ;
    }
    
    public int siguientePal(){
        while(cabezal<cinta.length()-1 &&  cinta.charAt(cabezal-1)!=' '){
            cabezal++;
        }
        return cabezal;
    }
    
    public void retrocederBlanco(){
        while(cabezal>0 &&  cinta.charAt(cabezal)!=' '){
            cabezal--;
        }
    }
    
    public void pausa(){
        
    }
    
    public void stop(){
        cabezal = 0;
    }
    
    @Override
    
    public String toString(){
        String s="";
        for(int i=0 ; i<cinta.length() ; i++){
            s = s+cinta.charAt(i);
        }
        return s;
    }
    
    
}
