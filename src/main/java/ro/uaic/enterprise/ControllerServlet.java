package ro.uaic.enterprise;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getParameter("page");

        logRequest(request, page);

        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("text/plain")) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            response.getWriter().print(page);
            return;
        }

        if ("1".equals(page)) {
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/page1.html");

            dispatcher.forward(request, response);

        } else if ("2".equals(page)) {
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/page2.html");

            dispatcher.forward(request, response);

        } else {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Parameter page must be 1 or 2."
            );
        }
    }

    private void logRequest(HttpServletRequest request,
                            String page) {

        getServletContext().log(
                "HTTP method: " + request.getMethod() + "\n" +
                "Client IP: " + request.getRemoteAddr() + "\n" +
                "User-Agent: " + request.getHeader("User-Agent") + "\n" +
                "Languages: " + request.getHeader("Accept-Language") + "\n" +
                "Parameter page: " + page
        );
    }
}
