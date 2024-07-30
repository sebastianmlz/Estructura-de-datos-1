
package Preg3_booleanoX;


public class BooleanoX {
    
    private boolean valor;
    
    public BooleanoX(){
        
    }

    public BooleanoX(int CondicionComoInt) {
        this.valor = CondicionComoInt != 0;
    }
    
    public BooleanoX and(BooleanoX b1, BooleanoX  b2){
        return new BooleanoX(b1.valor && b2.valor ? 1 : 0);
    }
    
    public BooleanoX or(BooleanoX b1, BooleanoX b2){
        return new BooleanoX(b1.valor || b2.valor  ? 1 : 0);
    }
    
    public BooleanoX not(BooleanoX b1){
        return new BooleanoX(!b1.valor ? 1 : 0);
    }
    
    @Override
    
    public String toString(){
        String s ="";
        if(valor == true)
            return "Verdadero";
        else
            return "Falso";
    }
}
