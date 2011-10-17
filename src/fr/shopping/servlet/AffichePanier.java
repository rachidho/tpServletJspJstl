package fr.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>details produit</title>"
				+ "<link rel=stylesheet type='text/css' href='css/styles.css'>"
				+ "<head><body>" + "<a href='/tpServletJspJstl/index.jsp'>Accueil</a>&nbsp;"+
				"<a href='/tpServletJspJstl/afficheCatalogueJSP.jsp'>Catalogue</a>&nbsp;"+
				"<a href='/tpServletJspJstl/AffichePanier'>Voir le panier</a>&nbsp;"+
				"<a href='/tpServletJspJstl/VidePanier'>Vidé le panier</a>" +
						"<div class='titre'>Panier</div><br><br>");

		Catalogue catalogue = Catalogue.getInstance();
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookieO = cookies[i];
			for (Map.Entry<String, Produit> entry : catalogue.getListProduit()
					.entrySet()) {
				if (cookieO.getValue().equals(entry.getKey()+"/")) {
					out.println("<div class='produit'>");
					out.println("<table><tr>");
					out.println("<td rowspan='2'> <img src="
							+ entry.getValue().getImage() + " /></td>");
					out.println("<td><a class='nom' href='/AfficheProduit?id="
							+ entry.getValue().getId() + "'> "
							+ entry.getValue().getNom() + "</a>");
					out.println("</td></tr><tr>");
					out.println("<td class='prix'>"
							+ entry.getValue().getPrix() + " &nbsp;&euro;</td>");
					out.println("</tr><tr>");
					out.println("<td colspan='2' class='desc'>"
							+ entry.getValue().getDescription() + "</td>");
					out.println("</tr></table>");
					out.println("</div>");
				}
			}

		}
		out.println("<body><html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
