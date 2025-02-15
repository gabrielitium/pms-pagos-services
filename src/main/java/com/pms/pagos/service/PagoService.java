package com.pms.pagos.service;

import com.pms.pagos.dto.PagoDTO;

import java.util.List;

public interface PagoService {
    List<PagoDTO> getAllPagos();
    PagoDTO getPagoById(Integer id);
    PagoDTO savePago(PagoDTO pagoDTO);
    void deletePago(Integer id);
}