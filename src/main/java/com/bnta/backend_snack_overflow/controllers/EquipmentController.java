package com.bnta.backend_snack_overflow.controllers;

import com.bnta.backend_snack_overflow.models.Equipment;
import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("equipments")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        return new ResponseEntity<>(equipmentRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Equipment>> getEquipment(@PathVariable Long id) {
        var equipment = equipmentRepository.findById(id);
        return new ResponseEntity<>(equipment, equipment.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
        equipmentRepository.save(equipment);
        return new ResponseEntity<>(equipment, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Long id, @RequestBody Equipment equipmentUpdate) {
        var equipment = equipmentRepository.findById(id);

        if (equipment.isPresent()) {
            Equipment _equipment = equipment.get();
            _equipment.setName(equipmentUpdate.getName());
            equipmentRepository.save(_equipment);
            return new ResponseEntity<>(_equipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment (@PathVariable Long id) {

        try {
            equipmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}













