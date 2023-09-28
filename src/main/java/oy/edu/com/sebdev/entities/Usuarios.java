package oy.edu.com.sebdev.entities;
import java.util.List;

public class Usuarios {
    public String nombre;
    public String documento;
    public List<Libros> librosPrestados;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
}
