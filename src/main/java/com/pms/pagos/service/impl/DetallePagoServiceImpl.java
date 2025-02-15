package com.pms.pagos.service.impl;

import com.pms.pagos.dto.DetallePagoDTO;
import com.pms.pagos.model.DetallePago;
import com.pms.pagos.model.Pago;
import com.pms.pagos.repository.DetallePagoRepository;
import com.pms.pagos.repository.PagoRepository;
import com.pms.pagos.service.DetallePagoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetallePagoServiceImpl implements DetallePagoService {
    private final DetallePagoRepository detallePagoRepository;
    private final PagoRepository pagoRepository;

    public DetallePagoServiceImpl(DetallePagoRepository detallePagoRepository, PagoRepository pagoRepository) {
        this.detallePagoRepository = detallePagoRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<DetallePagoDTO> getAllDetalles() {
        return detallePagoRepository.findAll().stream()
                .map(detalle -> new DetallePagoDTO(
                        detalle.getIdDetalle(),
                        detalle.getPago().getIdPago(),
                        detalle.getIdProducto(),
                        detalle.getCantidad(),
                        detalle.getImporte()))
                .collect(Collectors.toList());
    }

    @Override
    public DetallePagoDTO getDetalleById(Integer id) {
        return detallePagoRepository.findById(id)
                .map(detalle -> new DetallePagoDTO(
                        detalle.getIdDetalle(),
                        detalle.getPago().getIdPago(),
                        detalle.getIdProducto(),
                        detalle.getCantidad(),
                        detalle.getImporte()))
                .orElse(null);
    }

    @Override
    public DetallePagoDTO saveDetalle(DetallePagoDTO detallePagoDTO) {
        Pago pago = pagoRepository.findById(detallePagoDTO.getIdPago())
                .orElseThrow(() -> new RuntimeException("Pago not found"));

        DetallePago detalle = new DetallePago();
        detalle.setPago(pago);
        detalle.setIdProducto(detallePagoDTO.getIdProducto());
        detalle.setCantidad(detallePagoDTO.getCantidad());
        detalle.setImporte(detallePagoDTO.getImporte());

        DetallePago saved = detallePagoRepository.save(detalle);
        return new DetallePagoDTO(
                saved.getIdDetalle(),
                saved.getPago().getIdPago(),
                saved.getIdProducto(),
                saved.getCantidad(),
                saved.getImporte());
    }

    @Override
    public void deleteDetalle(Integer id) {
        detallePagoRepository.deleteById(id);
    }
}