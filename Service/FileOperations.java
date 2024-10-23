package Service;
import Model.TreePersons.TreePerson;
import java.io.*;

public class FileOperations implements FileWork{
    public void saveFile(TreePerson tree, String path) throws IOException{
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new
                FileOutputStream(path))) {

            objectOutputStream.writeObject(tree);
        }
    }
    public TreePerson loadTree(String path) throws IOException, ClassNotFoundException{
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (TreePerson) objectInputStream.readObject();
        }
    }
}
