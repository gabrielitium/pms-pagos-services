package com.pms.pagos.service;

import com.pms.pagos.dto.PagoDTO;

import java.util.List;

public interface PagoService {
    List<PagoDTO> getAllPagos();
    PagoDTO getPagoById(Integer id);
    PagoDTO savePago(PagoDTO pagoDTO);
    PagoDTO updatePago(Integer pagoId, Double total, Integer estado_pago);
    void deletePago(Integer id);
}