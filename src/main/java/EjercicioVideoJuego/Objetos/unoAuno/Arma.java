package EjercicioVideoJuego.Objetos.unoAuno;

import jakarta.persistence.*;

@Entity
@Table(name = "armas")
public class Arma {


    private Personaje personaje;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Personaje getPersonaje() {
        return personaje;
    }

}
