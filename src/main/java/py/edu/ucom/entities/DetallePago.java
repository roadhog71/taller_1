package py.edu.ucom.entities;


public class DetallePago {
    public Productos producto;
    public int cantidad;
    public int subTotal;
    // Constructor
    public DetallePago(Productos producto, int cantidad, int subTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    // Getters and Setters

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
}
