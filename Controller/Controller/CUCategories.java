package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Categorybean;
import Bo.Categorybo;

/**
 * Servlet implementation class CUCategories
 */
@WebServlet("/cucategories")
public class CUCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				resp.setContentType("text/html;charset=UTF-8");
	     	 	req.setCharacterEncoding("utf-8");
	     	 	resp.setCharacterEncoding("utf-8");  
	     	 	
				String ml = (String)req.getParameter("id");
				String tl = (String)req.getParameter("name");
				Categorybo cate = new Categorybo();
				Categorybean cateedit = new Categorybean(ml, tl);
				if(ml!=null && ml!="") {	
					cate.updateCate(cateedit);		
					HttpSession session = req.getSession();
					session.setAttribute("alert1", "Sửa loại thành công!");
					resp.sendRedirect("qlloaisach");
				}
				else {	
					String[] tokens = tl.split("\\s");
					String maloai = "";

					for(int i = 0; i < tokens.length; i++){
					    char capLetter = Character.toLowerCase(tokens[i].charAt(0));
					    maloai += capLetter;
					}
					maloai = maloai.trim();
					Categorybean catenew = new Categorybean(maloai, tl.trim());
					ArrayList<Categorybean> dsCate = cate.getloai();
					boolean co = true;
					for(Categorybean c:dsCate) {
						if(c.getMaloai().equals(maloai))
							co=false;
					}		
					if(co==true) {
						cate.createCate(catenew);
						HttpSession session = req.getSession();
						session.setAttribute("alert2", "Thêm loại thành công!");
						resp.sendRedirect("qlloaisach");	
					}
					else {						
						HttpSession session = req.getSession();
						session.setAttribute("error", "Tên loại đã tồn tại!");
						resp.sendRedirect("qlloaisach");
					}
						
					
			   }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
