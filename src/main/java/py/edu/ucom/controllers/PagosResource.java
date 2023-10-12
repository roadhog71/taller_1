package py.edu.ucom.controllers;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import py.edu.ucom.entities.DetallePago;
import py.edu.ucom.entities.Pagos;
import py.edu.ucom.services.PagoService;

@Path("/tienda/caja/{documentoCliente}/{documentoUsuario}")
public class PagosResource {

    @Inject
    private PagoService service;


    @POST
    public Response resgistrarPagos(@PathParam("documentoCliente") String documentoCliente, @PathParam("documentoUsuario") String documentoUsuario, List<DetallePago> params) {
        Map<String,String> respuesta = new HashMap<>();
        try {
            respuesta = this.service.registrarPago(documentoCliente, documentoUsuario, params);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return Response.status(Response.Status.CREATED)
            .entity(respuesta)
            .build();
    }
}
