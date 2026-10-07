package ro.uaic.enterprise;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Servlet Request Routing</title>
            </head>
            <body>
                <h1>Welcome</h1>

                <form action="controller" method="GET">
                    <p>Select a page:</p>

                    <label>
                        <input type="radio" name="page" value="1" required>
                        Page 1
                    </label>

                    <br>

                    <label>
                        <input type="radio" name="page" value="2">
                        Page 2
                    </label>

                    <br><br>

                    <button type="submit">Submit</button>
                </form>
            </body>
            </html>
            """);
    }
}