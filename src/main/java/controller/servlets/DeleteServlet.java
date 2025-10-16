package controller.servlets;

<<<<<<< HEAD
import java.io.IOException;
import javax.servlet.ServletException;
=======

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
>>>>>>> b78248c (created a page for individual product)
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

=======
import javax.servlet.http.Part;
import controller.DatabaseController;
import model.ProductsModel;
import model.UsersModel;
import util.StringUtils;
>>>>>>> b78248c (created a page for individual product)
/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
    DatabaseController dbController = new DatabaseController();
   
	 protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("Delete Triggered");
	        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
	        if(dbController.deleteProduct(deleteId) == 1 ) {
	            System.out.print("successful");
	            request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_DELETE_MESSAGE);
	            response.sendRedirect(request.getContextPath() + StringUtils.PRODUCTS_SERVLET);
	        }
	        else {
	            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_DELETE_MESSAGE);
	            response.sendRedirect(request.getContextPath() + StringUtils.PRODUCTS_SERVLET);
	        }
	    }
>>>>>>> b78248c (created a page for individual product)

}
