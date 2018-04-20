package Controller;

import domain.Department;
import domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 4/20/2018.
 */
public class MainApp {
    private static Session session;
    private static Transaction tx;
    private static  final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    private static void initial(){
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    public static void main(String[] args) {
        initial();
        run();
        System.out.println("Finish");
    }

    private static void run(){
        try {
            Department department = new Department("D1");
            Employee employee = new Employee("John");
            Employee employee1 = new Employee("Marry");

            session.save(employee);
            session.save(employee1);

            System.out.println("save employee");

            List<Employee> employees = new ArrayList<>();
            employee.setDepartment(department);
            employee1.setDepartment(department);
            employees.add(employee);
            employees.add(employee1);
//            session.save(department);
//            session.flush();

            System.out.println("Save department");
            department.setEmployeeList(employees);

            session.save(department);

            session.saveOrUpdate(employee);
            session.saveOrUpdate(employee1);
            tx.commit();
            System.out.println("TX commit");

        }
        catch (HibernateException e){
            System.out.println(e);
            tx.rollback();
        }
        finally {
            if (session != null) session.close();
            sessionFactory.close();
            System.out.println("Session close");
        }
    }

}
