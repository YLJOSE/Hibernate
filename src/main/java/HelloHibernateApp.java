import DAOS.StudentDAO;
import jakarta.transaction.SystemException;
import models.Student;
import Utils.HibernateUtil;

public class HelloHibernateApp {
    public static void main(String[] args) throws SystemException {
        StudentDAO studentDAO = new StudentDAO();

        // Create new students
        Student student1 = new Student();
        student1.setId(1);
        student1.setNombre("Amit Sharma");
        student1.setEmail("amit.sharma@example.com");
        student1.setAverageMark(2.0f);

        Student student2 = new Student();
        student2.setId(2);
        student2.setNombre("Priya Singh");
        student2.setEmail("priya.singh@example.com");
        student2.setAverageMark(4.76f);

        Student es = new Student();
        es.setId(3);
        es.setNombre("nuevoooo");
        es.setEmail("nuevooo@gmail.com");
        es.setAverageMark(4.76f);
        // Save students
        try {
            studentDAO.saveStudent(es);
            studentDAO.saveStudent(student1);
            studentDAO.saveStudent(student2);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
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
