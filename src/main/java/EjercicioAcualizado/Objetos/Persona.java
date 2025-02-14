package EjercicioAcualizado.Objetos;


import jakarta.persistence.*;

/**
 * esquema de tabla dandole el nombre respectivo a cada elemento
 */
@Entity
@Table(name = "Personas")
public class Persona {
    /**
     * se le agrega anotaciones a cada atributo
     * el id se genera automaticamente por persistencia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * la columna
     */
    @Column(name = "name")
    private String name;
    /**
     * en esta parte agregaremos las anotaciones de la relacion que tiene (ManyToMany,
     * ManyToOne,OneToMany,OneToOne)
     * y la relacion con el objeto address se genera una nueva columno con la relacion
     * es decir toma el id de referencia del otro objeto(tabla);
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    /**
     * constructores personalizados y getters y setters
     */
    public Persona(Address address) {
        this.address = address;
    }

    public Persona(String name, Address address) {
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Persona() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
