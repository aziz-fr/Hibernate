package org.aziz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Assignment
 */
public class App 
{
    public static void main( String[] args )
    {
        // create a config obj
        Configuration config = new Configuration();

        // read the config obj
        config.configure("hibernate.cfg.xml");

        // create session factory
        SessionFactory sessionFactory = config.buildSessionFactory();

        // open the start
        Session session = sessionFactory.openSession();

        // begin transaction
        Transaction transaction = session.beginTransaction();

//         add employee
//         create employee obj
//        Employee emp = new Employee();
//        emp.setId(1);
//        emp.setName("John");
//        emp.setEmail("J@mail.com");
//
//        // save the obj
//        session.save(emp);
//
//        // commit
//        transaction.commit();


        // retrieve the data
        /**
         * get() - return null if obj doesn't exist
         * affect performance of the application
         *
         * load() - throws objnotfoundexc if obj doesn't exist
         * better performance
         *
         * updates table
         * <property name="hbm2ddl.auto">update</property>
         * drops if table exist and creates again
         * <property name="hbm2ddl.auto">create</property>
         *  **/

        Employee emp1 = (Employee) session.get(Employee.class, 1L);

        System.out.println(emp1.toString());
        transaction.commit();


        // delete data

//        int empId = 1;
//        Employee emp2 = session.get(Employee.class, empId);
//
//        session.delete(emp2);
//        transaction.commit();



        // close the connection
        session.close();
    }
}
