package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Customerbean;
import Bo.Customerbo;


@WebServlet("/new-user")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try (PrintWriter out = response.getWriter()){
			String makh = request.getParameter("makhcr");
			String matkhau = request.getParameter("matkhaucr");
			String rematkhau = request.getParameter("rematkhaucr");
			String hoten = request.getParameter("hotencr");
			String diachi = request.getParameter("diachicr");
			Customerbo kbo = new Customerbo();
			if(matkhau.equals(rematkhau)) {				
					Customerbean n = new Customerbean(0, makh, hoten, diachi, matkhau);
					kbo.createCustomer(n);
					request.getSession().setAttribute("authnew", n);		
					response.sendRedirect("login.jsp");	
			}
			else {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Đăng nhập thất bại.');");
				pw.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
}
