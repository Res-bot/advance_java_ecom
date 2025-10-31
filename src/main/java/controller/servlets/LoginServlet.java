package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.UsersModel;
import util.StringUtils;

@WebServlet(asyncSupported=true, urlPatterns = StringUtils.LOGIN_SERVLET)
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DatabaseController dbController = new DatabaseController();
   
    public LoginServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter(StringUtils.EMAIL);
        String password = request.getParameter(StringUtils.PASSWORD);
        String isAdmin = request.getParameter(StringUtils.IS_ADMIN);
        
        // Debug logging
        System.out.println("=== Login Attempt ===");
        System.out.println("Email: " + email);
        System.out.println("Password provided: " + (password != null ? "Yes" : "No"));
        System.out.println("isAdmin parameter: " + isAdmin);
        System.out.println("===================");
        
        int loginResult = dbController.getLogin(email, password, isAdmin);
        
        System.out.println("Login result code: " + loginResult);
        
        if(loginResult == 1) { // Regular user login
            System.out.println("Processing as REGULAR USER");
            HttpSession userSession = request.getSession();
            userSession.setAttribute("email", email);
            userSession.setMaxInactiveInterval(30*60);
            
            Cookie userCookie = new Cookie("email", email);
            userCookie.setMaxAge(30*60);
            response.addCookie(userCookie);
            
            UsersModel user = null;
            try {
                user = dbController.getUserDetails(email);
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            if (user != null) {
                System.out.println("User details retrieved successfully - Redirecting to USER HOME");
                request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
                request.getRequestDispatcher(StringUtils.HOME_PAGE).forward(request, response);
            } else {
                System.out.println("ERROR: User details not found");
                request.setAttribute(StringUtils.ERROR_MESSAGE, "User details not found");
                request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
            }
        }
        else if(loginResult == 2) { // Admin login
            System.out.println("Processing as ADMIN USER");
            HttpSession userSession = request.getSession();
            userSession.setAttribute("Adminemail", email);
            userSession.setMaxInactiveInterval(30*60);
            
            Cookie userCookie = new Cookie("adminemail", email);
            userCookie.setMaxAge(30*60);
            response.addCookie(userCookie);
            
            UsersModel user = null;
            try {
                user = dbController.getUserDetails(email);
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            if (user != null) {
                System.out.println("Admin details retrieved successfully - Redirecting to ADMIN PAGE");
                request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
                request.getRequestDispatcher(StringUtils.ADMIN_PAGE).forward(request, response);
            } else {
                System.out.println("ERROR: Admin details not found");
                request.setAttribute(StringUtils.ERROR_MESSAGE, "User details not found");
                request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
            }
        }
        else if (loginResult == 0) {
            System.out.println("Login FAILED - Invalid credentials");
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_LOGIN_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        } else {
            System.out.println("Login ERROR - Server issue (result: " + loginResult + ")");
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
    }
}