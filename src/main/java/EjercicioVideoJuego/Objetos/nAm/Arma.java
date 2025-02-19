package EjercicioVideoJuego.Objetos.nAm;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "armas")
public class Arma {

    private List<Enemigo> enemigos;

    @ManyToMany(cascade = CascadeType.DETACH, mappedBy = "armas")
    public List<Enemigo> getEnemigos() { return enemigos; }

}
