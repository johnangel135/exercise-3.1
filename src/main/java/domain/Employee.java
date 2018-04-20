package domain;

import javax.persistence.*;

/**
 * Created by Duong Truong on 4/20/2018.
 */
@Entity
@Table
public class Employee {
    @Id @GeneratedValue
    private int employeenumber;
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public Employee(){

    }

    public Employee(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(int employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
