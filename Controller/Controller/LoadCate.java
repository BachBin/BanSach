package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bookbean;
import Bo.Bookbo;

/**
 * Servlet implementation class LoadCate
 */
@WebServlet("/categories")
public class LoadCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		resp.setContentType("text/html;charset=UTF-8");
    		String ml = req.getParameter("maloai");
    		Bookbo sbo = new Bookbo();
    		ArrayList<Bookbean> listbook = sbo.TimLoai(ml);
    		PrintWriter out = resp.getWriter();
    		for(Bookbean b:listbook) {
    			out.println("<div class=\"col-12 col-md-6 col-lg-4\">\r\n"
    					+ "						<div class=\"card\">\r\n"
    					+ "						<a href=\"detail?bookid="+b.getMasach()+"\"	title=\"View Product\">\r\n"
    					+ "							<img class=\"card-img-top\" style=\"height: 200px\" src=\""+b.getAnh()+"\" alt=\"Chưa có ảnh\">\r\n"
    					+ "							<div class=\"card-body\">\r\n"
    					+ "								<h4 class=\"card-title show_txt\">\r\n"
    					+ "									"+b.getTensach()+"\r\n"
    					+ "								</h4>\r\n"
    					+ "								<p class=\"card-text show_txt\"><i class=\"fas fa-at\"></i> Tác giả: "+b.getTacgia()+"</p>\r\n"
    					+ "								<div class=\"row\">\r\n"
    					+ "									<div class=\"col\" style=\"cursor: default;\">\r\n"
    					+ "										<p disabled class=\"btn btn-outline-secondary btn-block\"\r\n"
    					+ "											style=\"cursor: default;\">Số lượng: "+b.getSoluong()+"</p>\r\n"
    					+ "									</div>\r\n"
    					+ "									<div class=\"col\">\r\n"
    					+ "										<p disabled class=\"btn btn-outline-dark btn-block\" style=\"cursor: default;\">\r\n"
    					+ "											"+NumberFormat.getNumberInstance(Locale.US).format(b.getGia())+" VNĐ</p>\r\n"
    					+ "									</div>\r\n"
    					+ "									<div class=\"col\">\r\n"
    					+ "										<a href=\"javascript:return false;\" onclick=\"addAjax("+b.getMasach()+")\"\r\n"
    					+ "											class=\"btn btn-success btn-block\"><i class=\"fas fa-cart-plus\"></i> Thêm\r\n"
    					+ "											giỏ</a>\r\n"
    					+ "									</div>\r\n"
    					+ "								</div>\r\n"
    					+ "							</div>\r\n"
    					+ "							</a>\r\n"
    					+ "						</div>\r\n"
    					+ "					</div>");
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    }
}
