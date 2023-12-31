package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import service.IItemService;
import service.ItemDAO;
import service.ItemServiceImpl;

/**
 * Servlet implementation class AdminSerrvlet
 */
@WebServlet("/AdminSerrvlet")
public class AdminSerrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSerrvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Item> itemList = new ArrayList<>();
		
		ItemDAO itemDAO = new ItemDAO();
		
		itemList = itemDAO.getAllItems();

		request.setAttribute("itemList", itemList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/item-list.jsp");
		
		rd.forward(request, response);
	}

}
