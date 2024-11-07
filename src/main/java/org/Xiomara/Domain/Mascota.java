package org.Xiomara.Domain;

import org.Xiomara.Enums.EstadoSalud;
import org.Xiomara.Enums.TipoAnimal;

import javax.persistence.*;

@Entity
@Table(name = "mascotas")

public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoAnimal tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_salud", nullable = false)
    private EstadoSalud estadoSalud;

    public Mascota(String nombre, TipoAnimal tipo, EstadoSalud estadoSalud) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estadoSalud = estadoSalud;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(EstadoSalud estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
}