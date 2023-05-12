package com.nikki.apiservlet.webapp.form;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/crear")
public class RegistroProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name  = req.getParameter("nombre");
        String maker =  req.getParameter("fabricante");
        String price = req.getParameter("precio");
        Map<String, String> errores = new HashMap<>();
        int price1;
        if( name == null || name.isBlank()){
            errores.put("nombre","El nombre no puede estar vacio");
        }
        if(price == null || price.isBlank()){
            errores.put("precio","El precio no puede estar vacio");
        }else{
            try {
                price1 = Integer.parseInt(price);
                errores.put("precio","El precio es un entero");
            }catch (NumberFormatException e){
                errores.put("precio","El precio no es un entero");
            }
        }

        if(maker  == null || maker.isBlank()){
            errores.put("fabricante","El fabricante no puede estar vacio");
        }else{
            if(!(maker.length() >= 4 && maker.length() <= 10)){
                errores.put("fabricante","El fabricante debe estar entre 4 y 10 caracteres");
            }
        }

        if(errores.isEmpty()) {

            try(PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title> Resultado Form </title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1> Resultado Form  </h1>");
                out.println("        <ul>");
                out.println("           <li> Nombre:  " + name + "  </li>");
                out.println("           <li> Precio:  " + price + "  </li>");
                out.println("           <li> Fabricante:  " + maker + "  </li>");
                out.println("        </ul>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
                /*errores.forEach(e -> {
                    out.println("<li>" + e + "</li>");
                });
                //p de parrafo
                out.println("<p><a href=\"/webapp-form/index.jsp\"> volver </a></p>");*/
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        }
    }
}
