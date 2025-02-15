package com.pms.pagos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Integer idPago;
    private Integer idCliente;
    private Integer idProveedor;
    private Integer estado_pago;
    private String concepto;
    private Double total;
}