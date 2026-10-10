package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String roll = request.getParameter("rollNo");
        String branch = request.getParameter("branch");
        String email = request.getParameter("email");

        out.println("<html><body>");

        out.println("<h1>Student Details Submitted Successfully!</h1>");
        out.println("<p>Name: " + escape(name) + "</p>");
        out.println("<p>Roll Number: " + escape(roll) + "</p>");
        out.println("<p>Branch: " + escape(branch) + "</p>");
        out.println("<p>Email: " + escape(email) + "</p>");

        out.println("<br><a href='student.html'>Back to Form</a>");

        out.println("</body></html>");
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}