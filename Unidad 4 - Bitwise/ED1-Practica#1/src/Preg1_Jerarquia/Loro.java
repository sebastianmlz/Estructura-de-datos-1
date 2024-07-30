
package Preg1_Jerarquia;


public class Loro extends Ave{
   
    private char region;
    private String color;

    public Loro(char region, String color, char sexo, int edad) {
        super(sexo, edad);
        this.region = region;
        this.color = color;
    }

    public char getRegion() {
        return region;
    }

    public void setRegion(char region) {
        this.region = region;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
     /*
    public String DeDondeEres(){
        String s = "" ;
        switch (region) {
            case 'N':
                s = "Norte";
                break;
            case 'S':
                s = "Sur";
                break;
            case 'E':
                s = "Este";
                break;
            case 'O':
                s = "Oeste";
                break;
            default:
                s = "No existe la region seleccionada";
        }
        return s;
    } */
    
    public void DeDondeEres(){
        switch (getRegion()) {
            case 'N':
                System.out.println("Norte");
                break;
            case 'S':
                System.out.println("Sur");
                break;
            case 'E':
                System.out.println("Este");
                break;
            case 'O':
                System.out.println("Oeste");
                break;
            default:
                System.out.println("No existe la region seleccionada");
        }
    }
}
