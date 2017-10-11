

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name  = request.getParameter("name");
		String pass  = request.getParameter("password");
		
		System.out.println("name is " + name);
		System.out.println("password is " + pass);
		
		Connection conn = null;
		Statement st = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "banala");
			System.out.println("Connected to database");
			st = (Statement)conn.createStatement();
			String n1 = name;
			String n2 = pass;
			String insert = "INSERT INTO person VALUES('"+n1+"','"+n2+"')";
			st.executeUpdate(insert);
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}


	}

}
