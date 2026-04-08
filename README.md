+-----------------------+
|  Capa de Presentación |  <-- 1. Interfaz de Usuario (Main.java)
| (Menú de Consola)     |      Solo habla con la Capa de Lógica.
+----------+------------+
           |
           | Pide validar/procesar
           v
+----------+------------+
|    Capa de Lógica     |  <-- 2. "Cerebro" (ServicioLaboratorio.java)
| (Reglas de Negocio)   |      Aplica validaciones (IDs, Doble entrada)
+----------+------------+      No conoce los archivos .txt.
           |
           | Pide leer/guardar
           v
+----------+------------+
|     Capa de Datos     |  <-- 3. Persistencia (Repositorio.java)
| (Acceso a Datos)      |      Lee y escribe en "usuarios.txt" y "accesos.txt".
+-----------------------+

+ - - - - - - - - - - - +
|   Capa de Entidades   |  <-- 4. Objetos Transversales (Usuario.java, Acceso.java)
| (Clases de Datos)     |      Son los "moldes" que usan TODAS las capas.
+ - - - - - - - - - - - +
