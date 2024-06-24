package org.example.numerospri;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/primos")
public class Primos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String strPriNum = req.getParameter("primerNumero");
        String strUltNum = req.getParameter("ultimoNumero");

        int priNum = Integer.parseInt(strPriNum);
        int ultNum = Integer.parseInt(strUltNum);

        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>Números Primos</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Números Primos en el Rango</h1>");

        out.print("<p>Rango: " + priNum + " a " + ultNum + "</p>");
        out.print("<p>Números primos:</p>");
        out.print("<ul>");

        // Metodo que calcula y imprimir los números primos en el rango
        for (int i = priNum; i <= ultNum; i++) {
            if (primo(i)) {
                out.print("<li>" + i + "</li>");
            }
        }

        out.print("</ul>");
        out.print("</body>");
        out.print("</html>");
    }

    // Método para saber si es primo
    public static boolean primo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
