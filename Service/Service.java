package Service;

import Model.Humans.Human;
import Model.TreePersons.TreePerson;

import java.time.LocalDate;

public class Service {
    private int ID = 1;
    TreePerson familyTree;

    public Service(){
        familyTree = new TreePerson();
    }
    public void addPerson(LocalDate dob, String firstName, String lastName, String sex){
        Human human = new Human(dob,firstName,lastName, sex);
        human.setId(ID++);
        familyTree.addHuman(human);
    }
    public TreePerson getTree(){
        return familyTree;
    }

}
