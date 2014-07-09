package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.msv.writer.relaxng.Context;

import model.JPAObject;
import model.JPAObjectDAOImpl;

/**
 * Servlet implementation class JPAObjectServlet
 */
@WebServlet(name="JPAObjectServlet", urlPatterns="/jpaobjectservlet")
public class JPAObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB JPAObjectDAOImpl jpaObjectDAOImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAObjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String searchString = request.getParameter("searchString");
		
		request.setAttribute("jpaobject", jpaObjectDAOImpl.getAllList());
		request.getRequestDispatcher("/jpaobject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		if (name != null){
			jpaObjectDAOImpl.persist(new JPAObject(name));
			
			}
		
		doGet(request, response);
	}

}
