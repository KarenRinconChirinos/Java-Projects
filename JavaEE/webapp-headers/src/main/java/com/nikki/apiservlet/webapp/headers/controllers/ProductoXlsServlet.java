package com.nikki.apiservlet.webapp.headers.controllers;

import com.nikki.apiservlet.webapp.headers.models.Producto;
import com.nikki.apiservlet.webapp.headers.services.ProductoService;
import com.nikki.apiservlet.webapp.headers.services.ProductoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset= UTF-8");
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls){
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        }
        try(PrintWriter out = resp.getWriter()) {

            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title> Listado de productos </title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1> Listado de productos </h1>");
                out.println("       <p><a href=\"" + req.getContextPath() + "/productos.xls" + "\" > Se exporta a xls </a> ");
                    out.println("       <p><a href=\"" + req.getContextPath() + "/productos.json" + "\" > Lista a json </a> ");
            }
            out.println("       <table>");
            out.println("       <tr>");
            out.println("       <th> id </th>");
            out.println("       <th> nombre </th>");
            out.println("       <th> tipo </th>");
            out.println("       </tr>");

            productos.forEach(p ->  {
                out.println("<tr>");
                out.println("<th> " + p.getId() + " </th>");
                out.println("<th> " + p.getNombre() + " </th>");
                out.println("<th> " + p.getTipo() + " </th>");
                out.println("<th> " + p.getPrecio() + " </th>");
                out.println("</tr>");
            });

            out.println("       <th> precio </th>");

            out.println("       </table>");

            if(!esXls) {
                out.println("    </body>");
                out.println("</html>");
            }
        }

    }
}
