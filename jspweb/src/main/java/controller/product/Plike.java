package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.ProductDao;


@WebServlet("/product/plike")
public class Plike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Plike() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		System.out.println("pno :" + pno);
		System.out.println("mno :" + mno);
		
		boolean result = ProductDao.getInstance().getplike(pno, mno);
		response.getWriter().print(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		System.out.println("pno :" + pno);
		System.out.println("mno :" + mno);
		
		int result = ProductDao.getInstance().setplike(pno, mno);
		response.getWriter().print(result);
		
	}

}
