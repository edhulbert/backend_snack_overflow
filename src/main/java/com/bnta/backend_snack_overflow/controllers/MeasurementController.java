package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Measurement;
import com.bnta.backend_snack_overflow.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("measurements")
public class MeasurementController {
    @Autowired
    private MeasurementRepository measurementRepository;

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        return new ResponseEntity<>(measurementRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Measurement>> getMeasurement(@PathVariable Long id) {
        var measurement = measurementRepository.findById(id);
        return new ResponseEntity<>(measurement, measurement.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement measurement) {
        measurementRepository.save(measurement);
        return new ResponseEntity<>(measurement, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable Long id, @RequestBody Measurement measurementUpdate) {
        var measurement = measurementRepository.findById(id);

        if (measurement.isPresent()) {
            Measurement _measurement = measurement.get();
            _measurement.setIngredientAmount(measurementUpdate.getIngredientAmount());
            measurementRepository.save(_measurement);
            return new ResponseEntity<>(_measurement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteMeasurement (@PathVariable Long id) {

        try {
            measurementRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
