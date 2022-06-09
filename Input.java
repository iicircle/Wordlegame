import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Input implements Serializable {
  public String name;
  
  public HashMap<String, Integer> scorechart = new HashMap<String, Integer>();

  public String toString () {
    return "name = " + name + "\nage = " + age + "\nhairColor = " + hairColor;
  }