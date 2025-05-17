package com.myapp.jsf;

import java.io.Serializable;
import java.sql.*;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import java.io.IOException;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;
    private String newPassword;

    // Getters/setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    // Login logic
    public String login() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample", "app", "app");

            String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "show.xhtml?faces-redirect=true";
            } else {
                return null; // stay on login page
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Change password
    public String changePassword() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample", "app", "app");

            String sql = "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);

            int rows = ps.executeUpdate();
            conn.close();

            if (rows > 0) {
                return "show.xhtml?faces-redirect=true";
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Logout
    public void logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();
        try {
            facesContext.getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
