import java.io.Serializable;  //for serializtion Serializable interface have to import
public class student implements Serializable {   //which class/class's object we are want to serialize, we have to use 'implements serializble'
    private static final long serialVersionUID = 1L; //by default there has a serialization version id generate in enery conversion. if we update in class after serializable, the time of deserialization it will not match the previous version id, it will give error, that's why mnually serial version id created. If we update also, thre will not give any errorat the time of deseriliztion
    public int roll;   //access modifier take as public, because of access the variable outside of class or package, you can change it. for private you hve to use getimput() for taking input....
    public String name;
    public int age;
}