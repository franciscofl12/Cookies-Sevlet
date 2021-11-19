package src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContadorCookies
 */
@WebServlet("/ServletContadorCookies")
public class ServletContadorCookies extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContadorCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        Cookie[] cookies = request.getCookies();
        Cookie contador = buscaCookie("contador", cookies);

        if (contador == null) {
            Cookie cookie = new Cookie("contador", "1");
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            PrintWriter out = response.getWriter();
            out.println("Primera visita");

        } else {
            int cont = Integer.parseInt(contador.getValue());
            cont++;
            Cookie cookie = new Cookie("contador", "" + cont);
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            PrintWriter out = response.getWriter();
            out.println("Visita numero " + cont);
            System.out.println(cont);
        }
    }
    
    private Cookie buscaCookie(String nombre, Cookie[] cookies) {
        if (cookies == null) return null;
        else {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(nombre)) {
                    return cookies[i];
                }
            }
        }
        return null;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}
