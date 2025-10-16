<<<<<<< HEAD
=======
// SignupServlet Class
>>>>>>> b78248c (created a page for individual product)
package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

<<<<<<< HEAD
=======
import util.ProductStringUtils;
import util.StringUtils;
>>>>>>> b78248c (created a page for individual product)
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import controller.DatabaseController;
import model.CartModel;
import util.StringUtils;
=======
import javax.servlet.http.Part;

import controller.DatabaseController;
import model.CartModel;
import model.UsersModel;


>>>>>>> b78248c (created a page for individual product)

@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.CART_SERVLET})

@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)

public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();
    public CartServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
    	 String userid=dbController.getUserIdByEmail(email);
    	 System.out.println("users ko :"+userid);
               List<CartModel> cart = dbController.displayCart(userid);
               System.out.println(cart);
               request.setAttribute("UserCart", cart);
               request.getRequestDispatcher("pages/cart.jsp").forward(request, response); 
           } 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printOut = response.getWriter();
        
        int quantity = Integer.parseInt(request.getParameter(StringUtils.QUANTITY));
        String productId = request.getParameter(StringUtils.PROD_ID);
        String email = (String) request.getSession().getAttribute("email");
        String userId=dbController.getUserIdByEmail(email);
            CartModel cartModel = new CartModel(quantity,productId,userId);
            dbController.addCart(cartModel);
            response.sendRedirect(request.getContextPath() + "/pages/home.jsp");
    }    
}