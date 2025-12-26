package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/simple-status")
public class SimpleStatusServlet extends HttpServlet {

    // 🚨 MUST BE PUBLIC (test calls it directly)
    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter()
                .write("Credit Card Reward Maximizer is running");
    }
}
