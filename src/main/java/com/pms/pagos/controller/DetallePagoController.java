package com.pms.pagos.controller;

import com.pms.pagos.dto.DetallePagoDTO;
import com.pms.pagos.service.DetallePagoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-pago")
public class DetallePagoController {
    private final DetallePagoService detallePagoService;

    public DetallePagoController(DetallePagoService detallePagoService) {
        this.detallePagoService = detallePagoService;
    }

    @GetMapping
    public List<DetallePagoDTO> getAllDetalles() {
        return detallePagoService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public DetallePagoDTO getDetalleById(@PathVariable Integer id) {
        return detallePagoService.getDetalleById(id);
    }

    @PostMapping
    public DetallePagoDTO saveDetalle(@RequestBody DetallePagoDTO detallePagoDTO) {
        return detallePagoService.saveDetalle(detallePagoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalle(@PathVariable Integer id) {
        detallePagoService.deleteDetalle(id);
    }
}