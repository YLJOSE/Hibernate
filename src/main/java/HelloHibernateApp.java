import DAOS.StudentDAO;
import DAOS.UserDAO;
import jakarta.transaction.SystemException;
import models.Address;
import models.Student;
import Utils.HibernateUtil;
import models.User;

public class HelloHibernateApp {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        Address address = new Address();
        User user = new User();

        address.setFullDescription("nomlo sé broooo jajajaj");
        user.setAddress(address);

        try {
            userDAO.saveUser(user);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }

//        StudentDAO studentDAO = new StudentDAO();
//
//        // Create new students
//        Student student1 = new Student();
//        student1.setNombre("nuevo dos");
//        student1.setEmail("amit.sharma@example.com");
//        student1.setAverageMark(2.0f);
//
//        Student student2 = new Student();
//        student2.setNombre("nuevo tres");
//        student2.setEmail("priya.singh@example.com");
//        student2.setAverageMark(4.76f);
//
//        Student es = new Student();
//        es.setNombre("nuevoooo cuatro");
//        es.setEmail("nuevooo@gmail.com");
//        es.setAverageMark(4.76f);
//        // Save students
//        try {
//            studentDAO.saveStudent(es);
//            studentDAO.saveStudent(student1);
//            studentDAO.saveStudent(student2);
//        } catch (SystemException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        // Update student
//        student1.setEmail("amit.sharma_updated@example.com");
//        try {
//            studentDAO.updateStudent(student1);
//            student2.setEmail("nuevo@email.com");
//            studentDAO.updateStudent(student2);
//        } catch (SystemException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        // Get student by ID
//        Student retrievedStudent = studentDAO.getStudentById(student1.getId());
//        System.out.println("Retrieved Student: " + retrievedStudent.getNombre() + " - " + retrievedStudent.getEmail());
//
//        // Get all students
//        List<Student> students = studentDAO.getAllStudents();
//        System.out.println("All Students:");
//        students.forEach(student -> System.out.println(student.getNombre() + " - " + student.getEmail()));
//
//        // Delete student
  //    studentDAO.deleteStudent(0);
//
//        // Get all students after deletion
//        students = studentDAO.getAllStudents();
//        System.out.println("All Students after deletion:");
//        students.forEach(student -> System.out.println(student.getNombre() + " - " + student.getEmail()));

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }

}
