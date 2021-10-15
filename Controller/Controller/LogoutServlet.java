package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			if(session.getAttribute("auth") != null) {
				session.removeAttribute("auth");
				resp.sendRedirect("home");
			}
			else {
				resp.sendRedirect("home");
			}
		}
}
