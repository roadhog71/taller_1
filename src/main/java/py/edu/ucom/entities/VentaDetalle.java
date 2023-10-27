/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "venta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaDetalle.findAll", query = "SELECT v FROM VentaDetalle v"),
    // @NamedQuery(name = "VentaDetalle.findByVentaId", query = "SELECT v FROM VentaDetalle v WHERE v.ventaId = :ventaId"),
    @NamedQuery(name = "VentaDetalle.findByVentaDetalleId", query = "SELECT v FROM VentaDetalle v WHERE v.ventaDetalleId = :ventaDetalleId"),
    @NamedQuery(name = "VentaDetalle.findByCantidad", query = "SELECT v FROM VentaDetalle v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentaDetalle.findBySubtotal", query = "SELECT v FROM VentaDetalle v WHERE v.subtotal = :subtotal")})
public class VentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "venta_detalle_id")
    private Integer ventaDetalleId;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "subtotal")
    private Integer subtotal;
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private Producto productoId;
    
    @JsonIgnore
    @JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaDetalle() {
    }

 

    public Integer getVentaDetalleId() {
        return ventaDetalleId;
    }



    public void setVentaDetalleId(Integer ventaDetalleId) {
        this.ventaDetalleId = ventaDetalleId;
    }



    public Integer getCantidad() {
        return cantidad;
    }



    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



    public Integer getSubtotal() {
        return subtotal;
    }



    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }



    public Producto getProductoId() {
        return productoId;
    }



    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }



    public Venta getVenta() {
        return venta;
    }



    public void setVenta(Venta venta) {
        this.venta = venta;
    }



    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (ventaDetalleId != null ? ventaDetalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.ventaDetalleId == null && other.ventaDetalleId != null) || (this.ventaDetalleId != null && !this.ventaDetalleId.equals(other.ventaDetalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fpj.crm.entity.gen.taller.VentaDetalle[ ventaDetalleId=" + ventaDetalleId + " ]";
    }
    
}
