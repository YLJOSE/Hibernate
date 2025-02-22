package EjercicioPersonaTieneVariasMotosYCarros.Objetos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "edad")
    private int edad;

    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Motos> motos;

    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Carros> carros;


    public Persona() {

    }

    public Persona(String nombre, String correo, int edad, Set<Motos> motos, Set<Carros> carros) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.motos = motos;
        this.carros = carros;
    }

    public Persona(String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Motos> getMotos() {
        return motos;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", motos=" + (motos != null ? motos.size():0) +
                ", carros=" + (carros != null ? carros.size():0) +
                '}';
    }

    public void setMotos(Set<Motos> motos) {
        this.motos = motos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Carros> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carros> carros) {
        this.carros = carros;
    }


}
