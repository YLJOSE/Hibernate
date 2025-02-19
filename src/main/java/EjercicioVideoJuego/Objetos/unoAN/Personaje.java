package EjercicioVideoJuego.Objetos.unoAN;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personajes")
public class Personaje {

    private Arma arma;

    @ManyToOne
    @JoinColumn(name = "id_arma")
    public Arma getArma() {
        return arma;
    }


}
