package fr.shopping.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.shopping.bean.Catalogue;
import fr.shopping.bean.Produit;

/**
 * Servlet implementation class AffichePanier
 */
@WebServlet("/AffichePanier")
public class AffichePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AffichePanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Catalogue catalogue = Catalogue.getInstance();
		Cookie[] cookies = request.getCookies();
		Catalogue cataloguePanier = new Catalogue();
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		
		
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookieO = cookies[i];

				if ("PRODUIT_".equals(cookieO.getName().substring(0, 8))) {
					listProduit.put(cookieO.getName(), catalogue.getListProduit().get(cookieO.getValue()));
				}

		}
		cataloguePanier.setName(catalogue.getName());
		cataloguePanier.setListProduit(listProduit);
		request.setAttribute("catalogue", cataloguePanier);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/afficheCatalogueJSTL.jsp");
		dispatcher.forward(request, response);

	}

}
