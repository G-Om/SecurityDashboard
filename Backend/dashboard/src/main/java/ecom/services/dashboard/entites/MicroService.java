package ecom.services.dashboard.entites;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MicroService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name" , nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String version;

    @Column
    private String environment;


    @OneToMany(mappedBy = "microservice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<API> apiList;

    @OneToOne(mappedBy = "microservice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DBConnection dbConnection;

    @OneToMany(mappedBy = "microservice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServiceDependency> dependencyList;
}
