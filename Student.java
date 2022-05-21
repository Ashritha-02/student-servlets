package student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
@WebServlet("/Student")
public class Student extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Sid=request.getParameter("Sid");
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "root", "ashritha");
			PreparedStatement ps = con.prepareStatement ("select * from student where Sid=?");
			            ps.setString (1, Sid);
			            out.print ("<table width=50% border=1>");
			            out.print ("<caption>Student Details:</caption>");
			            ResultSet rs = ps.executeQuery ();
			            
			            out.print ("</br></br>");
			            ResultSetMetaData rsmd = rs.getMetaData ();
			            int total = rsmd.getColumnCount ();
			            out.print ("<tr>");
			            for (int i = 1; i <= total; i++)
			         {
			             out.print ("<th>" + rsmd.getColumnName (i) + "</th>");
			         }
			            out.print ("</tr>");
			            /* Printing result */
			            while (rs.next ())
			         {
			             out.print ("<tr><td>" + rs.getString (1) + "</td><td>" +  rs.getString (2) + " </td><td>" + rs.getString (3) + " </td><td>" + rs.getString(4) + "</td></tr>");
			         }
			            out.print ("</table>");
			        }
			        catch (Exception e2)
			        {
			            e2.printStackTrace ();
			        }
			        finally
			        {
			            out.close ();
			        }
			    }
			}