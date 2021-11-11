package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Categorybean;
import Bo.Categorybo;

/**
 * Servlet implementation class SearchCate
 */
@WebServlet("/searchcate")
public class SearchCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				resp.setContentType("text/html;charset=UTF-8");
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				String search = req.getParameter("search");
				Categorybo cate = new Categorybo();
				ArrayList<Categorybean> dscate = cate.Tim(search);
				req.setAttribute("dscate", dscate);
				RequestDispatcher rd = req.getRequestDispatcher("Categories.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
