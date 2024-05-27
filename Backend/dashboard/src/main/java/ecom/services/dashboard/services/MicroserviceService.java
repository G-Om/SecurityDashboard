package ecom.services.dashboard.services;


import ecom.services.dashboard.entites.Microservice;
import ecom.services.dashboard.repository.MicroserviceRepository;
import ecom.services.dashboard.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicroserviceService {

    @Autowired
    private MicroserviceRepository microserviceRepository;

    public List<Microservice> findAll() {
        return microserviceRepository.findAll();
    }

    public Optional<Microservice> findById(Long id) {
        return microserviceRepository.findById(id);
    }

    public Microservice save(Microservice microservice) {
        return microserviceRepository.save(microservice);
    }

    public Microservice update(Long id, Microservice microserviceDetails) {
        Microservice microservice = microserviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Microservice not found with id " + id));

        microservice.setName(microserviceDetails.getName());
        microservice.setDescription(microserviceDetails.getDescription());
        microservice.setVersion(microserviceDetails.getVersion());
        microservice.setEnvironment(microserviceDetails.getEnvironment());
        // Add logic for updating apiList, dbConnection, dependencyList if needed

        return microserviceRepository.save(microservice);
    }

    public void delete(Long id) {
        Microservice microservice = microserviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Microservice not found with id " + id));

        microserviceRepository.delete(microservice);
    }
}