package EjercicioPersonaTieneVariasMotosYCarros.Objetos;

import jakarta.persistence.*;

@Entity
@Table(name = "motos")
public class Motos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    public Motos(String marca, String descripcion) {
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public Motos() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Motos{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", persona=" + (persona != null ?  persona : null) +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
