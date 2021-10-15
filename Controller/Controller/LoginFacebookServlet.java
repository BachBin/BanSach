package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.types.User;

import Bean.RestFB;





@WebServlet("/login-facebook")
public class LoginFacebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFacebookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		} else {
			String accessToken = RestFB.getToken(code);
			
			User user = RestFB.getUserInfo(accessToken);
			request.setAttribute("idfb", user.getId());
			request.setAttribute("namefb", user.getName());
			RequestDispatcher dis = request.getRequestDispatcher("registerfb.jsp");
			dis.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
