package Model.TreePersons;

import Model.Humans.ComparatorHumanByAge;
import Model.Humans.ComparatorHumanById;
import Model.Humans.ComparatorHumanByName;
import Model.Humans.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TreePerson implements Serializable, Iterable<Human> {
    private final ArrayList<Human> tree;

    public TreePerson(){
        this.tree = new ArrayList<>();
    }

    public void addHuman(Human human){
        if (!(human.getId()>0) & !this.tree.contains(human)) {
            this.tree.add(human);
        }
    }
    public void addHuman(Human[] humans){
        for (Human human: humans){
            addHuman(human);
        }
    }
    public ArrayList<Human> getChild(Human human){
        return human.getChild();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human: tree){
            sb.append(human).append(";\n");
        }
        return sb.toString();
    }
    public Human findHuman(String name){
        for(Human human: this.tree){
            if (name.equals(human.getFirstName())) return human;
        }
        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator<>(this.tree);
    }
    public void sortByName(){
        tree.sort(new ComparatorHumanByName());
    }
    public void sortByAge(){
        tree.sort(new ComparatorHumanByAge());
    }
    public void SortById(){
        tree.sort(new ComparatorHumanById());
    }
}
