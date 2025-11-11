
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Inicio de Sesion</title>
    <style>
        /* Estilos generales para el cuerpo */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9; /* Fondo suave */
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            color: #333;
        }

        /* Estilos para el contenedor principal del formulario */
        div {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); /* Sombra sutil */
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
        }

        /* Estilos para el encabezado */
        h1 {
            text-align: center;
            color: #4a90e2; /* Color de encabezado primario */
            margin-bottom: 30px;
            font-size: 1.8em;
        }

        /* Estilos para los campos del formulario */
        form div {
            margin-bottom: 20px;
            padding: 0; /* Remover padding adicional en los divs internos */
            background: none;
            box-shadow: none;
        }

        /* Estilos para las etiquetas */
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #555;
        }

        /* Estilos para los inputs de texto y contraseña */
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box; /* Asegura que el padding no cambie el ancho total */
            font-size: 1em;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #4a90e2; /* Resalta el borde al enfocar */
            outline: none; /* Remueve el contorno por defecto */
        }

        /* Estilos para el botón de submit */
        input[type="submit"] {
            width: 100%;
            background-color: #5cb85c; /* Color de botón de éxito/primario */
            color: white;
            padding: 12px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1.1em;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #4cae4c; /* Oscurece al pasar el ratón */
        }
    </style>
</head>
<body>
<div>
    <h1>Inicio de Sesion</h1>
    <form action="login.html" method="post">
        <div>
            <label for="user"> Ingrese el usuario: </label>
            <input type="text" id="user" name="user" required>
        </div>
        <div>
            <label for="password">Ingrese password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <input type="submit" value="Iniciar Sesion">
        </div>
    </form>
</div>

</body>
</html>