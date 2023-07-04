package Model;
import com.todo.jsp_hibernate_mysql.DBConn;
import com.todo.jsp_hibernate_mysql.Tasks;
import jakarta.persistence.*;
import java.util.ArrayList;
import static com.todo.jsp_hibernate_mysql.DBConn.session;
import static com.todo.jsp_hibernate_mysql.DBConn.transaction;

/**
 * Class that contains CRUD methods for manipulating MySQL database
 */
public class Model {
        /**
         * method that removes an item from the ToDo list
         * @param item represents ID of the item to be removed
         */
        public static void removeItem(int item) {
            try {
                DBConn.connect();
                transaction.begin();
                Tasks task = session.find(Tasks.class, item);
                session.remove(task);
                transaction.commit();
            }
            finally {
                DBConn.endSession();
            }
        }
        /**
         * method that ads an item to the ToDo list
         * @param item represents an item to be added to the list
         */
        public void addItem(String item) {
            try{
                DBConn.connect();
                transaction.begin();
                Tasks task = new Tasks();
                task.setTaskName(item);
                session.persist(task);
                transaction.commit();
            }
            finally {
                    DBConn.endSession();
            }
        }
        /**
         * method that prints ToDo list
         */
        public ArrayList<Tasks> showItems() {
           ArrayList<Tasks> results;
            try {
                DBConn.connect();
                transaction.begin();
                Query query = session.createQuery("select T from Tasks T", Model.class);
                results = (ArrayList<Tasks>) query.getResultList();
                transaction.commit();
            }
            finally {
              DBConn.endSession();
            }
            return results;
        }
    }


