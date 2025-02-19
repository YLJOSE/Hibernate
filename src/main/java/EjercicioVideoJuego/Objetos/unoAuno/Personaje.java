package EjercicioVideoJuego.Objetos.unoAuno;

import jakarta.persistence.*;

@Entity
@Table(name = "personajes")
public class Personaje {


    private Arma arma;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Arma getArma() {
        return arma;
    }

}
