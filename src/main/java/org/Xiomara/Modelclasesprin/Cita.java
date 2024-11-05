package org.Xiomara.Modelclasesprin;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;

    @ManyToOne
    private Mascota mascota;

    // Constructores, getters y setters
    public Cita(String fecha) {}

    public Cita(LocalDateTime fecha, Mascota mascota) {
        this.fecha = fecha;
        this.mascota = mascota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
