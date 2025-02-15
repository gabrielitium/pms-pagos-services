package com.pms.pagos.controller;

import com.pms.pagos.model.EstadoPago;
import com.pms.pagos.service.EstadoPagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estados-pago")
public class EstadoPagoController {

    private final EstadoPagoService service;

    public EstadoPagoController(EstadoPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstadoPago> getAllStates() {
        return service.getAllStates();
    }

}
