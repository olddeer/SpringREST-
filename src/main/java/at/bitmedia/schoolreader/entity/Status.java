package at.bitmedia.schoolreader.entity;

import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum Status {
    In_progress("In progress"),Done("Done"),In_checking("In checking");
    private String name;
    private Status(String name){
        this.name=name;
    }
    public  String toString(){
        return this.name;
    }

    Status() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
