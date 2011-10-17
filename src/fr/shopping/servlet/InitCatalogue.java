package fr.shopping.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.shopping.bean.Catalogue;
import fr.shopping.bean.Produit;

/**
 * Servlet implementation class InitCatalogue
 */
@WebServlet("/InitCatalogue")
public class InitCatalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public InitCatalogue() {
		Produit produit1 = new Produit();
		produit1.setId("P1");
		produit1.setNom("PHILIPS 52PFL7203H");
		produit1.setPrix(1499.99f);
		Produit produit2 = new Produit();
		produit2.setId("P2");
		produit2.setNom("SAMSU_PS42A416");
		produit2.setPrix(589.99f);
		produit2.setImage("http://ak.cdiscount.com/pdt/4/1/6/1/d/SAMSU_PS42A416.jpg");
		produit2.setDescription("T�l�viseur Plasma 42\" (106 cm) 16:9 - Tuner TNT int�gr� - Double HDMI - Entr�e PC -"
		+ "R�solution: 1024 x 768 - Luminosit�: 1500 cd/m� - Taux de contraste: 100 000:1 - Angle de vision: 175�");
		Produit produit3 = new Produit();
		produit3.setId("P3");
		produit3.setNom("PHILIPS 52PFL7203H");
		produit3.setImage("http://ak.cdiscount.com/pdt/0/3/H/1/d/PHIL_52PFL7203H.jpg");
		produit3.setPrix(1499.99f);
		Produit produit4 = new Produit();
		produit4.setId("P4");
		produit4.setNom("TOSHIBA 32CV515DG");
		produit4.setPrix(499.99f);
		produit4.setDescription("T�l�viseur LCD 32\" (81 cm) 16:9 HD TV - Tuner TNT HD int�gr� - Triple HDMI - R�solution:"
		+ "1366 x 768 - Luminosit�: 500 cd/m� - Contraste: 30000:1 - Temps de r�ponse: 8 ms - Angle de vision: 178�");
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		listProduit.put(produit1.getId(), produit1);
		listProduit.put(produit2.getId(), produit2);
		listProduit.put(produit3.getId(), produit3);
		listProduit.put(produit4.getId(), produit4);
		Catalogue catalogue = Catalogue.getInstance();
		catalogue.setName("Catalogue");
		catalogue.setListProduit(listProduit);
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
