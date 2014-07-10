package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JPAObject;
import model.ejb.*;

/**
 * Servlet implementation class JPAObjectServlet
 */
@WebServlet(name="JPAObjectServlet", urlPatterns="/jpaobjectservlet")
public class JPAObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB JPAObjectEJB jpaObjectejb;
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
		
		String searchString = "";
		if (request.getParameter("searchString")!=null)
			searchString = request.getParameter("searchString");
		
		request.setAttribute("jpaobject", jpaObjectejb.getAllList(searchString));
		request.getRequestDispatcher("/jpaobject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("AddButton")!=null){
		String name = request.getParameter("name");
		if (name != null){
			jpaObjectejb.persist(new JPAObject(name));
			
			}
		}
		else if (request.getParameter("DeleteButton")!=null){
			String objectIdToDeleteString = request.getParameter("jpaObjectToDelete");
			 //System.out.println("<html><body onload=\"alert('" + objectIdToDelete +"')\"></body></html>");

			Long objectIdToDelete = Long.parseLong(objectIdToDeleteString);
			jpaObjectejb.delete(objectIdToDelete);
		}

		doGet(request, response);
	}

}
