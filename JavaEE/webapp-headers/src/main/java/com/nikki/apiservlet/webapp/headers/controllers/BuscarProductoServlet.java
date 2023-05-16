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
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");
        Optional<Producto> encontrado = service.listar().stream().filter(
                p -> {
                    if(nombre == null || nombre.isBlank()){
                        return false;
                    }
                    return p.getNombre().contains(nombre);
                })
                .findFirst();
        if(encontrado.isPresent()){
            resp.setContentType("text/html; charset= UTF-8");
            try(PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title> Producto encontrado </title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1> Product encontrado </h1>");
                out.println("           <ul>");
                out.println("           <li> ID:" + encontrado.get().getId() + " </li>");
                out.println("           <li> NOMBRE:" + encontrado.get().getNombre() + " </li>");
                out.println("           <li> TIPO:" + encontrado.get().getTipo() + " </li>");
                out.println("           <li> PRECIO:" + encontrado.get().getPrecio() + " </li>");
                out.println("           </ul>");
                out.println("    </body>");
                out.println("</html>");
            }

        }else{
            resp.sendError(404, "Lo sentimos no encontramos el producto");
        }
    }
}
