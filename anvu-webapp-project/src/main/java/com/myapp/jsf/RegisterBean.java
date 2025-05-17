package com.myapp.jsf;

import java.io.Serializable;
import java.sql.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("registerBean")
@RequestScoped
public class RegisterBean implements Serializable {
    private String username;
    private String password;

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String register() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample", "app", "app");

            String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            conn.close();
            return "login.xhtml?faces-redirect=true";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
