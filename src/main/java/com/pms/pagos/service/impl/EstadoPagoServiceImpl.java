package com.pms.pagos.service.impl;

import com.pms.pagos.model.EstadoPago;
import com.pms.pagos.repository.EstadoPagoRepository;
import com.pms.pagos.service.EstadoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPagoServiceImpl implements EstadoPagoService {
    private final EstadoPagoRepository repository;

    public EstadoPagoServiceImpl(EstadoPagoRepository repository) {
        this.repository = repository;
    }

    public List<EstadoPago> getAllStates() {
        return repository.findAll();
    }
}
