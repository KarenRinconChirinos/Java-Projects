package com.nikki.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikki.apiservlet.webapp.headers.models.Producto;
import com.nikki.apiservlet.webapp.headers.services.ProductoService;
import com.nikki.apiservlet.webapp.headers.services.ProductoServiceImpl;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productos.json")
public class ProductosJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }
}