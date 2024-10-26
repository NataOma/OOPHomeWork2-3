import Model.Humans.Human;
import Model.Humans.Sex;
import Service.FileOperations;
import Model.TreePersons.TreePerson;
import Service.Service;

import java.io.*;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        LocalDate date_of_birthday = LocalDate.parse("2014-01-10");
//        System.out.println(date_of_birthday);
        Service service = new Service();
        service.addPerson(LocalDate.of(1984, 8, 28), "Daniil", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(1982, 3, 29), "Kirill", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(1979, 11, 15), "Pavel", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(1988, 1, 31), "Alex", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(1946, 6, 3), "Fedor", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(1950, 7, 26), "Tatyana", "Ermoshina", Sex.FEMALE.getSex());
        service.addPerson(LocalDate.of(2012, 12, 23), "Dmitry", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(2018, 2, 7), "Yulia", "Ermoshina", Sex.FEMALE.getSex());
        service.addPerson(LocalDate.of(2008, 11, 17), "Sergey", "Ermoshin", Sex.MALE.getSex());
        service.addPerson(LocalDate.of(2020, 3, 14), "Evsey", "Ermoshin", Sex.MALE.getSex());
        for (Human human: service.getTree()){
            System.out.println(human);
        }
        System.out.println(service.getTree().findHuman("Yulia", "Ermoshina", "2018-02-07"));
        for (int i = 0; i < 5; i++) {
            System.out.println("!!!!");
        }
        service.getTree().findHuman("Daniil", "Ermoshin", "1984-08-28").addChildren(
                service.getTree().findHuman("Yulia", "Ermoshina", "2018-02-07")
        );
        service.getTree().findHuman("Daniil", "Ermoshin", "1984-08-28").addChildren(
                service.getTree().findHuman("Dmitry", "Ermoshin", "2012-12-23")
        );
        service.getTree().findHuman("Fedor", "Ermoshin", "1946-06-03").addChildren(
                service.getTree().findHuman("Pavel", "Ermoshin", "1979-11-15")
        );
        service.getTree().findHuman("Fedor", "Ermoshin", "1946-06-03").addChildren(
                service.getTree().findHuman("Kirill","Ermoshin", "1982-03-29")
        );
        service.getTree().findHuman("Fedor", "Ermoshin", "1946-06-03").addChildren(
                service.getTree().findHuman("Daniil","Ermoshin", "1984-08-28")
        );
        service.getTree().findHuman("Fedor", "Ermoshin", "1946-06-03").addChildren(
                service.getTree().findHuman("Alex", "Ermoshin", "1988-01-31")
        );
        TreePerson familyTree = new TreePerson();
        Human daniil = new Human(LocalDate.of(1984, 8, 28), "Daniil", "Ermoshin", Sex.MALE.getSex());
        Human kirill = new Human(LocalDate.of(1982, 3, 29), "Kirill", "Ermoshin", Sex.MALE.getSex());
        Human pavel = new Human(LocalDate.of(1979, 11, 15), "Pavel", "Ermoshin", Sex.MALE.getSex());
        Human alex = new Human(LocalDate.of(1988, 1, 31), "Alex", "Ermoshin", Sex.MALE.getSex());
        Human fedor = new Human(LocalDate.of(1946, 6, 3), "Fedor", "Ermoshin", Sex.MALE.getSex());
        Human tatyana = new Human(LocalDate.of(1950, 7, 26), "Tatyana", "Ermoshina", Sex.FEMALE.getSex());
        Human dima = new Human(LocalDate.of(2012, 12, 23), "Dmitry", "Ermoshin", Sex.MALE.getSex());
        Human yulia = new Human(LocalDate.of(2018, 2, 7), "Yulia", "Ermoshina", Sex.FEMALE.getSex());
        Human sergey = new Human(LocalDate.of(2008, 11, 17), "Sergey", "Ermoshin", Sex.MALE.getSex());
        Human evsey = new Human(LocalDate.of(2020, 3, 14), "Evsey", "Ermoshin", Sex.MALE.getSex());
        daniil.setFather(fedor);
        daniil.setMother(tatyana);
        kirill.setFather(fedor);
        kirill.setMother(tatyana);
        pavel.setFather(fedor);
        pavel.setMother(tatyana);
        alex.setFather(fedor);
        alex.setMother(tatyana);
        dima.setFather(daniil);
        yulia.setFather(daniil);
        sergey.setFather(pavel);
        evsey.setFather(alex);
        Human[] humans = {daniil, kirill, pavel, fedor, tatyana, alex, dima, yulia, sergey, evsey};
        familyTree.addHuman(humans);
        System.out.println(familyTree.getChild(daniil));
        System.out.println("This is original tree:");
        System.out.println(familyTree);
        FileOperations fo = new FileOperations();
        try {
            fo.saveFile(familyTree, "src/treeFamily.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
        TreePerson newTree = null;
        try {
            newTree = fo.loadTree("src/treeFamily.txt");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("This is loaded tree:");
        if (!(newTree == null)) {
            System.out.println(newTree);
            newTree.sortByName();
            System.out.println(newTree);

            newTree.sortByAge();
            System.out.println(newTree);

            newTree.SortById();
            System.out.println(newTree);

        }

    }
}