package com.nikki.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset= UTF-8");

        String metodoHttp =  req.getMethod();
        String requestUri =  req.getRequestURI();
        String requestUrl =  req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath =  req.getServletPath();
        String ip = req.getLocalAddr();
        String ipCliente = req.getRemoteAddr(); //Cliente que esta usando la pagian o el servlet
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String url =  scheme + "://" + host + contextPath + servletPath;
        String url2 =  scheme + "://" + ip + ":" + port + contextPath + servletPath;

        try(PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title> Cabeceras HTTP Request </title>");
            out.println("    </head>");
            out.println("    <body>");

            out.println("        <h1> Cabeceras HTTP Request </h1>");
            out.println("       <ul>");
            out.println("        <li> metodo http: " + metodoHttp + " </li>");
            out.println("        <li> request uri: " + requestUri + " </li>");
            out.println("        <li> request url: " + requestUrl + " </li>");
            out.println("        <li> context path: " + contextPath + " </li>");
            out.println("        <li> servlet path: " + servletPath + " </li>");
            out.println("        <li> ip local: " + ip + " </li>");
            out.println("        <li> ip cliente: " + ipCliente + " </li>");

            out.println("        <li> puerto local: " + port + " </li>");
            out.println("        <li> scheme: " + scheme + " </li>");
            out.println("        <li> host: " + host + " </li>");
            out.println("        <li> url: " + url + " </li>");
            out.println("        <li> url2: " + url2 + " </li>");

            out.println("        <h2> Headers Name </h2>");

            /* con el getHeaderNames se obtiene mas cabeceras, tipos de contenido que accepta el navegador
            accept
            accept-encoding: tipos de compresion que soporta el navegador para coprimir
            accept-lanage es el lenguaje aceptadoo por el cliente
            referer - ultima pagian clickeada
            * */
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String cabeceras = headerNames.nextElement();
                out.println("<li>" + cabeceras + ": " + req.getHeader(cabeceras) + "</li>");
            }

            out.println("       </ul>");

            out.println("    </body>");
            out.println("</html>");
        }

    }
}
