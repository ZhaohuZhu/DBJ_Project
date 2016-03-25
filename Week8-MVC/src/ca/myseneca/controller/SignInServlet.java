package ca.myseneca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import ca.myseneca.model.User;
import ca.myseneca.model.UserDB;

@WebServlet("/SIS")
public class SignInServlet extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
     	// get request parameters for email and password
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");

        // store data in User object
        User user = new User();
        user.setEmail(email);
        user.setPassword(pwd);

        // check the email and password from database
        boolean pass = UserDB.CkeckUser(user);

        if (pass) {
        	// set User object in request object and and forward to LoginSuccess.jsp page
            request.setAttribute("user", user);
        
            getServletContext().getRequestDispatcher("/LoginSuccess.jsp")
            .forward(request, response);
            //response.sendRedirect("LoginSuccess.jsp");
        } else {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            out.println("<p style=\"color:red;\">Either email or password is wrong. "
            		+ "Please try again.</p>");
            rd.include(request, response);
            //rd.forward(request, response);
        }
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException {
        doPost(request, response);
    } 
}
