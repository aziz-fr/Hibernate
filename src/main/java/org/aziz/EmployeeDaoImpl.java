package org.aziz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
  private SessionFactory sessionFactory;

  public EmployeeDaoImpl() {
    
  }

  @Override
  public void addEmployee(Employee employee) throws SQLException {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.save(employee);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void updateEmployee(Employee employee) throws SQLException {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.update(employee);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void deleteEmployee(int id) throws SQLException {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.delete(getEmployeeById(id));
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      System.out.println(e.getMessage());
    }
  }

  @Override
  public List<Employee> getEmployee() throws SQLException {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("FROM Employee", Employee.class).list();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public Employee getEmployeeById(int id) throws SQLException {
    try (Session session = sessionFactory.openSession()) {
      return session.get(Employee.class, id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
