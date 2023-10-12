package py.edu.ucom.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.entities.DetallePago;
import py.edu.ucom.entities.Pagos;
import py.edu.ucom.entities.Usuarios;
import py.edu.ucom.entities.Clientes;
import py.edu.ucom.utils.DataSourceJSON;

@ApplicationScoped
public class PagoService {
    @Inject
    private DataSourceJSON ds;

    public Map<String,String> registrarPago(String documentoCliente, String documentoUsuario, List<DetallePago> productos ){
        Map<String,String> respuesta = new HashMap<>();
        Clientes cliente = this.ds.buscarCliente(documentoCliente);
        Usuarios usuario = this.ds.buscarUsuario(documentoUsuario);
        
        Pagos pago = new Pagos(cliente, usuario, productos);

        this.ds.guardarPago(pago);

        
        respuesta.put("mensaje", "El pago ha sido guardado con éxito.");

        return respuesta;

    }
}