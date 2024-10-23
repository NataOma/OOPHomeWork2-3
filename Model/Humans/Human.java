package Model.Humans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Human implements Serializable {
    private Integer id = -1;
    private final LocalDate dob;
    private final String firstName;
    private final String sex;
    private Integer countChild = 0;

    public Human(LocalDate dob, String firstName, String lastName, String sex) {
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    private final String lastName;
    private LocalDate dod;
    private Human mother=null;
    private Human father=null;
    private final ArrayList<Human> child = new ArrayList<>();

    public Human getFather() {
        return this.father;
    }
    public Human getMother(){
        return this.mother;
    }
    public String getSex(){
        return this.sex;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setMother(Human mother){
        this.mother = mother;
        if (!mother.getChild().contains(this)) mother.addChildren(this);
    }
    public void setFather(Human father){
        this.father = father;
        if (!father.getChild().contains(this)) father.addChildren(this);
    }
    public void addChildren(Human children){
        countChild++;
        child.add(children);
        if(this.getSex().equals("male") & children.getFather() == null) children.setFather(this);
        else if(this.getSex().equals("female") & children.getMother() == null) children.setMother(this);
    }
    public Integer getCountChild(){
        return countChild;
    }
    public ArrayList<Human> getChild(){
        return this.child;
    }
    public LocalDate getDob(){
        return this.dob;
    }
    public Integer getAge(){
       Period age = this.getDob().until(LocalDate.now());
       return age.getYears();
    }
    public String getName(){
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(dob, human.dob) && Objects.equals(firstName, human.firstName) && Objects.equals(sex, human.sex) && Objects.equals(countChild, human.countChild) && Objects.equals(lastName, human.lastName) && Objects.equals(dod, human.dod) && Objects.equals(mother, human.mother) && Objects.equals(father, human.father) && Objects.equals(child, human.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dob, firstName, sex, countChild, lastName, dod, mother, father, child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", Name='").append(this.getName()).append('\'');
        sb.append(", Age='").append(this.getAge()).append("'");
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", Child=").append(countChild);
        if (dod != null) sb.append(", dod=").append(dod);
        else sb.append(", status: life");
        return sb.toString();
    }

//    @Override
//    public int compareTo(Human o) {
//        return 0;
//    }
}
