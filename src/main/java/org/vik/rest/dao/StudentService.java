package org.vik.rest.dao;

import org.vik.rest.config.HibernateConfig;
import org.vik.rest.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class StudentService {


    private HibernateConfig hibernateConfig;

    public StudentService()
    {

    }

    public void defaultStudent()
    {
        createStudent(1,"Vikram Modugu", 34);
    }

    public void addStudent(Student student)
    {
        createStudent(student.getId(), student.getName(), student.getAge());
    }
    public void createStudent(int id, String name, int age) {
        // Create an EntityManager
        EntityManager manager = hibernateConfig.getAppEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Student stu = new Student();
            stu.setId(id);
            stu.setName(name);
            stu.setAge(age);

            // Save the student object
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    public Student getStudent(int id)
    {
        Student student = null;

        // Create an EntityManager
        EntityManager manager = hibernateConfig.getAppEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            student = manager.createQuery("SELECT s FROM Student s where s.id = :id",
                    Student.class).setParameter("id",id).getSingleResult();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return student;
    }

    public List getAllStudents() {

        List students = null;

        // Create an EntityManager
        EntityManager manager = hibernateConfig.getAppEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            students = manager.createQuery("SELECT s FROM Student s",
                    Student.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    }

    public void deleteStudent(int id) {
        // Create an EntityManager
        EntityManager manager = hibernateConfig.getAppEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Student stu = manager.find(Student.class, id);

            // Delete the student
            manager.remove(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    public void upateStudent(int id, String name, int age) {
        // Create an EntityManager
        EntityManager manager = hibernateConfig.getAppEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Student stu = manager.find(Student.class, id);

            // Change the values
            stu.setName(name);
            stu.setAge(age);

            // Update the student
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
}
