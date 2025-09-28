import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.CountDownLatch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet  {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// backend code
		PrintWriter out = resp.getWriter();
		
		String uname = req.getParameter("user_name");
		String uemail = req.getParameter("user_email");
		String upass = req.getParameter("user_pass");
		String ugender = req.getParameter("user_gender");
		String ucity = req.getParameter("user_city");
		
		//jdbc connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashjhaclgdb", "root", "Betu8959@");
			
			PreparedStatement ps = con.prepareStatement("insert into register values (?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, upass);
			ps.setString(4, ugender);
			ps.setString(5, ucity);
			
			int count = ps.executeUpdate();
			
			if (count> 0) {
				System.out.println(count + " row affected");
				
				
				resp.setContentType("text/html");
				out.println("<h3> successfully registered!! Now you can login </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				
			}
			else {
				System.out.println("can not insert");
				System.out.println(count + " row affected");
				
				resp.setContentType("text/html");
				out.println("<h3> not registered </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			
			resp.setContentType("text/html");
			out.println("<h3> Exceptin occured : " + e.getMessage() + "</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
