package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;

import Bean.Customerbean;
import Bean.Login;
import Bo.Customerbo;
import Bo.Loginbo;


@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");		
			HttpSession session = req.getSession();
			Customerbean user = (Customerbean)session.getAttribute("auth");		
			String id = req.getParameter("makh");
			String mk = req.getParameter("matkhau");		
			
			if(user.getTendn().equals(id) && user.getMatkhau().equals(mk)) {
				resp.sendRedirect("home");	
			}
			else {
				Customerbo kbo = new Customerbo();
				long ID = user.getId();
				String hoten = user.getHoten();
				String diachi = user.getDiachi();
				String sdt = user.getSdt();
				String email = user.getEmail();
				String tendn = user.getTendn();
				String matkhau = mk;
				Customerbean usernew = new Customerbean(ID, hoten, diachi, sdt, email, tendn, matkhau);
				if(kbo.updateCustomer(usernew)) {
					session.setAttribute("auth", usernew);
					session.setAttribute("alert", "Cập nhật tài khoản thành công!");
					resp.sendRedirect("home");					
				}			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 			
	}
}
