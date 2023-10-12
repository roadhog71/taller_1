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
import py.edu.ucom.entities.DetallePago;
import py.edu.ucom.entities.Pagos;
import py.edu.ucom.utils.DataSourceJSON;

@Path("/tienda/caja/{documentoCliente}/{documentoUsuario}")
public class PagosResource {

    @Inject
    public DataSourceJSON ds;


    @POST
    public void resgistrarPagos(@PathParam("documentoCliente") String documentoCliente, @PathParam("documentoUsuario") String documentoUsuario, List<DetallePago> params) {
        try {
            this.ds.guardarLibro(params);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
