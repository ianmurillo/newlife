<!DOCTYPE html>
<html lang="es">
<head>
    <title>newlife</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../../../public/logo.png" type="image/png">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }
        .container h2 {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="password"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button {
            background-color: #00ea46;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #00be39;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Saioa hasi</h2>
        <form action="login.php" method="post">
            <label for="usuario">Usuarioa:</label>
            <input type="text" id="usuario" name="usuario" required">
            
            <label for="contrasena">Pasahitza:</label>
            <input type="password" id="contrasena" name="contrasena" required">
            
            <button type="submit">Saioa hasi</button>
        </form>
    </div>
</body>
</html>