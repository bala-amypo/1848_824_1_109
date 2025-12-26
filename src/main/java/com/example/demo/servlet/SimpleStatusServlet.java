package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        // Required by test
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        // EXACT string expected by test
        out.write("Credit Card Reward Maximizer is running");

        // Required flush check
        out.flush();
    }
}
