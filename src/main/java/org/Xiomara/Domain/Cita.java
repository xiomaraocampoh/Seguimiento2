package org.Xiomara.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "citas")

public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    // Constructor con parámetros


    public Cita(Long id, Veterinario veterinario, Mascota mascota, Date fecha, String motivo) {
        this.id = id;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    public Cita(Mascota mascota, Date date, String chequeoGeneral, Veterinario veterinario) {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
