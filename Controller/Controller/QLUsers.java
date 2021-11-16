package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Customerbean;
import Bean.Login;
import Bo.Customerbo;
import Bo.Loginbo;

/**
 * Servlet implementation class QLUsers
 */
@WebServlet("/qltaikhoan")
public class QLUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		Loginbo nvbo = new Loginbo();
    		ArrayList<Login> dsnv = nvbo.getlogin();
    		Customerbo khbo = new Customerbo();
    		ArrayList<Customerbean> dskh = khbo.getkh();
    		req.setAttribute("dsnv", dsnv);
    		req.setAttribute("dskh", dskh);
    		RequestDispatcher rd = req.getRequestDispatcher("Users.jsp");
    		rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	}
}
