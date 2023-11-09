<!DOCTYPE html>
<html>
<head>
        
        <title>newlife</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>NewLife</title>
        <link rel="icon" href="../../../public/logo.png" type="image/png">
        <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>
    <header>
        <div>
        <h1>NewLife</h1>
        <img width="120" height="100" src="../../../public/logo.png"/>
    </div>
    </header>
    <div class="navbar">
       
        <a href="../Hasiera/index.html">Hasiera</a>
        <a href="../GureInformazia/OurInfo.html">Gure Informazioa</a>
        <a href="../Katalogo/katalogoa.php">Katalogoa</a>
        <a href="../Notiziak/notiziak.php">Notiziak</a>
        <a href="Hornitzaileak.php">Hornitzaileak</a>
       
       
        <div class="navbar-right">
            <a href="../Login/login.php">Saioa hasi</a>
            <a href="../Erregistratu/registratu.html">Erregistratu</a>
        </div>
           
    </div>
 
<div class="container">
    
    <center><h2>Hornitzaile formularioa</h2></center>

    <form action="hornitzaileak.php" method="post">
            <label for="telefonoa">Telefono zenbakia:</label>
            <input type="text" name="TelZenbakia" required><br><br>

            <label for="izena">Izena:</label>
            <input type="text" name="Izena" required><br><br>

            <label for="NAN">NAN:</label>
            <input type="text" name="NAN" required><br><br>

            <label>Hornitzaile mota:</label>
            <input type="radio" name="HornitzaileMota" value="empresa" required> Enpresa
            <input type="radio" name="HornitzaileMota" value="pertsona" required> Pertsona<br><br>

            <label for="helbidea">Helbidea:</label>
            <input type="text" name="Helbidea" required><br><br>

            <label for="eskaintza">Eskaintzen den zerbitzua edo produktua:</label>
            <input type="text" name="Zerbitzua" required><br><br>

            <input type="submit" value="Gorde hornitzailea">
        </form>
</div>
 
</body>
</html>

<?php

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $servername = "localhost";
        $username = "root";
        $password = "abc123ABC";
        $dbname = "newlife";

        $conn = new mysqli($servername, $username, $password, $dbname);

        if ($conn->connect_error) {
            die("Errorea datu-basearekin konexioan: " . $conn->connect_error);
        }

        $telefonoa = $_POST["TelZenbakia"];
        $izena = $_POST["Izena"];
        $NAN = $_POST["NAN"];
        $mota = $_POST["HornitzaileMota"];
        $helbidea = $_POST["Helbidea"];
        $eskaintza = $_POST["Zerbitzua"];

        $sql = "INSERT INTO hornitzaileFormulario (TelZenbakia, Izena, NAN, HornitzaileMota, Helbidea, Zerbitzua) VALUES (?, ?, ?, ?, ?, ?)";

        $stmt = $conn->prepare($sql);
        $stmt->bind_param("ssssss", $telefonoa, $izena, $NAN, $mota, $helbidea, $eskaintza);

        if ($stmt->execute()) {
            echo "Datuak datu-basean gorde dira.";
        } else {
            echo "Errorea datuak datu-basean sartzerakoan: " . $stmt->error;
        }

        $stmt->close();
        $conn->close();
    }
?>
    </body>
    <footer>
        <div class="footer">
            <p>&copy; 2023 Newlife - Eskubide guztiak erreserbatuta</p>
        </div>
    </footer>
</html>