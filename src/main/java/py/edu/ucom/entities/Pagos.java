package py.edu.ucom.entities;

import java.util.List;

public class Pagos {
    public Usuarios usuario;
    public Clientes cliente;
    public List<DetallePago> productosComprados;

    public Pagos(Clientes cliente, Usuarios usuario, List<DetallePago> productosComprados) {
        this.usuario = usuario;
        this.cliente = cliente;
        this.productosComprados = productosComprados;
    }
    
    // Getters
    public Usuarios getUsuario() {
        return usuario;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public List<DetallePago> getProductosComprados() {
        return productosComprados;
    }

    // Setters
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setProductosComprados(List<DetallePago> productosComprados) {
        this.productosComprados = productosComprados;
    }
}
