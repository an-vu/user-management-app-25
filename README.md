An Vu's User Management App 2025

---

✅ DATABASE SETUP

- Used Derby Java DB (Network mode)
- Connected to `jdbc:derby://localhost:1527/sample` with user `app`
- Table created:

CREATE TABLE USERS (
  ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  USERNAME VARCHAR(255) UNIQUE NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL
);

---

✅ FUNCTIONALITY

Pages implemented:
- index.xhtml – Home with login/register links
- register.xhtml – New user registration form
- login.xhtml – Login form
- show.xhtml – Protected page shown after login
- changepassword.xhtml – Password update form
- logout.xhtml – Logs out and redirects

Backend:
- `RegisterBean` handles user registration using JDBC
- `LoginBean` handles login, logout, and password change
- Session tracked via `@SessionScoped` CDI bean

---

✅ TECH USED

- JSF + Jakarta EE 10
- XHTML (Facelets)
- CDI (@Named + @SessionScoped/@RequestScoped)
- JDBC with Derby (no connection pool needed)
- GlassFish 7
- NetBeans 12.6

Frontend:
- Custom `style.css` with gradient background and Apple-style fonts
- Simple `script.js` to validate login/register input

---

✅ DEPLOYMENT

- Exported `.war` via Clean and Build
- App tested on Chrome via NetBeans + GlassFish

---

✅ DEMO VIDEO

- Recording shows registration, login, access to protected page, password change, and logout.
