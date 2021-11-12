package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.Bookbean;
import Bo.Bookbo;


/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/addbooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	resp.setContentType("text/html;charset=UTF-8");
	 	 	req.setCharacterEncoding("utf-8");
	 	 	resp.setCharacterEncoding("utf-8");  
    		DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			upload.setHeaderEncoding("UTF-8");
			String dirUrl1 = req.getServletContext().getRealPath("") + "image_sach";
			String id = "";
			String name="", sl="", gia="", tacgia="", loai="", sotap="", ngaynhap="",anh="";
			try {
				List<FileItem> fileItems = upload.parseRequest(req);// Lấy về các đối tượng gửi lên
				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = req.getServletContext().getRealPath("") + "image_sach";
							File dir = new File(dirUrl);
							if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								fileItem.write(file);// lưu file								
								anh = "image_sach/"+nameimg;								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else// Neu la control
					{
						String tentk = fileItem.getFieldName();
						if (tentk.equals("id")) {
							id = fileItem.getString();							
						}	
						if (tentk.equals("name")) {
							name = fileItem.getString("UTF-8");							
						}							
						if (tentk.equals("sl")) {
							sl = fileItem.getString("UTF-8");							
						}							
						if (tentk.equals("gia")) {
							gia = fileItem.getString("UTF-8");							
						}
							
						if (tentk.equals("tacgia")) {
							tacgia = fileItem.getString("UTF-8");							
						}
							
						if (tentk.equals("loai")) {
							loai = fileItem.getString("UTF-8");							
						}	
						if (tentk.equals("sotap")) {
							sotap = fileItem.getString("UTF-8");							
						}
						if (tentk.equals("ngaynhap")) {
							ngaynhap = fileItem.getString("UTF-8");							
						}
					}
				}
				if(id!=null && !id.equals("")) {
					if(name!=null && !name.equals("")&&
							sl!=null  && !sl.equals("")&&
							gia!=null && !gia.equals("") &&
							tacgia!=null && !tacgia.equals("") &&
							loai!=null && !loai.equals("") &&
							sotap!=null && !sotap.equals("") &&
							ngaynhap!=null && !ngaynhap.equals("") &&
							anh!=null  && !anh.equals("")
						)
						{							
							try {
								DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
							    DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
								
							    Date date = (Date)formatter.parse(ngaynhap);
							    String dateout = outputformat.format(date);
							    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
							    Date parsedDate = dateFormat.parse(dateout);
							    Timestamp tsNgayNhap = new java.sql.Timestamp(parsedDate.getTime());	
							    Bookbo sb = new Bookbo();	
								Bookbean bookupdate = new Bookbean(Long.valueOf(id), name, Long.parseLong(sl), Long.parseLong(gia), loai, Long.parseLong(sotap), anh, tsNgayNhap, tacgia);
								if(sb.updateBook(bookupdate)) {
									resp.sendRedirect("qlsach");
								}
							} catch (Exception e) {
								e.printStackTrace();
							}							
						}
						else {
							resp.sendRedirect("CUBooks.jsp");
						}
				}
				else {
					if(name!=null && !name.equals("")&&
							sl!=null  && !sl.equals("")&&
							gia!=null && !gia.equals("") &&
							tacgia!=null && !tacgia.equals("") &&
							loai!=null && !loai.equals("") &&
							sotap!=null && !sotap.equals("") &&
							ngaynhap!=null && !ngaynhap.equals("") &&
							anh!=null  && !anh.equals("")
						)
						{
							try {
								DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
							    DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
								
							    Date date = (Date)formatter.parse(ngaynhap);
							    String dateout = outputformat.format(date);
							    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
							    Date parsedDate = dateFormat.parse(dateout);
							    Timestamp tsNgayNhap = new java.sql.Timestamp(parsedDate.getTime());
							    
							    Bookbo sb = new Bookbo();	
								Bookbean bookadd = new Bookbean((long)-1, name, Long.parseLong(sl), Long.parseLong(gia), loai, Long.parseLong(sotap), anh, tsNgayNhap, tacgia);
								if(sb.createBook(bookadd)) {
									resp.sendRedirect("qlsach");
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						
						}
						else {
							resp.sendRedirect("CUBooks.jsp");
						}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

    	}
}
