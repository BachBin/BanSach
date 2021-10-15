package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Order;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/thanhtoan")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = (Order)request.getSession().getAttribute("order");
		if(order!=null) {
			request.getSession().setAttribute("order","");
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("GioHang.jsp");
		dispatcher.forward(request, response);
	}

	

}
