package Model.Humans;

public enum Sex {
    MALE("мужской"), FEMALE("женский");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
