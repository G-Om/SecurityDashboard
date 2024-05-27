package ecom.services.dashboard.repository;

import ecom.services.dashboard.entites.Microservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroserviceRepository extends JpaRepository<Microservice, Long> {
}