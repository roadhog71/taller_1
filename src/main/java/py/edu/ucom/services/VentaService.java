package py.edu.ucom.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.config.IDAO;
import py.edu.ucom.entities.Cliente;
import py.edu.ucom.entities.Venta;
import py.edu.ucom.entities.VentaDetalle;
import py.edu.ucom.entities.dto.ResumenVentaDTO;
import py.edu.ucom.entities.dto.VentaDetalleDTO;
import py.edu.ucom.repositories.VentaRepository;
import py.edu.ucom.repositories.VentaDetalleRepository;

@ApplicationScoped
public class VentaService implements IDAO<Venta, Integer> {

    private final VentaRepository ventaRepository;
    private final VentaDetalleRepository ventaDetalleRepository;

    @Inject
    public VentaService(VentaRepository ventaRepository, VentaDetalleRepository ventaDetalleRepository) {
        this.ventaRepository = ventaRepository;
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    @Override
    public Venta obtener(Integer param) {
        return this.ventaRepository.findById(param).orElse(null);
    }

    @Override
    public Venta agregar(Venta param) {
        try {
            Venta savedVenta = this.ventaRepository.save(param);

            // If VentaDetalle list is not null, associate each VentaDetalle with the saved Venta
            if (param.getVentaDetalleList() != null) {
                for (VentaDetalle ventaDetalle : param.getVentaDetalleList()) {
                    ventaDetalle.setVenta(savedVenta);
                    ventaDetalleRepository.save(ventaDetalle);
                }
            }

            return savedVenta;
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            throw new RuntimeException("Error while adding Venta entity: " + e.getMessage());
        }
    }

    @Override
    public Venta modificar(Venta param) {
        // TODO Auto-generated method stub
        return this.ventaRepository.save(param);
    }

    @Override
    public void eliminar(Integer param) {
        // TODO Auto-generated method stub
        this.ventaRepository.deleteById(param);
    }

    @Override
    public List<Venta> listar() {
        return this.ventaRepository.findAll();
    }

    // public List<VentaDetalle> obtenerDetalles(Integer ventaId) {
    //     return this.ventaDetalleRepository.findByVenta_VentaId(ventaId);
    // }
    public ResumenVentaDTO obtenerResumen(Integer ventaId){
        ResumenVentaDTO data = new ResumenVentaDTO();
        Venta v = this.ventaRepository.findById(ventaId).orElse(null);
        Cliente clie = v.getClienteId();
        data.setRazonSocial(clie.getNombres()+" "+clie.getApellidos() );
        data.setDocumento(clie.getDocumento());
        data.setFecha(v.getFecha());
        List<VentaDetalleDTO> detalle= new ArrayList<>();
        for(VentaDetalle item : v.getVentaDetalleList()){
                VentaDetalleDTO vdto = new VentaDetalleDTO();
                vdto.setCantidad(item.getCantidad());
                vdto.setSubtotal(item.getSubtotal());
                vdto.setDescripcion( item.getProducto().getDescripcion());
                detalle.add( vdto);
        }
        data.setDetalle( detalle);

        return data;
    }
}
