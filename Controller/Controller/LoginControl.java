package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bookbean;
import Bean.Categorybean;
import Bean.Customerbean;
import Bean.Login;
import Bo.Bookbo;
import Bo.Categorybo;
import Bo.Customerbo;
import Bo.Loginbo;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/checklogin")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {    		
    		try {
    			resp.setContentType("text/html;charset=UTF-8");
        		req.setCharacterEncoding("utf-8");
        		resp.setCharacterEncoding("utf-8");
        		Bookbo sbo = new Bookbo();		
        		Categorybo lbo = new Categorybo();		
        		
        		ArrayList<Bookbean> dsbook = sbo.getsach();
        		ArrayList<Categorybean> dscate = lbo.getloai();
        				
        		
        		req.setAttribute("dsbook", dsbook);
        		req.setAttribute("dscate", dscate);
        		req.setAttribute("booknew", sbo.sachNew());
        		String tk = req.getParameter("username");
        		String mk = req.getParameter("password");
        		
        		Customerbo lgbo = new Customerbo();
        		Customerbean login = lgbo.checkLogin(tk, mk);
        		if(lgbo.checkExists(tk)&&lgbo.checkLogin(tk, mk)==null) {
        			req.setAttribute("mess", "Mật khẩu không đúng!");
        			req.setAttribute("tk", tk);
        			RequestDispatcher rd = req.getRequestDispatcher("login");
        			rd.forward(req, resp);    			
        		}
        		else if(lgbo.checkExists(tk)==false){
        			req.setAttribute("mess", "Tài khoản không tồn tại!");
        			RequestDispatcher rd = req.getRequestDispatcher("login");
        			rd.forward(req, resp);
        		}
        		else {
        			HttpSession session = req.getSession();
        			session.setAttribute("auth", login);
        			resp.sendRedirect("thanhtoan");
        		}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
}
