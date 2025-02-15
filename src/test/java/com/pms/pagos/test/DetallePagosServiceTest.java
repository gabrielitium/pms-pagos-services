package com.pms.pagos.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.pms.pagos.dto.DetallePagoDTO;
import com.pms.pagos.model.DetallePago;
import com.pms.pagos.model.Pago;
import com.pms.pagos.repository.DetallePagoRepository;
import com.pms.pagos.repository.PagoRepository;
import com.pms.pagos.service.impl.DetallePagoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

class DetallePagoServiceTest {

    @Mock
    private DetallePagoRepository detallePagoRepository;

    @Mock
    private PagoRepository pagoRepository;

    @InjectMocks
    private DetallePagoServiceImpl detallePagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDetalles() {
        Pago pago = Pago.builder().idPago(1).idCliente(1).idProveedor(1).concepto("Test").total(100.0).fechaCreacion(null).fechaActualizacion(null).build();
        //Pago pago = new Pago(1, 1, 2, "Test", 100.0, null, null);
        DetallePago detalle1 = new DetallePago(1, pago, 101, 2.0, 50.0, null, null);
        DetallePago detalle2 = new DetallePago(2, pago, 102, 3.0, 75.0, null, null);
        when(detallePagoRepository.findAll()).thenReturn(Arrays.asList(detalle1, detalle2));

        List<DetallePagoDTO> result = detallePagoService.getAllDetalles();
        assertEquals(2, result.size());
    }

    @Test
    void testGetDetalleById() {
        Pago pago = Pago.builder().idPago(1).idCliente(1).idProveedor(1).concepto("Test").total(100.0).fechaCreacion(null).fechaActualizacion(null).build();;
        DetallePago detalle = new DetallePago(1, pago, 101, 2.0, 50.0, null, null);
        when(detallePagoRepository.findById(1)).thenReturn(Optional.of(detalle));

        DetallePagoDTO result = detallePagoService.getDetalleById(1);
        assertNotNull(result);
        assertEquals(1, result.getIdDetalle());
    }

    @Test
    void testSaveDetalle() {
        Pago pago = Pago.builder().idPago(1).idCliente(1).idProveedor(1).concepto("Test").total(100.0).fechaCreacion(null).fechaActualizacion(null).build();;
        DetallePago detalle = new DetallePago(null, pago, 101, 2.0, 50.0, null, null);
        when(pagoRepository.findById(1)).thenReturn(Optional.of(pago));
        when(detallePagoRepository.save(any(DetallePago.class))).thenReturn(new DetallePago(1, pago, 101, 2.0, 50.0, null, null));

        DetallePagoDTO result = detallePagoService.saveDetalle(new DetallePagoDTO(null, 1, 101, 2.0, 50.0));
        assertNotNull(result);
        assertEquals(1, result.getIdDetalle());
    }

    @Test
    void testDeleteDetalle() {
        detallePagoService.deleteDetalle(1);
        verify(detallePagoRepository, times(1)).deleteById(1);
    }
}