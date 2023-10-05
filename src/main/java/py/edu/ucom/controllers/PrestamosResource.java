package py.edu.ucom.controllers;

import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import py.edu.ucom.entities.Libros;
import py.edu.ucom.servicios.PrestamoService;
import py.edu.ucom.utils.DataSourceJSON;

@Path("prestamos")
public class PrestamosResource {

    @Inject 
    private PrestamoService service;

    @POST
    @Path("{documento}/{isbn}")
    public Map<String, String> prestamo(@PathParam("documento")String documento, @PathParam("isbn") String isbn){
        
        return this.service.prestar(documento, isbn);
    }
    @POST
    @Path("devolver/{documento}/{isbn}")
    public Map<String, String> devolver(@PathParam("documento")String documento, @PathParam("isbn") String isbn){
        
        return this.service.devolver(documento, isbn);
    }

    @GET
    @Path("{documento}")
    public List<Libros> obtenerLibrosPorUsuario(@PathParam("documento")String documento){
        return this.service.obtenerLibrosPorUsuario(documento);
    }   
    
}
