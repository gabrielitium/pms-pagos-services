package com.pms.pagos.controller;

import com.pms.pagos.dto.PagoDTO;
import com.pms.pagos.model.Pago;
import com.pms.pagos.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<PagoDTO> getAllPagos() {
        return pagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public PagoDTO getPagoById(@PathVariable Integer id) {
        return pagoService.getPagoById(id);
    }

    @PostMapping
    public PagoDTO savePago(@RequestBody PagoDTO pagoDTO) {
        return pagoService.savePago(pagoDTO);
    }

    @PutMapping("/{pagoId}")
    public Pago updatePago(@PathVariable Integer pagoId,
                           @RequestParam(required = false) Double total,
                           @RequestParam(required = false) Integer estado_pago) {
        return pagoService.updatePago(pagoId, total, estado_pago);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Integer id) {
        pagoService.deletePago(id);
    }
}
