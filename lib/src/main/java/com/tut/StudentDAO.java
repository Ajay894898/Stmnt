package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDAO {
    private static SessionFactory factory;

    public StudentDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void addStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Student> listStudents() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Student> students = null;
        try {
            tx = session.beginTransaction();
            students = session.createQuery("FROM Student").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    public void updateStudent(Long id, String name, String email, String course, int year) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            if (student != null) {
                student.setName(name);
                student.setEmail(email);
                student.setCourse(course);
                student.setYear(year);
                session.update(student);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteStudent(Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
