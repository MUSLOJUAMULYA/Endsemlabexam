package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Insert Operation
            Department dept = new Department();
            dept.setName("CSE");
            dept.setLocation("VIJAYAWADA");
            dept.setHodName("J SURYA KIRAN");
            session.save(dept);

             //Delete Operation using HQL with positional parameter
            
//            String hql = "DELETE FROM Department WHERE deptId = :deptId";
//            int deletedCount = session.createQuery(hql).setParameter("deptId", 1).executeUpdate();
//            System.out.println("Number of departments deleted: " + deletedCount);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
