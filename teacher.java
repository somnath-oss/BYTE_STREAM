import java.io.Serializable;
public class teacher implements Serializable {
    public int id;
    public String name;
    //public int age;   //if you serialize nd deserialize one time then uncommant 'public int age;'and try to deserialize, you will see serial version id are not same and it will not be deserilize.
} 
