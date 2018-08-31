package at.bitmedia.schoolreader.entity;


import javax.persistence.Enumerated;


public enum Status {
    New("New"), In_progress("In progress"), Done("Done"), In_checking("In checking");
    private String name;

    private Status(String name) {
        this.name = name;
    }

    Status() {
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
