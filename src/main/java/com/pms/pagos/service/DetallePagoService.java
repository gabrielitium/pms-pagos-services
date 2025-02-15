package com.pms.pagos.service;

import com.pms.pagos.dto.DetallePagoDTO;

import java.util.List;

public interface DetallePagoService {
    List<DetallePagoDTO> getAllDetalles();
    DetallePagoDTO getDetalleById(Integer id);
    DetallePagoDTO saveDetalle(DetallePagoDTO detallePagoDTO);
    void deleteDetalle(Integer id);
}
