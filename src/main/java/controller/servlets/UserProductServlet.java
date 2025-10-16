package controller.servlets;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> b78248c (created a page for individual product)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

/**
 * Servlet implementation class UserProductServlet
 */
@WebServlet("/UserProductServlet")
public class UserProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

=======
import controller.DatabaseController;
import model.ProductsModel;
import model.UsersModel;
import util.ProductStringUtils;


@WebServlet(asyncSupported = true, urlPatterns = ProductStringUtils.USER_PRODUCT_SERVLET)
public class UserProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DatabaseController dbController = new DatabaseController();

    public UserProductServlet() {
        super();
    }

    
    
    

    
    
    
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        // Retrieve email from the session
        String email = (String) request.getSession().getAttribute("Adminemail");
        if (email == null || email.isEmpty()) {
            // If "Adminemail" is not found in the session, try "email"
            email = (String) request.getSession().getAttribute("email");
            System.out.println(email);
        }

        
            // Fetch users from the database based on the email
            List<UsersModel> users = dbController.getAllUsers1(email);

            // Set the users as an attribute in the request object
            request.setAttribute("loggedInUser", users);

            // Forward the request to the singleRegisterUser.jsp page
           

           
        
            // If neither "Adminemail" nor "email" is found in the session, redirect to login page

        // Fetch all student details from the database
        List<ProductsModel> products = dbController.getAllProducts();

        // Set the list of students as an attribute in the request object
        request.setAttribute("products1", products);

        // Forward the request to the students.jsp page
        request.getRequestDispatcher("pages/newProduct.jsp").forward(request, response);
    }
>>>>>>> b78248c (created a page for individual product)
}
