package com.mohit.leftpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mohit.bean.Income_CategoryBean;
import com.mohit.dao.Income_CategoryDAO;

/**
 * Servlet implementation class Income_Category_update
 */
@WebServlet("/Income_Category_update")
public class Income_Category_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Income_Category_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int userId = 0;
		
		try {
			/*userId from Income Category*/			
			HttpSession session = request.getSession();
			userId = (Integer)session.getAttribute("id");
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (ClassCastException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		int inc_catId = 0;
		
		try {
			/*inc_catId from Income Category table edit*/
			inc_catId = Integer.parseInt(request.getParameter("inc_catId"));
		}catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		Income_CategoryDAO icd = new Income_CategoryDAO();
		Income_CategoryBean icb_Value = icd.findByIncCatId(inc_catId);

		
		
		if(userId == 0) {
			out.println("<h1 class='hideMeAfter5Seconds' style='color: red; text-align: center'>Please login first.</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}else {
			String linkRU = "";
			String linkRU_name = "";
			
			String linkLL = "";
			String linkLL_name = "";

			if(userId == 0) {
				/*==(register.html , Register User)==*/
				linkRU = "registerUser.html";
				linkRU_name = "Register User";
				
				/*==(login.html , Login)==*/
				linkLL = "login.html";
				linkLL_name = "Login";
			}else {
				/*==(updateProfile , Update Profile)== */
				linkRU = "updateProfile?id=" + userId;
				linkRU_name = "Update Profile";
				
				/*==(logoutController , Logout)== */
				linkLL = "logoutController?id= + userId";
				linkLL_name = "Logout";
			}
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
			out.println("<title>Home</title>");
			out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div id='container'>");
			out.println("<div class='head'>");
			out.println("<div class='logo'>");
			out.println("<img src='images/pis-logo.png'>");
			out.println("</div>");
			out.println("<div class='menu'>");
			out.println("<ul class='menu-ul'>");
			
			out.println("<li class='menu-ul-li'><a href='homePage'>Home</a></li>");
			out.println("<li class='menu-ul-li'><a href='UserProfile?id=" + userId + "'>Profile</a></li>");									
			out.println("<li class='menu-ul-li'><a href='" + linkRU + "'>" + linkRU_name + "</a></li>");								
			out.println("<li class='menu-ul-li'><a href='" + linkLL + "'>" + linkLL_name + "</a></li>");
			
			
			out.println("</ul>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='left-menu-bar-Master'>");
			out.println("<p class='left-menu-heading-master'>Master</p>");

			out.println("<div class='left-menu-blackBox'>");
			out.println("<ul class='left-menu-ul'>");
			out.println("<li class='left-menu-ul-li'><a href='ExpencesCategory?id=" + userId + "'>Expenses Category</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='IncomeCategory?id=" + userId + "'>Income Category</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='ExpencesForm?id=" + userId + "'>Expenses</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='IncomeForm?id=" + userId + "'>Income</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='CashBook?id=" + userId + "'>Cash Book</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='BankBook?id=" + userId + "'>Bank Book</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='DayBook?id=" + userId + "'>Day Book</a></li>");
			out.println("<li class='left-menu-ul-li'><a href='BalanceSheet?id=" + userId + "'>Balance Sheet</a></li>");
			out.println("</ul>");
			out.println("</div>");
			out.println("</div>");
				
			out.println("<div class='right-income-category-container'>");
			out.println("<div class='right-income-category-child'>");
			out.println("<div class='right-income-category-form-container' style='width: 60vw; height: 30vh; background-color: none;'>");
			out.println("<p class='income-category-head'>Update Income Category</p>");
					
			out.println("<form action='UpdateIncomeCategory' class='right-income-form' >");
			
			out.println("<input type='text' name='inc_catId' id='incCN' value='" + inc_catId + "' style='display: none;'>");
			
			out.println("<label for='incCN' class='incCatNme'>Category Name:</label>");
			out.println("<input type='text' name='incCatName' id='incCN' placeholder='enter category name' required='required' value='" + icb_Value.getInc_CatName() + "'>");
			out.println("<br>");
			out.println("<label for='incCD' class='incCatDetails'>Category Details:</label>");
			out.println("<input type='text' name='incCatDetails' id='incCD' placeholder='enter category details' required='required' value='" + icb_Value.getInc_CatDetails() + "'>");
			out.println("<br>");
			out.println("<input type='text' name='userId' id='incCN' value='" + userId + "' style='display: none;'>");
			out.println("<input id='AddIncome' type='submit' value='Update'>");
			out.println("</form>");

			out.println("</div>");

			out.println("<hr size='10px' color='grey'>");

			out.println("<div class='right-income-category-infotable'>");
			out.println("<table border='0' class='right-income-category-table'>");
			out.println("<tr>");
			out.println("<th class='income-th'>Category Name</th>");
			out.println("<th class='income-th'>Category Details</th>");
			out.println("<th class='income-th'>Edit</th>");
			out.println("<th class='income-th'>Delete</th>");
			out.println("</tr>");
			
		ArrayList<Income_CategoryBean> al = icd.findAll(userId);
		for(Income_CategoryBean icb: al) {
			response.setContentType("text/html");
			out.println("<tr>");
			out.println("<td >" + icb.getInc_CatName() + "</td>");
			out.println("<td>" + icb.getInc_CatDetails() + "</td>");
			out.println("<td><a href='Income_Category_update?=" + icb.getInc_CatId() + "'>Edit</a></td>");
			out.println("<td><a href='Income_Category_Delete?catId=" + icb.getInc_CatId() + "'>Delete</a></td>");
			out.println("</tr>");
		}				
			out.println("</table>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
