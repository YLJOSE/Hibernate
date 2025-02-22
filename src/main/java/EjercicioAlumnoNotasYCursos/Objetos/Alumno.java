package EjercicioAlumnoNotasYCursos.Objetos;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación muchos a muchos con Asignatura
    @ManyToMany
    @JoinTable(
            name = "alumno_asignatura",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id"))
    private Set<Asignatura> asignaturas = new HashSet<>(); // Usamos un Set para evitar duplicados

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno() {}

    public Alumno(String nombre) {
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
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", asignaturas=" + (asignaturas != null ? asignaturas.size() : null) +
                '}';
    }
}
