/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class EncuestaBits {
    VectorNbits1 V1;
    VectorNbits1 V2CI;
    VectorNbits1 V3Telefono;
    int cant;
    String[] Nombre;
    
    public EncuestaBits(int cantidad){
        Nombre=new String[cantidad];
        V1=new VectorNbits1(cantidad,26);
        V2CI=new VectorNbits1(cantidad,27);
        V3Telefono=new VectorNbits1(cantidad,27);
        cant=1;
    }
    
    public void insertar(String nombre,int dia,int mes,int anio,int nroHijos,
            int estadoCivil,int primaria,int bachiller,int Tecnico,int Licenciado,
            int Postgrado,int ci,int telefono){
            mes = mes<<5;
            mes = mes|dia;
            anio = anio-1980;
            anio = anio<<9;
            anio = anio|mes;
            nroHijos = nroHijos<<15;
            nroHijos = nroHijos|anio;
            estadoCivil = estadoCivil<<
        
    }
    
}
