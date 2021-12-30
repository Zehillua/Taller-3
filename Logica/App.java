package Logica;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.plaf.synth.SynthStyleFactory;

import java.io.*;
public class App {
    public static void main(String [] args)throws IOException {
        
        SistemaStorken sistema = new SistemaStorkenImpl();
        lectura(sistema);
        inicioSesion(sistema);
    }


    /**
     * 
Read the files "Cliente.txt", "Entregas.txt" and "localizacion.txt"
     * @param sistema The sistema parameter is created to call SistemaStorkenImpl.
     * @throws IOException
     */
    public static void lectura(SistemaStorken sistema)throws IOException{
        Scanner scanL = new Scanner(new File("localizacion.txt"));
        while(scanL.hasNextLine()){
            String lineaC = scanL.nextLine();
            String [] partesC = lineaC.split(",");
            String ciudad = partesC[0];
            sistema.ingresarLocalizacion(ciudad);
        }
        scanL.close();
        
        Scanner scanC = new Scanner(new File("Cliente.txt"));
        while(scanC.hasNextLine()){
            String lineaC = scanC.nextLine();
            String [] partesC = lineaC.split(",");
            String rut = partesC[0];
            String nombre = partesC[1];
            String apellido = partesC[2];
            double saldo = Double.parseDouble(partesC[3]);
            String ciudad = partesC[4];
            sistema.ingresarCliente(rut, nombre, apellido, saldo, ciudad);
        }
        scanC.close();

        Scanner scanE = new Scanner(new File("Entregas.txt"));
        while(scanE.hasNextLine()){
            
            String lineaE = scanE.nextLine();
            String [] partesE = lineaE.split(",");
            int codigo = Integer.parseInt(partesE[0]);
            String tipo = partesE[1];
            if(tipo.equals("E")){
                String rutR = partesE[2];
                String rutD = partesE[3];
                double gramos = Double.parseDouble(partesE[4]);
                double largo = Double.parseDouble(partesE[5]);
                double ancho = Double.parseDouble(partesE[6]);
                double profundidad = Double.parseDouble(partesE[7]);
                sistema.ingresarEntregaE(codigo, tipo, rutR, rutD, gramos, largo, ancho, profundidad);
            }
            if(tipo.equals("D")){
                String rutR = partesE[2];
                String rutD = partesE[3];
                double gramos = Double.parseDouble(partesE[4]);
                double grosor = Double.parseDouble(partesE[5]);
                sistema.ingresarEntregaD(codigo, tipo, rutR, rutD, gramos, grosor);
            }
            if(tipo.equals("V")){
                String rutR = partesE[2];
                String rutD = partesE[3];
                String material = partesE[4];
                double peso = Double.parseDouble(partesE[5]);
                sistema.ingresarEntregaV(codigo, tipo, rutR, rutD, material, peso);
            }
        }   
    }

    /**
     * It is to log into the system
     * @param sistema The sistema parameter is created to call SistemaStorkenImpl.
     */
    public static void inicioSesion(SistemaStorken sistema){
        Scanner scan = new Scanner(System.in);
        while(true){ 
            System.out.println("Ingrese su rut para iniciar sesion: ");
            System.out.println("Ingrese '-1' para cerrar el sistema.");
            String rut = scan.nextLine();
            if(sistema.confirmarRut(rut)){
                menuCliente(sistema, rut);

            }
            if(rut.equals("Admin")){
                while(true){
                    System.out.println("Ingrese su contrasena: ");
                    String pass = scan.nextLine();
                    if(pass.equals("choripan123")){
                        menuAdmin(sistema);
                    }
                    else{
                        System.out.println("Contrasena incorrecta.");
                        break;
                    }
                }
                

            }
            if(!sistema.confirmarRut(rut)){
                System.out.println("El rut no se encuentra en el sistema, ¿desea registrarse?");
                System.out.println("Ingrese '1' si desea registrarse, si desea salir ingrese '2': ");
                int opcion = Integer.parseInt(scan.nextLine());
                if(opcion == 1){
                    registro(sistema);

                }
                if(opcion == 2){
                    System.out.println("Se cierra el menu.");
                    break;
                }
            }
        }
        
    }

    /**
     * Launch the menu of the customer who logged in
     * @param sistema The sistema parameter is created to call SistemaStorkenImpl.
     * @param rut It is the rut of the one who logged in
     */
    public static void menuCliente(SistemaStorken sistema, String rut){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido a su menu.");
        while(true){
            try{
                System.out.println("Ingrese la opcion que desea realizar: ");
                System.out.println("1.Realizar entrega.\n2.Recargar saldo.\n3.Ver tus entregas.\n4.Salir.");
                int opcion = Integer.parseInt(scan.nextLine());
                if(opcion == 1){
                    System.out.println("Ingrese el tipo de entrega que desea realizar: ");
                    System.out.println("Para documento ingrese 'D'\nPara encomienda ingrese 'E'\nPara valijas ingrese 'V'");
                    String tipo = scan.nextLine();
                    if(tipo.equals("V")){
                        System.out.println("Ingrese el tipo de material: ");
                        System.out.println("Para Cuero ingrese 'cuero'\nPara Plastico ingrese 'plastico\nPara Tela ingrese 'tela'");
                        String material = scan.nextLine();
                        System.out.println("Ingrese el peso en gramos: ");
                        double gramos = Double.parseDouble(scan.nextLine());
                        double peso = gramos/1000;
                        System.out.println("Ingrese codigo de envio al azar de 4 numeros: ");
                        int codigo = Integer.parseInt(scan.nextLine());
                        if(peso>2){
                            System.out.println("El peso supera a lo correspondido para este tipo de entregas.");
                        }else{
                            System.out.println("Ingrese su rut: ");
                            String rutR = scan.nextLine();
                            System.out.println("Ingrese el rut destinatario: ");
                            String rutD = scan.nextLine();
                            if(sistema.confirmarRut(rutD)){
                                System.out.println(sistema.realizarEntregaV(rut, tipo, material, gramos, rutR, rutD, codigo));
                            }else{
                                System.out.println("El rut del destinatario no se encuentra en el sistema.");
                            }
                            
                        }
                    }
                    if(tipo.equals("D")){
                        System.out.println("Ingrese peso en gramos: ");
                        double gramos = Double.parseDouble(scan.nextLine());
                        double peso = gramos/1000;
                        System.out.println("Ingrese grosor en cm: ");
                        double grosor = Double.parseDouble(scan.nextLine());
                        System.out.println("Ingrese codigo de envio al azar de 4 numeros: ");
                        int codigo = Integer.parseInt(scan.nextLine());
                        if(peso>1.5 || grosor>5){
                            System.out.println("El peso o el grosor supera a lo correspondido para este tipo de entrega, el peso tiene que ser no mayor a 1.5 KG y el grosor no tiene que ser mayor a 5cm.");
                        }else{
                            System.out.println("Ingrese su rut: ");
                            String rutR = scan.nextLine();
                            System.out.println("Ingrese el rut destinatario: ");
                            String rutD = scan.nextLine();
                            if(sistema.confirmarRut(rutD)){
                                System.out.println(sistema.realizarEntregaD(rut, tipo, gramos, grosor, rutR, rutD, codigo));
                            }else{
                                System.out.println("El rut del destinatario no se encuentra en el sistema.");
                            }
                        }
                    }
                    if(tipo.equals("E")){
                        System.out.println("Ingrese el peso en gramos: ");
                        double gramos = Double.parseDouble(scan.nextLine());
                        double peso = gramos/1000;
                        System.out.println("Ingrese el largo: ");
                        double largo = Double.parseDouble(scan.nextLine());
                        System.out.println("Ingrese el ancho: ");
                        double ancho = Double.parseDouble(scan.nextLine());
                        System.out.println("Ingrese profundidad: ");
                        double profundidad = Double.parseDouble(scan.nextLine());
                        System.out.println("Ingrese codigo de envio al azar de 4 numeros: ");
                        int codigo = Integer.parseInt(scan.nextLine());
                        if(peso >50 || largo >1.2 || ancho >0.8 || profundidad >0.8){
                            System.out.println("El peso o una de las medidad supera a lo correspondido para este tipo de entrega.");
                        }else{
                            System.out.println("Ingrese su rut: ");
                            String rutR = scan.nextLine();
                            System.out.println("Ingrese el rut destinatario: ");
                            String rutD = scan.nextLine();
                            if(sistema.confirmarRut(rutD)){
                                System.out.println(sistema.realizarEntregaE(rut, tipo, gramos, largo, ancho, profundidad, rutR, rutD, codigo));
                            }else{
                                System.out.println("El rut del destinatario no se encuentra en el sistema.");
                            }
                        }
                    }
                    
                    break;
                }
                if(opcion == 2){
                    System.out.println("Ingrese la cantidad de saldo que desea ingresar: ");
                    double saldo = Double.parseDouble(scan.nextLine());
                    System.out.println(sistema.recargarSaldo(rut, saldo));
                    break;
                }
                if(opcion == 3){
                    System.out.println(sistema.obtenerEntregas(rut));
                    
                    
                }
                if(opcion == 4){
                    break;
                }
                else{
                    System.out.println("Ingrese el numero correcto.");
                }
            }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Start the Admin menu
     * @param sistema The sistema parameter is created to call SistemaStorkenImpl.
     */
    public static void menuAdmin(SistemaStorken sistema){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido a su menu de Administrador.");
        while(true){ 
            System.out.println("Ingrese la opcion que desea realizar: ");
            System.out.println("1.Obtener entregas por tipo.\n2.Obtener entregas por localizacion.\n3.Obtener entregas por cliente.\n4.Obtener registro de ganancias.\n5.cierre del menu.");
            int opcion = Integer.parseInt(scan.nextLine());
            if(opcion == 1){
                System.out.println(sistema.obtenerEntregasTipo());
                break;
            }
            if(opcion == 2){
                System.out.println(sistema.obtenerEntregasLocalizacion());
                break;
            }
            if(opcion == 3){
                System.out.println(sistema.obtenerEntregasLocalizacion());
                break;
            }
            if(opcion == 4){
                sistema.registroGanancias();
            }
            if(opcion == 5){
                break;
            }
        }
    
    }

    /**
     *  Register a new routine to the system.
     * @param sistema The sistema parameter is created to call SistemaStorkenImpl.
     */
    public static void registro(SistemaStorken sistema){
        try{ 
            Scanner scan = new Scanner(System.in);
            System.out.println("Bienvendo al menu de registro.");
            System.out.println("Ingrese su rut: ");
            String rut = scan.nextLine();
            System.out.println("Ingrese su nombre: ");
            String nombre = scan.nextLine();
            System.out.println("Ingrese su apellido: ");
            String apellido = scan.nextLine();
            System.out.println("Ingrese su saldo disponible: ");
            double saldo = Double.parseDouble(scan.nextLine());
            System.out.println("Ingrese su ciudad: ");
            String ciudad = scan.nextLine();
            sistema.ingresarCliente(rut, nombre, apellido, saldo, ciudad);
            System.out.println("Se registró correctamente.");
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
