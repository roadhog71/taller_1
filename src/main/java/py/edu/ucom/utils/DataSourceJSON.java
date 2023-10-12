package py.edu.ucom.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.entities.Clientes;
import py.edu.ucom.entities.Pagos;
import py.edu.ucom.entities.Productos;
import py.edu.ucom.entities.Usuarios;

@ApplicationScoped
public class DataSourceJSON {
    public String SRC_PAGOS = "C:\\Users\\sebas\\Documents\\Programming\\UCOM - Analisis de Sistemas\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\pagos.json";
    public String SRC_USUARIOS = "C:\\Users\\sebas\\Documents\\Programming\\UCOM - Analisis de Sistemas\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\usuarios.json";
    public String SRC_CLIENTES = "C:\\Users\\sebas\\Documents\\Programming\\UCOM - Analisis de Sistemas\\taller-1\\src\\main\\java\\py\\edu\\ucom\\utils\\clientes.json";


    public void guardarPago(Pagos pago) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Pagos> lista = obtenerPagos();
            lista.add(pago);
            mapper.writeValue(new File(this.SRC_PAGOS), lista);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public List<Pagos> obtenerPagos() {
        ObjectMapper mapper = new ObjectMapper();
        List<Pagos> pagos = new ArrayList<>();
        try {
            pagos = mapper.readValue(
                    new File(this.SRC_PAGOS),
                    new TypeReference<List<Pagos>>() {
                    });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return pagos;
    }
    public List<Clientes> obtenerClientes() {
        ObjectMapper mapper = new ObjectMapper();
        List<Clientes> clientes = new ArrayList<>();
        try {
            clientes = mapper.readValue(
                    new File(this.SRC_CLIENTES),
                    new TypeReference<List<Clientes>>() {
                    });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return clientes;
    }
    public List<Usuarios> obtenerUsuarios() {
        ObjectMapper mapper = new ObjectMapper();
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            usuarios = mapper.readValue(
                    new File(this.SRC_USUARIOS),
                    new TypeReference<List<Usuarios>>() {
                    });

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return usuarios;
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
    public Clientes buscarCliente(String documento) {
        Clientes cliente = null;
        List<Clientes> data = obtenerClientes();

        for (Clientes item : data) {
            if (item.getDocumento().equals(documento)) {
                cliente = item;
            }
        }
        return cliente;
    }
    }
