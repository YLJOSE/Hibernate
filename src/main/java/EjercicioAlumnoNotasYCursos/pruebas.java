package EjercicioAlumnoNotasYCursos;

import EjercicioAlumnoNotasYCursos.DAO.AlumnoDAO;
import EjercicioAlumnoNotasYCursos.DAO.AsignaturaDAO;
import EjercicioAlumnoNotasYCursos.DAO.ProfesorDAO;
import EjercicioAlumnoNotasYCursos.Objetos.Alumno;
import EjercicioAlumnoNotasYCursos.Objetos.Asignatura;
import EjercicioAlumnoNotasYCursos.Objetos.Profesor;
import Utils.HibernateUtil;

import java.util.List;

public class pruebas {
    public static void main(String[] args) {
//        Profesor profesor = new Profesor("Elver gudo perez");
//        Profesor profesor2 = new Profesor("Eel chuchaaa");
//        Profesor profesor3 = new Profesor("el pendejo broer");
//
//        Asignatura asignatura = new Asignatura("Matematica", profesor);
//        Asignatura asignatura2 = new Asignatura("Ciencias", profesor2);
//        Asignatura asignatura3 = new Asignatura("Algebra", profesor3);
//
//
//        Alumno alumno1 = new Alumno("pedro");
//        alumno1.getAsignaturas().add(asignatura);
//
//        Alumno alumno2 = new Alumno("carlos");
//        alumno2.getAsignaturas().add(asignatura2);
//
//        Alumno alumno3 = new Alumno("luis");
//        alumno3.getAsignaturas().add(asignatura3);
//
//        Alumno alumno4 = new Alumno("cesar");
//        alumno4.getAsignaturas().add(asignatura);
//
//        Alumno alumno5 = new Alumno("Angel");
//        alumno5.getAsignaturas().add(asignatura3);
//
//        profesor.getAsignaturas().add(asignatura);
//        profesor2.getAsignaturas().add(asignatura2);
//        profesor3.getAsignaturas().add(asignatura3);
//
//        asignatura.getAlumnos().add(alumno1);
//        asignatura.getAlumnos().add(alumno4);
//
//        asignatura2.getAlumnos().add(alumno2);
//
//        asignatura3.getAlumnos().add(alumno3);
//        asignatura3.getAlumnos().add(alumno5);
//
//
        ProfesorDAO profesorDAO = new ProfesorDAO();

         List<Profesor> p = profesorDAO.getAll();
         p.forEach(System.out::println);
//        profesorDAO.save(profesor);
//        profesorDAO.save(profesor2);
//        profesorDAO.save(profesor3);
//
//
        AlumnoDAO alumnoDAO = new AlumnoDAO();
//        alumnoDAO.save(alumno1);
//        alumnoDAO.save(alumno2);
//        alumnoDAO.save(alumno3);
//        alumnoDAO.save(alumno4);
//        alumnoDAO.save(alumno5);
//
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
//        asignaturaDAO.save(asignatura);
//        asignaturaDAO.save(asignatura2);
//        asignaturaDAO.save(asignatura3);


        // Shut down the SessionFactory
        HibernateUtil.shutdown();
        // no olvidar de poner el nombre al hacer from "nombre de la clase que esta en hibernate.cfg.xml"
        // revisar siempre el hibernate.cfg.xml

    }
}
