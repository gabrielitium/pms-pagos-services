package com.pms.pagos.service;

import com.pms.pagos.model.EstadoPago;
import com.pms.pagos.repository.EstadoPagoRepository;

import java.util.List;

public interface EstadoPagoService {

    List<EstadoPago> getAllStates();

}
