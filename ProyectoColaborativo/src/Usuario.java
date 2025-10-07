public class Usuario {
    private final String nombre;
    private final String correo;
    private final String telefono;

    public Usuario(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String toRegistro() {
        // Formato: nombre;correo;telefono
        return nombre + ";" + correo + ";" + telefono;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
}
