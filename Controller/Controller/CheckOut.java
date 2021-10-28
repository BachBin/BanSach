package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Login;
import Bo.GioHangbo;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/thanhtoan")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		HttpSession session = req.getSession();
    		Login auth = (Login)session.getAttribute("auth");
    		if(auth==null) {
    			resp.sendRedirect("login");
    		}
    	}

}
