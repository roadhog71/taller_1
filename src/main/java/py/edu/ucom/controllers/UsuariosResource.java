package py.edu.ucom.controllers;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import py.edu.ucom.entities.Usuarios;
import py.edu.ucom.utils.DataSourceJSON;

@Path("/usuarios")
public class UsuariosResource {
    @Inject
    public DataSourceJSON ds;

    @GET
    public List<Usuarios> obtener(){
        return this.ds.obtenerUsuarios();
    }
    @GET
    @Path("{documento}")
    public Usuarios obtenerByDocumento(@PathParam("documento")String param){
        return this.ds.buscarUsuario(param);
    }

    @POST
    public void guardar(Usuarios usuario){
        this.ds.guardarUsuarios(usuario);
    }
    
}
