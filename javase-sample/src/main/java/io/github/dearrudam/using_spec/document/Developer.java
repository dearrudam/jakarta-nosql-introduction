package io.github.dearrudam.using_spec.document;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Developer {

    static Developer newDeveloper(String name, LocalDate birthday) {
        return new Developer(
                UUID.randomUUID().toString(),
                name,
                birthday);
    }

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private LocalDate birthday;

    /**
     * used by framework
     */
    @Deprecated
    public Developer() {
    }

    public Developer(String id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
