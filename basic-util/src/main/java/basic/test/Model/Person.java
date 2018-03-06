package basic.test.Model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Serializable {
    private static final long serialVersionUID = -2574823328131067567L;

    private Integer id = new Random().nextInt((int) 100);
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private List<WorkPlace> workPlaces = new ArrayList<>();
//    private LocalDateTime localDateTime = LocalDateTime.now();


    public final String getAgeName(){
        return age + firstName;
    }

    public String getAgeName(int i){
        return age + firstName + i;
    }


    public Person() {
    }

    public Person(Integer id, String firstName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    public Person(Integer id, String firstName, Integer age, List<WorkPlace> workPlaces) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.workPlaces = workPlaces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<WorkPlace> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(List<WorkPlace> workPlaces) {
        this.workPlaces = workPlaces;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //    public Date getLocalDateTime() {
//        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
////        Date date = new Date();
////        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
//        return Date.from(instant);
//    }
//
//    public void setLocalDateTime(Date date) {
//        this.localDateTime = LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
//    }



}
