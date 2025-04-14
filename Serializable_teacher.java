import java.io.FileOutputStream; //'FileOutputStream' interface Use to create a file and write raw bytes to it.
import java.io.ObjectOutputStream;  //'ObjectOutputStream' interface Converts objects into a byte stream that can be saved or transmitted.
import java.io.IOException;   //'IOException' interface Handles input/output exceptions (e.g., file not found, writing errors).


public class Serializable_teacher{
    public static void main(String[] args) {
        teacher t1= new teacher();
        t1.id=452;
        t1.name="Subhas";
        String filename="teacher.ser"; //you can give the full path, where you want to store the file. Ex:"C:\\users\\Dektop\\student.txt" 
        //if you don't give path, then the file will be generated in your current directory.
        //.ser and .txt this two extension is used, you can use anyone of this.

        try {
            FileOutputStream fileout=new FileOutputStream(filename);   //FileOutputStream("student.ser") → Creates a file named student.ser where the object will be saved.
            ObjectOutputStream objout=new ObjectOutputStream(fileout);   //ObjectOutputStream(fileOut) → Wraps FileOutputStream to write Java objects in a serialized form.
            
            objout.writeObject(t1);   //The writeObject(student) method serializes the student object and writes it to the file (student.ser).
                //This step converts the object into a byte stream that can be stored or sent over a network.

            //Closes both streams to free resources and ensure data is properly saved.
            objout.close();
            fileout.close();

            System.out.println("student object serialized sucessfully");
            
        } 
        catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();   //e.printStackTrace(); is a method that prints the complete error details (stack trace) when an exception occurs.
            System.out.println("Error! unable to serialized object");

        }
    }
} 
