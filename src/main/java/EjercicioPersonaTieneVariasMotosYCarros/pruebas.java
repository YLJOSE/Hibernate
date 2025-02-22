package EjercicioPersonaTieneVariasMotosYCarros;

import EjercicioPersonaTieneVariasMotosYCarros.DAO.carroDAO;
import EjercicioPersonaTieneVariasMotosYCarros.DAO.motoDAO;
import EjercicioPersonaTieneVariasMotosYCarros.DAO.personaDAO;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Carros;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Motos;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Persona;
import Utils.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class pruebas {
    public static void main(String[] args) {
//
//        Persona persona = new Persona("juanjo","juanjo@gmail.com",20);
//
//        Motos moto = new Motos("Honda","es una moto de la ptmre weon te la vas a rifar csmre jajaja");
//
//        moto.setPersona(persona);
//        Motos moto2 = new Motos("Yamaha","es una moto de la ptmre weon te la vas a rifar csmre jajaja");
//        moto2.setPersona(persona);
//
//        Carros carro = new Carros("Hyundai","buen carro broer alm jajaja");
//        carro.setPersona(persona);
//
//        Carros carro2 = new Carros("Chevrolet","buen carro broer alm jajaja");
//        carro2.setPersona(persona);
//
//
//        personaDAO personaDAO = new personaDAO();
//        personaDAO.save(persona);
//
//        carroDAO carroDAO = new carroDAO();
//        carroDAO.save(carro);
//        carroDAO.save(carro2);
//
//        motoDAO  motoDAO = new motoDAO();
//        motoDAO.save(moto);
//        motoDAO.save(moto2);
//
//        Persona persona = new Persona("lelitas","lelas@gmail.com",21);

//        Motos moto = new Motos("Pulsar","es una moto de la csmre jajaja");
//
//        moto.setPersona(persona);
//        Motos moto2 = new Motos("Yamaha","es una moto de la csmre jajaja");
//        moto2.setPersona(persona);
//
//        Carros carro = new Carros("Peugeot","buen carro broer alm jajaja");
//        carro.setPersona(persona);
//
//        Carros carro2 = new Carros("Audi","buen carro broer alm jajaja");
//        carro2.setPersona(persona);
//
//
//        carroDAO carroDAO = new carroDAO();
//         List<Carros> carros = carroDAO.getAll();
//         carros.forEach(System.out::println);

        motoDAO  motoDAO = new motoDAO();
        List<Motos> motos = motoDAO.getAll();
        motos.forEach(System.out::println);

//        personaDAO personaDAO = new personaDAO();
//
//        List<Persona> p = personaDAO.getAll();
//        p.forEach(System.out::println);


//        personaDAO.save(persona);
//
//
//        carroDAO.save(carro);
//        carroDAO.save(carro2);
//
//
//        motoDAO.save(moto);
//        motoDAO.save(moto2);


        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
}
