package fr.shopping.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.shopping.bean.Catalogue;
import fr.shopping.bean.Produit;

/**
 * Servlet implementation class VidePanier
 */
@WebServlet("/VidePanier")
public class VidePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VidePanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * la methode permet de vide le panier :
     * parcourir la liste des cookies a chaque valeur de cookie
     * enfait un test d'existance de la valeur dans la liste des produits du catalogue
     * cas : idProduit = valeur cookie en supprime le cookie
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recuperation de catalogue
		Catalogue catalogue = Catalogue.getInstance();
		// recuperation des cookies
		Cookie[] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookieO = cookies[i];
			for (Map.Entry<String, Produit> entry : catalogue.getListProduit()
					.entrySet()) {
				if (cookieO.getValue().equals(entry.getKey())) {
					// suprission de cookie
					cookieO.setMaxAge(0);
					response.addCookie(cookieO);
				}
			}

		}
		// redirection vers /AffichePanier
		response.sendRedirect(request.getContextPath() + "/AffichePanier");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
