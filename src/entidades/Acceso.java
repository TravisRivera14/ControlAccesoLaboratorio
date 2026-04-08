package entidades;

public class Acceso {
        private String idUsuario, entrada, salida;
    
        public Acceso(String idUsuario, String entrada) {
            this.idUsuario = idUsuario;
            this.entrada = entrada;
            this.salida = "N/A";
        }
    
        public String getIdUsuario() { return idUsuario; }
        public String getEntrada() { return entrada; }
        public String getSalida() { return salida; }
        public void setSalida(String salida) { this.salida = salida; }
    }