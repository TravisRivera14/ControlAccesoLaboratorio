package logica;
import entidades.*;
import datos.Repositorio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ServicioLaboratorio {
        private Repositorio repo = new Repositorio();
        private final String FILE_USUARIOS = "usuarios.txt";
        private final String FILE_ACCESOS = "accesos.txt";
    
        public String registrarUsuario(String id, String nombre, String rol) {
            if (id.isEmpty() || nombre.isEmpty()) return "Error: Datos incompletos.";
            List<String> usuarios = repo.leer(FILE_USUARIOS);
            for (String u : usuarios) {
                if (u.split(",")[0].equals(id)) return "Error: ID duplicado.";
            }
            repo.escribir(FILE_USUARIOS, id + "," + nombre + "," + rol);
            return "Usuario registrado correctamente.";
        }
    
        public String registrarEntrada(String idUsuario) {
            List<String> accesos = repo.leer(FILE_ACCESOS);
            for (String a : accesos) {
                String[] datos = a.split("\\|");
                if (datos[0].equals(idUsuario) && datos[2].equals("N/A")) 
                    return "Error: El usuario ya tiene una entrada activa.";
            }
            String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            repo.escribir(FILE_ACCESOS, idUsuario + "|" + hora + "|N/A");
            return "Entrada registrada: " + hora;
        }
    
        public String registrarSalida(String idUsuario) {
            List<String> lineas = repo.leer(FILE_ACCESOS);
            boolean encontrado = false;
            for (int i = 0; i < lineas.size(); i++) {
                String[] datos = lineas.get(i).split("\\|");
                if (datos[0].equals(idUsuario) && datos[2].equals("N/A")) {
                    String horaSalida = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    lineas.set(i, datos[0] + "|" + datos[1] + "|" + horaSalida);
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                repo.sobreescribir(FILE_ACCESOS, lineas);
                return "Salida registrada con éxito.";
            }
            return "Error: No se encontró entrada previa para este ID.";
        }
    
        public void mostrarReporte(String idUsuario) {
            List<String> accesos = repo.leer(FILE_ACCESOS);
            System.out.println("\n--- REPORTE DE ACCESOS: " + idUsuario + " ---");
            for (String a : accesos) {
                String[] datos = a.split("\\|");
                if (datos[0].equals(idUsuario)) {
                    System.out.println("Entrada: " + datos[1] + " | Salida: " + datos[2]);
                }
            }
        }
    }