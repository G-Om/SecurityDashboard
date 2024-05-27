package ecom.services.dashboard.controller;

import ecom.services.dashboard.entites.Microservice;
import ecom.services.dashboard.services.MicroserviceService;
import ecom.services.dashboard.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services/api/dashboard/microservice")
public class MicroserviceController {
    @Autowired
    private MicroserviceService microserviceService;

    @GetMapping()
    public List<Microservice> getAllMicroservices() {
        return microserviceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Microservice> getMicroserviceById(@PathVariable Long id) {
        Microservice microservice = microserviceService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Microservice not found with id " + id));
        return ResponseEntity.ok(microservice);
    }

    @PostMapping
    public Microservice createMicroservice(@RequestBody Microservice microservice) {
        return microserviceService.save(microservice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Microservice> updateMicroservice(@PathVariable Long id, @RequestBody Microservice microserviceDetails) {
        Microservice updatedMicroservice = microserviceService.update(id, microserviceDetails);
        return ResponseEntity.ok(updatedMicroservice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMicroservice(@PathVariable Long id) {
        microserviceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


