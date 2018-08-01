package at.bitmedia.schoolreader.entity;

public enum TypeTask {
    Class("Class"), Individual("Individual");
    private String name;

    private TypeTask(String name) {
        this.name = name;
    }

    TypeTask() {
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
