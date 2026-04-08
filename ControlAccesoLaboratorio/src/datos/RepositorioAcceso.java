package datos;
import entidades.Acceso;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RepositorioAcceso {
    
    private ManejadorArchivo manejador;
    private final String RUTA = "accesos.txt";

    public RepositorioAcceso() {
        this.manejador = new ManejadorArchivo(RUTA);
    }

    public void guardarAcceso(Acceso acceso) {
        // Formato: idUsuario|fechaEntrada|fechaSalida
        manejador.guardar(acceso.getIdUsuario() + "|" + acceso.getFechaEntrada() + "|" + acceso.getFechaSalida());
    }

    public List<Acceso> obtenerTodos() {
        List<Acceso> accesos = new ArrayList<>();
        List<String> lineas = manejador.leerTodo();

        for (String linea : lineas) {
            String[] datos = linea.split("\\|");
            if (datos.length == 3) {
                Acceso a = new Acceso(datos[0], datos[1]);
                a.setFechaSalida(datos[2]);
                accesos.add(a);
            }
        }
        return accesos;
    }

    public void actualizarArchivo(List<Acceso> todosLosAccesos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA, false))) {
            for (Acceso a : todosLosAccesos) {
                pw.println(a.getIdUsuario() + "|" + a.getFechaEntrada() + "|" + a.getFechaSalida());
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }
}