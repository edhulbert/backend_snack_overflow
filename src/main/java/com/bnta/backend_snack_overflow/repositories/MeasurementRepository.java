package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
