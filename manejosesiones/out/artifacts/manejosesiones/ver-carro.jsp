<%--
  Created by IntelliJ IDEA.
  User: RAI2025
  Date: 12/11/2025
  Time: 14:43
  Descripción: Página de bienvenida para la tienda de compras.
  Presenta un diseño moderno y responsivo.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido a la Tienda de Compras</title>
    <style>
        /* ======== ESTILOS GENERALES ======== */
        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #74b9ff, #0984e3);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* ======== CONTENEDOR PRINCIPAL ======== */
        .container {
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            padding: 40px 60px;
            text-align: center;
            box-shadow: 0 8px 25px rgba(0,0,0,0.3);
            max-width: 500px;
            width: 90%;
            transition: transform 0.3s ease;
        }

        .container:hover {
            transform: translateY(-5px);
        }

        /* ======== TITULO ======== */
        h1 {
            font-size: 2.2rem;
            margin-bottom: 15px;
            color: #fff;
            letter-spacing: 1px;
        }

        p {
            font-size: 1.1rem;
            color: #ecf0f1;
            margin-bottom: 30px;
        }

        /* ======== BOTONES ======== */
        .btn {
            display: inline-block;
            padding: 12px 25px;
            margin: 10px;
            font-size: 1rem;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            background: #00cec9;
            transition: background 0.3s ease, transform 0.2s;
        }

        .btn:hover {
            background: #00b894;
            transform: scale(1.05);
        }

        /* ======== FOOTER ======== */
        footer {
            position: absolute;
            bottom: 15px;
            width: 100%;
            text-align: center;
            font-size: 0.9rem;
            color: rgba(255, 255, 255, 0.8);
        }

        @media (max-width: 600px) {
            h1 {
                font-size: 1.8rem;
            }
            .container {
                padding: 30px;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h1>¡Bienvenido a la Tienda de Compras 🛍️!</h1>
    <p>Encuentra los mejores productos al mejor precio. Inicia sesión o explora nuestro catálogo.</p>

    <a href="login.jsp" class="btn">Iniciar Sesión</a>
    <a href="productos.jsp" class="btn">Ver Productos</a>
</div>

<footer>
    © 2025 Tienda de Compras - Todos los derechos reservados.
</footer>

</body>
</html>
