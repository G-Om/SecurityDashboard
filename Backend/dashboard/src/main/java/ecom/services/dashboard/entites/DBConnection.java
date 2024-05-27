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
public class DBConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "connectionString", length = 45, nullable = false)
    private String connectionString;

    @Column(name = "database_type", length = 45, nullable = false)
    private String databaseType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "microservice_id", nullable = false)
    private Microservice microservice;
}
