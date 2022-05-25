package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductRepository;
import dto.Product;


@WebServlet("/webmarket/*")
public class WebMarket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductRepository dao = new ProductRepository();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String servletContext = request.getServletPath();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(servletContext.length()+contextPath.length());
	
		String viewPage = "";
		RequestDispatcher rd = null;
		
		if (cmdURI.equals("/home")) {
			viewPage = "/WEB-INF/views/webmarket/welcome.jsp";
			
		}else if (cmdURI.equals("/findAll")) {
			viewPage = "/WEB-INF/views/webmarket/products.jsp";
			List<Product> productList = dao.findAll();
			
			request.setAttribute("products", productList);

		} else if (cmdURI.equals("/findById")) {
			viewPage = "/WEB-INF/views/webmarket/product.jsp";
			String id= request.getParameter("id");
			Product product = dao.findById(id);
			request.setAttribute("product", product);
			
		}else if (cmdURI.equals("/add")) {
			viewPage = "/WEB-INF/views/webmarket/addproduct.jsp";
		}else if (cmdURI.equals("/login")) {
			viewPage = "/WEB-INF/views/webmarket/login.jsp";
		}
		else {
			System.out.println("페이지가 없습니다");
			return;

		}
		rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String cmdURI = requestURI.substring(contextPath.length()+servletPath.length());
		
		
		if (cmdURI.equals("/add")) {
			String realFolder = "C:\\upload";
			int maxSize = 5*1024*1024;
			String encType = "utf-8";
			
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize , encType, new DefaultFileRenamePolicy());
			String productId = multi.getParameter("productId");
			String pname = multi.getParameter("pname");
			String price = multi.getParameter("unitprice");
			int unitprice = Integer.parseInt(price);
			String description = multi.getParameter("description");
			String category = multi.getParameter("category");
			String manufacturer = multi.getParameter("manufacturer");
			String unitsInStock = multi.getParameter("unitsInStock");
			long stock = Long.valueOf(unitsInStock);
			String condition = multi.getParameter("condition");
			
			Enumeration<String> files = multi.getFileNames();
			String fname = files.nextElement();
			String filename = multi.getFilesystemName("filename");
			
			Product product = new Product(productId, pname, unitprice, description, category, manufacturer, stock, condition, filename);
			
			dao.insert(product);
			response.sendRedirect("findAll");
		}else if (cmdURI.equals("/login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			System.out.println(id);
			System.out.println(pw);
		}
		else {
			System.out.println("잘못된 요청입니다");
		}
	}

}
