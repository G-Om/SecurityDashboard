package ecom.services.dashboard.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceDependency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DependentServiceName", length = 45, nullable = false)
    private String dependentServiceName;

    @Column(name = "Status", length = 45, nullable = false)
    private String status;

    @Column(name = "Dependencycol", length = 45)
    private String dependencyCol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "microservice_id", nullable = false)
    private MicroService microservice;

}
