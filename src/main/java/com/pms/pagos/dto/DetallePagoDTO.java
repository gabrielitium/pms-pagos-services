package com.pms.pagos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePagoDTO {
    private Integer idDetalle;
    private Integer idPago;
    private Integer idProducto;
    private Double cantidad;
    private Double importe;
}