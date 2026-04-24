<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Academy</title>
</head>
<body>
    <div style="margin: 50px;">
        <h2>Login Utente</h2>

        <%
            String errore = request.getParameter("errore");
            if ("1".equals(errore)) {
        %>
            <p style="color: red; font-weight: bold;">
                Credenziali non valide. Riprova.
            </p>
        <%
            }
        %>
        <form action="login" method="POST">
            <div>
                <label>Username:</label><br>
                <input type="text" name="username" required>
            </div>
            <br>
            <div>
                <label>Password:</label><br>
                <input type="password" name="password" required>
            </div>
            <br>
            <button type="submit">Accedi</button>
        </form>
    </div>
</body>
</html>