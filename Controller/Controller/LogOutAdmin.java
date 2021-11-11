package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutAdmin
 */
@WebServlet("/logoutadmin")
public class LogOutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			if(session.getAttribute("authadmin") != null) {
				session.removeAttribute("authadmin");
				resp.sendRedirect("home");
			}
			else {
				resp.sendRedirect("home");
			}			
		}
}
