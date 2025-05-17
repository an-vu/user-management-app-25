function validateLoginForm() {
    const user = document.getElementById("form:username");
    const pass = document.getElementById("form:password");

    if (!user.value.trim() || !pass.value.trim()) {
        alert("Please enter both username and password.");
        return false;
    }
    return true;
}
