import model.Credentials;
import model.PizzaType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/")
public class PizzaMenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<PizzaType> pizzaArray = getPizzaFromDB();
        request.setAttribute("pizza", pizzaArray);
        getServletContext().getRequestDispatcher("/pizzaMenu.jsp").forward(request, response);
    }

    private ArrayList<PizzaType> getPizzaFromDB(){
        String query = "select * from pizza_cafe.pizza_types";

        ArrayList<PizzaType> pizzaArray = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(Credentials.url, Credentials.uName, Credentials.password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                PizzaType pizzaType = new PizzaType();

                pizzaType.setPosition(result.getInt("pizza_id"));
                pizzaType.setName(result.getString("pizza_type"));
                pizzaType.setPrice(result.getInt("price"));
                pizzaArray.add(pizzaType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pizzaArray;
    }

}