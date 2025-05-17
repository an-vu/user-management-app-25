# An Vu's User Management App 2025

A basic Java EE web application for user registration, login, password management, and session-based access control.

---

# Features

- New user registration
- Login/logout with session tracking
- Change password (requires login)
- Protected “Show & Tell” page visible only after login
- Clean UI with gradient background and simple JS validation

---

## Database Setup

- Used Derby Java DB (Network mode)
- Connected to `jdbc:derby://localhost:1527/sample` with user `app`
- Table created:

    ```SQL
    CREATE TABLE USERS (
    ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    USERNAME VARCHAR(255) UNIQUE NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL
    );
    ```

---

## Functionality

Pages implemented:
- `index.xhtml` – Home with login/register links
- `register.xhtml` – New user registration form
- `login.xhtml` – Login form
- `show.xhtml` – Protected page shown after login
- `changepassword.xhtml` – Password update form
- `logout.xhtml` – Logs out and redirects

Backend:
- `RegisterBean` handles user registration using JDBC
- `LoginBean` handles login, logout, and password change
- Session tracked via `@SessionScoped` CDI bean

---

## Tech Used

- JSF + Jakarta EE 10
- XHTML (Facelets)
- CDI (@Named + @SessionScoped/@RequestScoped)
- JDBC with Derby (no connection pool needed)
- GlassFish 7
- Apache NetBeans IDE 25

Frontend:
- Custom `style.css` with gradient background and Apple-style fonts
- Simple `script.js` to validate login/register input

---

## Deployment

- Exported `.war` via Clean and Build
- App tested on Safari via NetBeans + GlassFish

---

## How to View Registered Users

To see the list of registered usernames and passwords in the database:

1. Go to **Services > Databases** in NetBeans
2. Connect to:  
   `jdbc:derby://localhost:1527/sample` (user: `app`, password: `app`)
3. Right-click the connection → **Execute Command**
4. Run this SQL:

    ```sql
    SELECT * FROM USERS;
    ```

This will show all registered users in the USERS table.

---
