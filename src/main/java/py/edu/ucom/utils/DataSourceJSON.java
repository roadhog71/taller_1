package py.edu.ucom.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.entities.Productos;
import py.edu.ucom.entities.Monedas;
import py.edu.ucom.entities.Usuarios;

@ApplicationScoped
public class DataSourceJSON {
    public String SRC_MONEDAS = "C:\\Users\\Jhony\\Desktop\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\monedas.json";
    public String SRC_USUARIOS = "C:\\Users\\Jhony\\Desktop\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\usuarios.json";
    public String SRC = "C:\\Users\\Jhony\\Desktop\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\libros.json";

    public void guardarLibro(Productos libro) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Productos> lista = obtenerLibros();
            lista.add(libro);
            mapper.writeValue(new File(this.SRC), lista);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<Productos> obtenerLibros() {
        ObjectMapper mapper = new ObjectMapper();
        List<Productos> libros = new ArrayList<>();
        try {
            libros = mapper.readValue(
                    new File(this.SRC),
                    new TypeReference<List<Productos>>() {
                    });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return libros;
    }

    public void guardarUsuarios(Usuarios usuario) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Usuarios> lista = obtenerUsuarios();
            usuario.setLibrosPrestados( new ArrayList<>());
            lista.add(usuario);
            mapper.writeValue(new File(this.SRC_USUARIOS), lista);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<Usuarios> obtenerUsuarios() {

        ObjectMapper mapper = new ObjectMapper();
        List<Usuarios> data = new ArrayList<>();
        try {
            data = mapper.readValue(
                    new File(this.SRC_USUARIOS),
                    new TypeReference<List<Usuarios>>() {
                    });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return data;
    }

    public Productos buscarLibro(String isbn) {
        Productos libro = null;
        List<Productos> data = obtenerLibros();

        for (Productos item : data) {
            if (item.getPrecio().equals(isbn)) {
                libro = item;
            }
        }
        return libro;
    }

    public Usuarios buscarUsuario(String documento) {
        Usuarios usuario = null;
        List<Usuarios> data = obtenerUsuarios();

        for (Usuarios item : data) {
            if (item.getDocumento().equals(documento)) {
                usuario = item;
            }
        }
        return usuario;
    }

    /// actualizar libro y actualizar usuario
    public void actualizarLibro(Productos param) {
        List<Productos> data = obtenerLibros();

        for (Productos item : data) {
            if (item.getPrecio().equals(param.getPrecio())) {

                if(param.getPrestado()!=null){
                   item.setPrestado(param.getPrestado()); 
                }
                if(param.getCodigo()!=null && !param.getCodigo().isEmpty()){
                    item.setCodigo(param.getCodigo());
                }
                if(param.getNombre() != null && !param.getNombre().isEmpty()){
                 item.setNombre(param.getNombre());
                }
            }
        }
        
        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File(this.SRC), data);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void actualizarUsuario(Usuarios param){
        List<Usuarios> data = obtenerUsuarios();
         for (Usuarios item : data) {

            if(item.getDocumento().equals(param.getDocumento())){
                item.setNombre(param.getNombre());
                item.setLibrosPrestados(param.getLibrosPrestados());
                break;
            }
        }

          try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File(this.SRC_USUARIOS), data);

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public List<Monedas> obtenerMonedas(){
        ObjectMapper mapper = new ObjectMapper();
        List<Monedas> lista = new ArrayList();

        try {
            lista = mapper.readValue(
                    new File(this.SRC_MONEDAS),
                    new TypeReference<List<Monedas>>() {
                    });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lista;
    }

    public Monedas buscarMonedas(String codigo) {
        Monedas data = null;
        List<Monedas> lista = obtenerMonedas();

        for (Monedas item : lista) {
            if (item.getCodigo().equals(codigo)) {
                data = item;
                break;
            }
        }
        return data;
    }

}
