package com.shop.servlets;

import com.shop.UserLogin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import org.json.JSONObject;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserLogin userLogin = new UserLogin();
    
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        JSONObject json = new JSONObject(sb.toString());
        String username = json.getString("username");
        String password = json.getString("userpass"); 

        boolean valid = UserLogin.validateLogin(username, password);

        JSONObject responseJson = new JSONObject();
        responseJson.put("success", valid);
        responseJson.put("message", valid ? "Login successful" : "Invalid credentials");

        resp.getWriter().write(responseJson.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\": \"Login Servlet works!\"}");
    	}
    }
