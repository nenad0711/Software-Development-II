package com.todo.jsp_hibernate_mysql;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Class that opens and closes connection with MySQL DB
 */
public class DBConn {
   public static EntityManagerFactory entityManagerFactory;
   public static EntityManager session;
   public static EntityTransaction transaction;
    public static void connect(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        session = entityManagerFactory.createEntityManager();
        transaction = session.getTransaction();
    }
    public static void endSession(){
        if (transaction.isActive()) {
            transaction.rollback();
        }
        session.close();
        entityManagerFactory.close();
    }
}
