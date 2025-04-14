//if we don't know which object are present in the serilizable file, This code dynamically deserializes an object and prints all its fields without knowing its class structure beforehand. 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;  //Import Reflection API 
//Field (Reflection API) → Used to inspect object fields at runtime.

public class unknownDeserialization {
    public static void main(String[] args) {
        String filename = "teacher.ser";

        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            Object obj = objIn.readObject();  

            objIn.close();
            fileIn.close();

            System.out.println("Object deserialized successfully!");

            //Print all fields dynamically using Reflection
            Class<?> objClass = obj.getClass();  // Get the class of the object
            //objClass will store metadata (class name, methods, fields, etc.) about the object obj.
            //Class<?> is a generic type representing any class type.
            //The <?> means unknown type (wildcard), which allows Class to store any class type.
            //getClass() Determines the actual class of the deserialized object.
            System.out.println("Class Name: " + objClass.getName());  
            //Prints the class name, so we know what kind of object we are dealing with.
            //objClass.getName() → Gets the name of the class.

            for (Field field : objClass.getDeclaredFields()) {   //getDeclaredFields() → Gets all fields of the class (even private ones).
                field.setAccessible(true);  // Allow access to private fields 
                //setAccessible(true) → Bypasses private access so we can read private fields.
                System.out.println(field.getName() + ": " + field.get(obj));   //field.get(obj) → Reads each field’s value dynamically.
                //field.getName() → Gets the name of the field.
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
            //IOException →	File not found, or I/O issues.
            //ClassNotFoundException  → Class definition missing at runtime.
            //IllegalAccessException  → Trying to access a private field without permission.
            e.printStackTrace();
            System.out.println("Error! Unable to deserialize object.");
        }
    }
}
