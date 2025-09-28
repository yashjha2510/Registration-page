import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yash.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String uemail = req.getParameter("user_email");
		String upass = req.getParameter("user_pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashjhaclgdb","root","Betu8959@");
			
			PreparedStatement ps = con.prepareStatement("select * from register where email = ? and pass = ?");
			ps.setString(1, uemail);
			ps.setString(2, upass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("successfully login");
				
				User user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));				
				user.setGender(rs.getString("gender"));				
				user.setCity(rs.getString("city"));				
				
				HttpSession session = req.getSession();
				session.setAttribute("session_user", user);
				
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				
				out.println("<h3> Email id and Password didn't match </h3>");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
			
			out.println("<h3> Exception occured : " + e.getMessage() + "</h3>");
		}
	}
}
