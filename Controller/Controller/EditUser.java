package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import Bean.Customerbean;
import Bo.Customerbo;


@WebServlet("/edit-user")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try (PrintWriter out = response.getWriter()){
			
			Customerbean usercu = (Customerbean)request.getSession().getAttribute("auth");			
			try {
					String id = request.getParameter("makh");
					String mk = request.getParameter("matkhau");
					String dc = request.getParameter("diachi");
					String ht = request.getParameter("hoten");							
					Customerbo kbo = new Customerbo();
					Customerbean n = new Customerbean(usercu.getId(), id, ht, dc, mk);
					if(kbo.updateCustomer(n)) {			
						kbo.updateCustomer(n);
						request.getSession().setAttribute("auth",n);
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Cập nhật tài khoản thành công.');");	
						out.println("location='index.jsp';");
						out.println("</script>");
						response.sendRedirect("index.jsp");
					}
					else {
						response.sendRedirect("error.jsp");
					}	
					
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}

}
