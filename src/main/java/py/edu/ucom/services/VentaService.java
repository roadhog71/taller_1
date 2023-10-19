package py.edu.ucom.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.config.IDAO;
import py.edu.ucom.entities.Cliente;
import py.edu.ucom.entities.Venta;
import py.edu.ucom.entities.dto.ResumenVentaDTO;
import py.edu.ucom.entities.dto.VentaDetalleDTO;
import py.edu.ucom.repositories.VentaRepository;

@ApplicationScoped
public class VentaService implements IDAO<Venta, Integer> {
    
    private final VentaRepository repository;

    @Inject
    public VentaService(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Venta obtener(Integer param) {
        return this.repository.findById(param).orElse(null);
    }
    

    @Override
    public Venta agregar(Venta param) {
        try {
            return this.repository.save(param);
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            throw new RuntimeException("Error while adding Venta entity");
        }
        }
    @Override
    public Venta modificar(Venta param) {
        // TODO Auto-generated method stub
        return this.repository.save(param);
    }

    @Override
    public void eliminar(Integer param) {
        // TODO Auto-generated method stub

        this.repository.deleteById(param);
    }

    @Override
    public List<Venta> listar() {
        return this.repository.findAll();
    }

    public ResumenVentaDTO obtenerResumen(Integer ventaId) {
        ResumenVentaDTO data = new ResumenVentaDTO();
        Venta v = this.repository.findById(ventaId).orElse(null);

        if (v != null) {
            Cliente clie = v.getClienteId();
            if (clie != null) {
                data.setRazonSocial(clie.getNombres() + " " + clie.getApellidos());
                data.setDocumento(clie.getDocumento());
            }

            data.setFecha(v.getFecha());
        }

        return data;
    }
}
