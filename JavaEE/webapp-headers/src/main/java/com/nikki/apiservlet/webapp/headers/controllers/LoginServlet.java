package com.nikki.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(USERNAME.equals(username) && PASSWORD.equals(password)){
            resp.setContentType("text/html; charset= UTF-8");
            try(PrintWriter out = resp.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title> Ingreso correcto </title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1> Usuario autorizado </h1>");
                out.println("        <h3> " + username + "</h3>");
                out.println("    </body>");
                out.println("</html>");
            }
            
        }else{
            //resp.setStatus(401);
            //resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos, no esta autorizado tu ingreso en esta pagina");
        }
    }
}
