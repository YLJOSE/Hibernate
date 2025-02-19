package EjercicioVideoJuego.Objetos.nAm;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "enemigos")
public class Enemigo {

    private List<Arma> armas;

    // Cuando se elimine un personaje se desvínculará el arma pero ésta no se borrará (DETACH)
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="enemigo_arma",
            joinColumns={@JoinColumn(name="id_enemigo")},
            inverseJoinColumns={@JoinColumn(name="id_arma")})
    public List<Arma> getArmas() { return armas; }

}
