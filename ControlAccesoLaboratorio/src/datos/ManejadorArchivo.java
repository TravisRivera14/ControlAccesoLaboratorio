package datos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivo {

    private String nombreArchivo;

    public ManejadorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardar(String linea) {
        try (PrintWriter out = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            out.println(linea);
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }

    public List<String> leerTodo() {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(nombreArchivo);
        
        if (!archivo.exists()) return lineas;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
        return lineas;
    }
}