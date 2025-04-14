import java.io.*;

class Student implements Serializable {
    public int roll;
    public static String schoolName = "ABC School";  // Static field
    public transient String password;  // Transient field

    public Student(int roll, String password) {
        this.roll = roll;
        this.password = password;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Student student = new Student(5, "secretpassword");

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(student);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Modify static variable AFTER serialization
        Student.schoolName = "XYZ School";  

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Deserialized Student:");
            System.out.println("Roll: " + deserializedStudent.roll);       
            System.out.println("School Name: " + Student.schoolName);  // Will print "XYZ School"
            System.out.println("Password: " + deserializedStudent.password); // Will print null
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
