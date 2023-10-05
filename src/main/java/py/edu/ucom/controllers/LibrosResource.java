package py.edu.ucom.controllers;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import py.edu.ucom.entities.Libros;
import py.edu.ucom.utils.DataSourceJSON;

@Path("/libros")
public class LibrosResource {

    @Inject
    public DataSourceJSON ds;

    @GET
    @Path("{isbn}")
    public Libros obtenerLibroByISBN(@PathParam("isbn") String param){
        return this.ds.buscarLibro(param);
    }

    @GET
    public List<Libros> obtnerLibros() {
        List<Libros> listaDeLibros = new ArrayList<>();

        try {
            listaDeLibros = this.ds.obtenerLibros();
        } catch (Exception e) {
            // TODO: handle exception

        }

        return listaDeLibros;

    };

    @POST
    public void agregarLibro(Libros params) {
        try {
            this.ds.guardarLibro(params);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @PUT
    public void actualizarLibro(Libros params) {
        try {
            this.ds.actualizarLibro(params);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
