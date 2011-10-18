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
	/*
	 * creation et transmission de catalogue correspondant au panier
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * recuperetion du catalogue
		 */
		Catalogue catalogue = Catalogue.getInstance();
		/*
		 * recuperation de la liste des cookies
		 */
		Cookie[] cookies = request.getCookies();
		/*
		 * creation du catalogue qui va contenir les produit de panier
		 */
		Catalogue cataloguePanier = new Catalogue();
		/*
		 * creation de la liste des produit dans le panier
		 */
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		
		
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookieO = cookies[i];

				if ("PRODUIT_".equals(cookieO.getName().substring(0, 8))) {
					listProduit.put(cookieO.getName(), catalogue.getListProduit().get(cookieO.getValue()));
				}

		}
		cataloguePanier.setName(catalogue.getName());
		cataloguePanier.setListProduit(listProduit);
		/*
		 * transmission de catalogue vers la JSTL
		 */
		request.setAttribute("catalogue", cataloguePanier);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/afficheCatalogueJSTL.jsp");
		dispatcher.forward(request, response);

	}

}
