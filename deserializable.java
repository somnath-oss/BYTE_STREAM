import java.io.FileInputStream;   //FileInputStream → Reads the serialized file.
import java.io.ObjectInputStream;   //ObjectInputStream → Converts bytes back into an object.
import java.io.IOException;   //IOException → Handles file-related errors.

public class deserializable {
    public static void main(String[] args) {
        String filename = "student.txt";   //// Path to the serialized file or if it is in current folder then it's name
        try {
            FileInputStream fileIn = new FileInputStream(filename);   // Create a file input stream to read the file
            ObjectInputStream objIn = new ObjectInputStream(fileIn);   // Create an object input stream to deserialize the object

            student s1 = (student) objIn.readObject();   //The readObject() method reads the byte stream and converts it into a student object.
            // Typecasting ((student)) is required because readObject() returns an Object.
            
            //Always close the streams to free system resources.
            objIn.close();
            fileIn.close();

            System.out.println("Student object deserialized successfully!");
            System.out.println("Roll: " + s1.roll);
            System.out.println("Name: " + s1.name);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error! Unable to deserialize object.");
        }
    }
}
