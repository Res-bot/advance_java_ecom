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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
import model.ProductsModel;
import controller.DatabaseController;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        List<ProductsModel> products = null;
        
        try {
            DatabaseController dbController = new DatabaseController();
            products = dbController.searchProducts(query);
            request.setAttribute("searchResults", products); // Set search results as request attribute
            request.getRequestDispatcher("pages/search.jsp").forward(request, response); // Forward to search.jsp
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
>>>>>>> b78248c (created a page for individual product)
}
