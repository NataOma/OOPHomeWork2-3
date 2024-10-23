package Model.TreePersons;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeIterator<Human> implements Iterator<Human> {
    private final ArrayList<Human> tree;
    Integer index = 0;

    public TreeIterator(ArrayList<Human> tree){
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public Human next() {
        return tree.get(index++);
    }
}
