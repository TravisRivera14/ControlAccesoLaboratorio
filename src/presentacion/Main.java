package presentacion;
import logica.ServicioLaboratorio;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            ServicioLaboratorio servicio = new ServicioLaboratorio();
            Scanner sc = new Scanner(System.in);
            int opcion = 0;
    
            do {
                System.out.println("\n--- SISTEMA DE ACCESO A LABORATORIO ---");
                System.out.println("1. Registrar Usuario");
                System.out.println("2. Registrar Entrada");
                System.out.println("3. Registrar Salida");
                System.out.println("4. Ver Historial (Reporte)");
                System.out.println("5. Salir");
                System.out.print("Elija una opcion: ");
                
                try {
                    opcion = Integer.parseInt(sc.nextLine());
                    switch(opcion) {
                        case 1:
                            System.out.print("ID: "); String id = sc.nextLine();
                            System.out.print("Nombre: "); String nom = sc.nextLine();
                            System.out.print("Rol (Estudiante/Docente): "); String rol = sc.nextLine();
                            System.out.println(servicio.registrarUsuario(id, nom, rol));
                            break;
                        case 2:
                            System.out.print("ID Usuario: "); String idEnt = sc.nextLine();
                            System.out.println(servicio.registrarEntrada(idEnt));
                            break;
                        case 3:
                            System.out.print("ID Usuario: "); String idSal = sc.nextLine();
                            System.out.println(servicio.registrarSalida(idSal));
                            break;
                        case 4:
                            System.out.print("ID Usuario para reporte: "); String idRep = sc.nextLine();
                            servicio.mostrarReporte(idRep);
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Por favor ingrese un numero valido.");
                }
            } while (opcion != 5);
            
            System.out.println("Programa finalizado.");
            sc.close();
        }
    }