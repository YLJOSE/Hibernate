package EjercicioAcualizado;

import EjercicioAcualizado.DAO.PersonaDAO;
import EjercicioAcualizado.Generics.DAO;
import EjercicioAcualizado.Objetos.Address;
import EjercicioAcualizado.Objetos.Persona;
import Utils.HibernateUtil;

public class df {
    public static void main(String[] args) {

        DAO personaDAO = new PersonaDAO();

        Address address = new Address();
        address.setFullDescription("juas juas juas juas");
        Persona persona = new Persona();
        persona.setName("pedro");
        persona.setAddress(address);

        personaDAO.save(persona);

        HibernateUtil.shutdown();
    }
}
