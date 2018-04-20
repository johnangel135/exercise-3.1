package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 4/20/2018.
 */
@Entity
@Table
public class Department {
    @Id @GeneratedValue
    private int id;
    private String name;

    @OneToMany
    List<Employee> employeeList = new ArrayList<>();

    public Department(){

    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
