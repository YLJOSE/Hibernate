package EjercicioVideoJuego.Objetos.unoAN;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "armas")
public class Arma {

    private List<Personaje> personajes;

    @OneToMany(mappedBy = "arma", cascade = CascadeType.ALL)
    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
