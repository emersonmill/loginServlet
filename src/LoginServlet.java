

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		String name=request.getParameter("nome");
		String password=request.getParameter("senha");
		
		if(password.equals("admin123")){
		out.print("Bem-vindo, "+name);
		HttpSession session=request.getSession();
		session.setAttribute("nome",name);
		}
		else{
			out.print("Usuário ou senha inválido!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
