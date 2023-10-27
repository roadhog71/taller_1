package py.edu.ucom.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.config.IDAO;
import py.edu.ucom.entities.Venta;
import py.edu.ucom.entities.VentaDetalle;
import py.edu.ucom.repositories.VentaDetalleRepository;

@ApplicationScoped
public class VentaDetalleService implements IDAO<VentaDetalle, Integer> {

    private final VentaDetalleRepository repository;

    @Inject
    public VentaDetalleService(VentaDetalleRepository repository) {
        this.repository = repository;
    }

    @Override
    public VentaDetalle obtener(Integer param) {
        return this.repository.findById(param).orElse(null);
    }

    @Override
    public VentaDetalle agregar(VentaDetalle param) {
        try {
            return this.repository.save(param);
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            throw new RuntimeException("Error while adding VentaDetalle entity");
        }
    }

    @Override
    public VentaDetalle modificar(VentaDetalle param) {
        // TODO Auto-generated method stub
        return this.repository.save(param);
    }

    @Override
    public void eliminar(Integer param) {
        // TODO Auto-generated method stub
        this.repository.deleteById(param);
    }

    @Override
    public List<VentaDetalle> listar() {
        return this.repository.findAll();
    }

}
