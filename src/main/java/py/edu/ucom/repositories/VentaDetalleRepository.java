package py.edu.ucom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.ucom.entities.VentaDetalle;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Integer> {
    // List<VentaDetalle> findByVenta_VentaId(Integer ventaId);
}
