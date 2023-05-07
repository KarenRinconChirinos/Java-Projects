package com.nikki.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/IndexServlet/webapp")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd 'de'  MMM, yyyy");

        String formatoFechaActual = fechaActual.format(myFormatObj);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>  </title>");
        out.println("    </head>");
        out.println("    <body>");
        if(nombre != null && apellido != null){
            out.println("        <h1> Tarea 1: Servlet y envio de parametros </h1>");
            out.println("        <h2> Hola! Mi nombre es: " + nombre + " " + apellido + " </h2>");
        }else{
            out.println("        <h2> No existen los datos </h2>");
        }
        try{
            out.println("        <h3> La fecha actual es: " + formatoFechaActual + " </h3>");

        }catch (DateTimeException e){
            e.getStackTrace();
        }
        out.println("    </body>");
        out.println("</html>");
        out.close();

    }
}

