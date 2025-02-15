package com.pms.pagos.repository;

import com.pms.pagos.model.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoPagoRepository extends JpaRepository<EstadoPago, Integer> {
}
