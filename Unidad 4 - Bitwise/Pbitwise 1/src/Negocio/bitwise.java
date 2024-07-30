
package Negocio;

public class bitwise {
    
    int x;
    
    public bitwise(){
        this.x = 0;
    }
    
    public void setbit1(int pos){
        if(pos <= 32){
            int mask = 1;
            mask = mask << pos-1;
            x = x | mask;
        }
    }
    
    public void setbit0(int pos){
        if(pos <= 32){
            int mask = 1;
            mask = mask << pos-1;
            mask = ~mask;
            x = x & mask ;
        }
    }
    
    public int getBit(int pos){
        int mask = 1;
        mask = mask << pos-1;
        mask = mask & x;
        mask = mask >>> pos-1;
        return mask ;
    }
    
    @Override
    public String toString(){
        String s = "X= ";
        for(int i=32 ; i>=1 ; i--){
            s = s+" "+getBit(i);
        }
        return s;
    }
    
    public static void main(String[] args) {
        bitwise p = new bitwise();
        System.out.println(p);
        p.setbit1(1);
        p.setbit1(2);
        p.setbit1(3);
        p.setbit1(4);
        System.out.println(p);
        p.setbit0(2);
        p.setbit0(1);
        p.setbit0(32);
        p.setbit0(31);
        p.setbit1(32);
        System.out.println(p);
    }
}
