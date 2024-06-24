package com.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.DetailsImpl;
import com.demo.model.Details;

/**
 * Servlet implementation class Training
 */
@WebServlet("/TrainingAcademy")
public class Training extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Training() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	@Override
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   Details insert=new Details();
   DetailsImpl in=new DetailsImpl();
   String name= request.getParameter("name");
   String email= request.getParameter("email");
   String password=request.getParameter("password");
   System.out.println(name);
   insert.setName(name);
   insert.setEmail(email);
   insert.setPassword(password);
   try {
	in. learnerdetails(insert);
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    try {
		List<Details>val=in.get();
		request.setAttribute("details", val);
		RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
        dispatcher.forward(request, response);

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
