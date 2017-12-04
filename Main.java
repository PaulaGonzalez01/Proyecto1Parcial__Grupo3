/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroharrypotter;
import java.io.IOException;
import java.util.Scanner;
import static registroharrypotter.Planificador.lista_estudiantes;

/**
 *
 * @author delll
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
       
        int opUsuario=0;
        String salir="";
        Scanner teclado = new Scanner(System.in);
        while (!"S".equals(salir)){
            int rol=0;
            
            System.out.println("/**COLEGIO HOGWARTS DE MAGIA Y HECHICERÍA**/");
            System.out.println("Roles académicos:");
            System.out.println("1.Hechicero Planificador");
            System.out.println("2.Estudiante");
            System.out.println("Seleccione qué rol desempeña: ");
            rol = teclado.nextInt();
            
            switch(rol){
                case (1):

                    String usuPlanif = "";
                    String passPlanif = "";
                    Boolean end = true;

                    //Comprobando que se encuentra en el archivo
                    //Creando Planificador
                    while (end == true) {
                        System.out.println("Ingrese su nombre de usuario: ");
                        usuPlanif = teclado.next().toLowerCase();
                        System.out.println("Ingrese su contraseña: ");
                        passPlanif = teclado.next().toLowerCase();
                        Boolean confirm = Planificador.VerificarDatosP(usuPlanif, passPlanif, true);
                        if (confirm) {
                            System.out.println("¡Ingreso exitoso!");
                            end = false;
                        } else {
                            System.out.println("El usuario o la contraseña no son válidos");
                            System.out.println("Por favor intente de nuevo");
                        }
                    }
                    
                    //Mostrar el menú y ejecutar las opciones
                    /* Hacer que pueda volver al menú principal*/
                    Planificador planif = new Planificador(usuPlanif, passPlanif);
                    
                    String opPlanif = null;
                    while (!"N".equals(opPlanif)) {
                        planif.ImprimirMenuPrincipal();
                        System.out.println("Ingrese la opción a la que desea acceder: ");
                        int opCurso = teclado.nextInt();

                        switch (opCurso) {
                            case (1):
                                planif.CrearCurso();
                                break;
                            case (2):
                                planif.CrearProfesor();
                                break;
                            case (3):
                                planif.CrearEstudiante();
                                break;
                            case (4):
                                planif.VerHorariosPlanificados();
                                break;
                            case (5):
                                planif.ListadoEstudiantes();
                                for(Estudiante estudiante: lista_estudiantes){
                                    System.out.println(estudiante.toString());
                                }
                                break;
                        }
                        System.out.println("¿Desea volver al menú principal?(S/N)");
                        opPlanif = teclado.next().toUpperCase();
                    }
                    break;
                    
                case (2): 
                    
                    String usuEstu = "";
                    String passEstu = "";
                    
                    String salir1 ="";
                    while (!"N".equals(salir1)) {
                        
                        Boolean end1 = true;
                        while (end1 == true) {
                            System.out.println("Ingrese su nombre de usuario: ");
                            usuEstu = teclado.next().toLowerCase();
                            System.out.println("Ingrese su contraseña: ");
                            passEstu = teclado.next().toLowerCase();
                            Boolean confirm1 = Planificador.VerificarDatosP(usuEstu, passEstu, true);
                            if (confirm1) {
                                System.out.println("¡Ingreso exitoso!");
                                end1 = false;
                            } else {
                                System.out.println("El usuario o la contraseña no son válidos");
                                System.out.println("Por favor intente de nuevo");
                            }
                        }
                        
                        System.out.println("/** MENU PRINCIPAL **/");
                        System.out.println("1. Ver cursos planificados");
                        System.out.println("2. Registro");
                        System.out.println("3. Descripción de vuelo");
                        System.out.println("Ingrese la opción a la que desea acceder: ");
                        int opEst = teclado.nextInt();
                        
                        
                        String nombre = Estudiante.NombreE(usuEstu);
                        String apellido = Estudiante.ApellidoE(usuEstu);
                        //int edad = Integer.parseInt(Estudiante.EdadE(usuEstu));
                        String casa = Estudiante.CasaE(usuEstu);
                        String varita = Estudiante.VaritaE(usuEstu);
                        
                        Estudiante alumno = new Estudiante(nombre, apellido, 12, casa, varita,0);
                        switch(opEst){
                            case (1):
                                alumno.VerCursosPlanificados();
                                break;
                            case (2):
                                alumno.Registro(nombre, apellido);
                                break;
                            case (3):
                                System.out.println(alumno.DescripcionDeVuelo(nombre, apellido));
                                break;
                        }
                        
                        System.out.println("¿Desea volver al menú principal?(S/N)");
                        salir1 = teclado.next().toUpperCase();
                    }
                    break;
                
            }
            System.out.println("¿Desea salir del programa? (S/N)");
            salir = teclado.next().toUpperCase();
        }    
    }    
}
