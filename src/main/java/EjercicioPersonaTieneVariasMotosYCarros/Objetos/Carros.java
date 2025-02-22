package EjercicioPersonaTieneVariasMotosYCarros.Objetos;


import jakarta.persistence.*;

@Entity
@Table(name = "carros")
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "persona_id",nullable = false)
    private Persona persona;

    public Carros(String marca, String descripcion) {
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public Carros() {

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

    @Override
    public String toString() {
        return "Carros{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", persona=" + (persona != null ?  persona : null) +
                '}';
    }
}
