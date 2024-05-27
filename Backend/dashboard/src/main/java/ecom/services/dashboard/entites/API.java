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
public class API {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "description", length = 45)
    private String description;

    @Column(name = "type", length = 45)
    private String type;

    @Column(name = "authorization", length = 45)
    private String authorization;

    @Column(name = "url", length = 45)
    private String url;

    @Column(name = "responsePayload", length = 45)
    private String responsePayload;

    @Column(name = "requestPayload", length = 45)
    private String requestPayload;

    @Column(name = "host", length = 45)
    private String host;

    @Column(name = "portNumber")
    private Integer portNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "microservice_id", nullable = false)
    private MicroService microservice;

}
