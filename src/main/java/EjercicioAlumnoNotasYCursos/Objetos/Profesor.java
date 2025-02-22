package EjercicioAlumnoNotasYCursos.Objetos;


import jakarta.persistence.*;
import java.util.Set;

import java.util.HashSet;


@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación uno a muchos con Asignatura
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Asignatura> asignaturas = new HashSet<>();

    public Profesor() {}

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", asignaturas=" + asignaturas.size()+
                '}';
    }
}
