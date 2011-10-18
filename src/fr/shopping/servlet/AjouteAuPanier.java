package fr.shopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjouteAuPanier
 */
@WebServlet("/AjouteAuPanier")
public class AjouteAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouteAuPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * ajoute d'un produit dans le panier avec un test d'existance de ce dernier
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean exist = false;
		/*
		 * creation de cookie
		 */
		Cookie cookie = new Cookie("PRODUIT_"+id, id);
		/*
		 * la duree de vie d'un cookie
		 */
		cookie.setMaxAge(3600);
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
		      Cookie cookieO = cookies[i];
		      if (cookie.getValue().equals(cookieO.getValue())){
		    	  exist = true;
		    	  break;
		      }
		    }
		/*
		 * l'ajoute de cookie " cas non existe "
		 */
		if(exist == false){
			response.addCookie(cookie);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/afficheCatalogueJSP.jsp");
		dispatcher.forward(request, response);
		
	}

}
