package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customerbean;
import Bo.Customerbo;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/checklogin")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		resp.setContentType("text/html;charset=UTF-8");
    		req.setCharacterEncoding("utf-8");
    		resp.setCharacterEncoding("utf-8");
    		String tk = req.getParameter("username");
    		String mk = req.getParameter("password");
    		Customerbo kbo = new Customerbo();
    		Customerbean login = kbo.checkLogin(tk, mk);
    		if(kbo.checkExists(tk)&&kbo.checkLogin(tk, mk)==null) {
    			req.setAttribute("mess", "Mật khẩu không đúng!");
    			req.setAttribute("tk", tk);
    			req.getRequestDispatcher("login").forward(req, resp);
    		}
    		else if(kbo.checkExists(tk)==false){
    			req.setAttribute("mess", "Tài khoản không tồn tại!");
    			req.getRequestDispatcher("login").forward(req, resp);
    		}
    		else {
    			HttpSession session = req.getSession();
    			session.setAttribute("auth", login);
    			resp.sendRedirect("home");
    		}
    	}
}
