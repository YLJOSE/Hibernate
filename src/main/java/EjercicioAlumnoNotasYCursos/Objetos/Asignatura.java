package EjercicioAlumnoNotasYCursos.Objetos;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación muchos a uno con Profesor
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    // Relación muchos a muchos con Alumno
    @ManyToMany(mappedBy = "asignaturas")
    private Set<Alumno> alumnos  = new HashSet<>(); // Usamos un Set para evitar duplicados

    public Asignatura() {}

    public Asignatura(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + (profesor != null ? profesor.getNombre() : null) +
                ", alumnos=" + (alumnos != null ? alumnos.size() : null) +
                '}';
    }
}
