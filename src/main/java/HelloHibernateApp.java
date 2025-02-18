import DAOS.CartDAO;
import DAOS.ItemDAO;
import DAOS.StudentDAO;
import DAOS.UserDAO;
import jakarta.transaction.SystemException;
import models.*;
import Utils.HibernateUtil;

public class HelloHibernateApp {
    public static void main(String[] args) {

        /***
         * de carrito a item es de uno a muchos y de item a carrito es de muchos a uno
         * **/

////
//        CartDAO cartDAO = new CartDAO();
//        ItemDAO itemDAO = new ItemDAO();
//
////        Cart cart = new Cart();
////        cart.setName("carrito uno");
//
//        Cart cart2 = new Cart();
//        cart2.setName("carrito dos");
////
////        try {
////            cartDAO.saveCart(cart2);
////        } catch (SystemException e) {
////            throw new RuntimeException(e);
////        }
//
//        Item item7 = new Item();
//        item7.setCart(cart2);
//        item7.setName("Juguete siuuuu");
//
//        item7.setCart(cartDAO.getCartById(2));
//
//        try {
//            itemDAO.saveItem(item7);
//        } catch (SystemException e) {
//            throw new RuntimeException(e);
//        }

//        Item item = new Item();
//        item.setCart(cartDAO.getCartById(1));
//        item.setName("Juguete de webds   1");
//
//        Item item1 = new Item();
//        item1.setCart(cartDAO.getCartById(1));
//        item1.setName("Juguete de webds  2 ");
//
//        Item item2 = new Item();
//        item2.setCart(cartDAO.getCartById(1));
//        item2.setName("Juguete de webds  3  ");
//
//        Item item3 = new Item();
//        item3.setCart(cartDAO.getCartById(1));
//        item3.setName("Juguete de webds  4  ");
//
//        Item item4 = new Item();
//        item4.setCart(cartDAO.getCartById(1));
//        item4.setName("Juguete de webds  5  ");
//
//        try {
//            itemDAO.saveItem(item);
//            itemDAO.saveItem(item1);
//            itemDAO.saveItem(item2);
//            itemDAO.saveItem(item3);
//            itemDAO.saveItem(item4);
//        } catch (SystemException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("-----------------------------------------");

//        try {
//            cartDAO.saveCart(cart);
//        } catch (SystemException e) {
//            throw new RuntimeException(e);
//        }

/**
 * User es uno a uno**/
//        UserDAO userDAO = new UserDAO();
//
//        Address address = new Address();
//        User user = new User();
//
//        address.setFullDescription("nomlo sé broooo jajajaj");
//        user.setAddress(address);
//
//        try {
//            userDAO.saveUser(user);
//        } catch (SystemException e) {
//            throw new RuntimeException(e);
//        }

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
