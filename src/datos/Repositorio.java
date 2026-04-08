package datos;
import java.io.*;
import java.util.*;

public class Repositorio {
        public void escribir(String archivo, String linea) {
            try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
                out.println(linea);
            } catch (IOException e) {
                System.out.println("Error al escribir: " + e.getMessage());
            }
        }
    
        public List<String> leer(String archivo) {
            List<String> lineas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String l;
                while ((l = br.readLine()) != null) lineas.add(l);
            } catch (IOException e) { /* Archivo nuevo o vacío */ }
            return lineas;
        }
    
        public void sobreescribir(String archivo, List<String> lineas) {
            try (PrintWriter out = new PrintWriter(new FileWriter(archivo, false))) {
                for (String l : lineas) out.println(l);
            } catch (IOException e) {
                System.out.println("Error al actualizar: " + e.getMessage());
            }
        }
    }