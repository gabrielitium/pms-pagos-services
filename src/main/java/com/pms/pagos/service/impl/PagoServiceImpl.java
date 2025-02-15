package com.pms.pagos.service.impl;

import com.pms.pagos.dto.PagoDTO;
import com.pms.pagos.model.EstadoPago;
import com.pms.pagos.model.Pago;
import com.pms.pagos.repository.EstadoPagoRepository;
import com.pms.pagos.repository.PagoRepository;
import com.pms.pagos.service.PagoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final EstadoPagoRepository estadoPagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, EstadoPagoRepository estadoPagoRepository) {
        this.pagoRepository = pagoRepository;
        this.estadoPagoRepository = estadoPagoRepository;
    }

    @Override
    public List<PagoDTO> getAllPagos() {
        return pagoRepository.findAll().stream()
                .map(pago -> new PagoDTO(pago.getIdPago(), pago.getIdCliente(), pago.getIdProveedor(), pago.getEstadoPago().getId(), pago.getConcepto(), pago.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO getPagoById(Integer id) {
        return pagoRepository.findById(id)
                .map(pago -> new PagoDTO(pago.getIdPago(), pago.getIdCliente(), pago.getIdProveedor(), pago.getEstadoPago().getId(), pago.getConcepto(), pago.getTotal()))
                .orElse(null);
    }

    @Override
    public PagoDTO savePago(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        pago.setIdCliente(pagoDTO.getIdCliente());
        pago.setIdProveedor(pagoDTO.getIdProveedor());
        pago.setConcepto(pagoDTO.getConcepto());
        EstadoPago estadoPago = estadoPagoRepository.findById(pagoDTO.getEstado_pago())
                .orElseThrow(() -> new RuntimeException("State not found"));
        pago.setEstadoPago(estadoPago);
        pago.setTotal(pagoDTO.getTotal());
        Pago saved = pagoRepository.save(pago);
        return new PagoDTO(saved.getIdPago(), saved.getIdCliente(), saved.getIdProveedor(), pago.getEstadoPago().getId(), saved.getConcepto(), saved.getTotal());
    }

    public Pago updatePago(Integer pagoId, Double total, Integer estado_pago) {
        Pago pago = pagoRepository.findById(pagoId)
                .orElseThrow(() -> new RuntimeException("Pago not found"));

        if (total != null) {
            pago.setTotal(total);
        }

        if (estado_pago != null) {
            EstadoPago state = estadoPagoRepository.findById(estado_pago)
                    .orElseThrow(() -> new RuntimeException("State not found"));
            pago.setEstadoPago(state);
        }

        return pagoRepository.save(pago);
    }

    @Override
    public void deletePago(Integer id) {
        pagoRepository.deleteById(id);
    }
}