package Controller;
import java.io.*;
import java.util.ArrayList;
import Model.Model;
import com.todo.jsp_hibernate_mysql.Tasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
/**
 * Servlet class that controls the flow of information between the View and the Model
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class Controller extends HttpServlet {
    Model toDo = new Model();
    private ArrayList<Tasks> x;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String form = request.getParameter("task");
// get the input name parameter and display or add an item based on the value of the input tag
        switch(form){
            case "Display Items" :
                x = toDo.showItems();
                request.setAttribute("x",x);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "Add":
                toDo.addItem(request.getParameter("taskName"));
                x = toDo.showItems();
                request.setAttribute("x",x);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                break;
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// receive get variable delId and remove the item with that ID value
        int delId = Integer.parseInt(req.getParameter("delId"));
        Model.removeItem(delId);
        x = toDo.showItems();
        req.setAttribute("x",x);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    public void destroy() {
    }
}