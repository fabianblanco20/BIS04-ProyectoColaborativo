/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocolaborativo;

import java.util.Scanner;
/**
 *
 * @author Fresh
 */
public class ProyectoColaborativo {

 
    public static void main(String[] args) {
        
        
        Scanner entrada = new Scanner (System.in);
        
        
        String nombre, apellido, email, telefono, direccion;
       
        
        System.out.println("*Captura de los datos del usuario*");
        
        System.out.println("Ingrese su nombre: ");
        nombre = entrada.nextLine();
        
        System.out.println("Ingrese su apellido: ");
        apellido = entrada.nextLine();
        
        
         //Validación para el email
        do{
            
          System.out.println("Ingrese su correo electronico: ");
        email = entrada.nextLine();
        
        if(!email.contains("@")){
            System.out.println("Correo invalido, debe contener '@', intente nuevamente ");
        }
        
        }while(!email.contains("@"));
        
        //Validación para el teléfono
        
        boolean valido;
        
        do {            
            System.out.println("Ingrese su numero de telefono: ");
        telefono = entrada.nextLine();
        
        valido = true;
        
          for (int i = 0; i < telefono.length(); i++) {
                if (!Character.isDigit(telefono.charAt(i))) {
                    System.out.println("Numero invalido, solo debe contener numeros ");
                    valido = false;
                    break;
                }
                
            }
        
        if (valido && telefono.length() < 8){
          
            System.out.println("Numero invalido, debe tener al menos 8 digitos");
            valido = false;
            }
           
        
        } while (!valido);
        
        
        
        System.out.println("Ingrese su direccion: ");
        direccion = entrada.nextLine();
    
    
        System.out.println("*Resumen de la captura de datos*");
        System.out.println("Nombre: "+ nombre + " " + apellido);
        System.out.println("Correo electronico: "+ email);
        System.out.println("Telefono: "+ telefono);
        System.out.println("Direccion: "+ direccion);
        
        
        
        
        
        
        
        
    }
    
    
}
