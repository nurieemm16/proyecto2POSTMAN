/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculomaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author nuria
 */
@RestController
@RequestMapping("/vehiculo")
public class vehiculoControler {
    
@Autowired //se utiliza para inyectar una instancia de un objeto en otro objeto, lo que permite que los objetos se comuniquen entre sí y compartan recursos. Esto facilita la creación de aplicaciones más escalables y mantenibles.
    private vehiculoRepository vehiculoRepository; //para poder trabajar con personrepository

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    @GetMapping("/{id}") //aquesta barra vol dir que aquí portarem un id, aquest id es una variable, per tant pathvraiable.Esto va a venir por la url y por tanto es variable pq no lo veo
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Integer id) { //configurar variables dentro de los propios segmentos de la URL 
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id); //para encontrar el id
        if (vehiculo.isPresent()) {
            return ResponseEntity.ok(vehiculo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculoDetails) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if (vehiculo.isPresent()) {
            Vehiculo vehiculoToUpdate = vehiculo.get();
            vehiculoToUpdate.setTipo(vehiculoDetails.getTipo());
            vehiculoToUpdate.setMarca(vehiculoDetails.getMarca());
            vehiculoToUpdate.setPotencia(vehiculoDetails.getPotencia());
             vehiculoToUpdate.setFechaCompra(vehiculoDetails.getFechaCompra());
            
            return ResponseEntity.ok(vehiculoRepository.save(vehiculoToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable Integer id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if (vehiculo.isPresent()) {
            vehiculoRepository.delete(vehiculo.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


}
