package EjercicioAcualizado.Objetos;

import jakarta.persistence.*;
import models.User;

/**
 * esquema de tabla del objeto
 */
@Entity
@Table(name = "address")
public class Address {
    /**
     * se le agrega anotaciones a cada atributo
     * el id se genera automaticamente por persistencia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * se establece la relacion de las tablas y los datos utilizados
     */
    @OneToOne(mappedBy = "address")
    private Persona user;
    /**
     * columna con detalles
     */
    @Column(name = "full_description")
    private String fullDescription;

    /**
     * constructores personalizados
     */
    public Address(Persona user, String fullDescription) {
        this.user = user;
        this.fullDescription = fullDescription;
    }

    public Address(Persona user, int id) {
        this.user = user;
        this.id = id;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getUser() {
        return user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
