package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.DetalleCarro;
import models.ItemCarro;
import models.Producto;
import services.ProductoService;
import services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

/*
 * Autor: Kenin Cusme
 * Fecha: 11/11/2025
 * Descripción: Este servlet permite agregar productos al carrito de compras.
 * Cuando el usuario selecciona un producto, se obtiene su información desde el servicio
 * y se almacena dentro de la sesión del usuario como parte del carrito.
 */
@WebServlet("/agregar-carro") // Define la ruta que activará este servlet
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Se obtiene el parámetro "id" desde la URL y se convierte a tipo Long
        Long id = Long.parseLong(String.valueOf(req.getParameter("id")));

        // Se crea una instancia del servicio que gestiona los productos
        ProductoService service = new ProductoServiceImpl();

        // Se busca el producto según su ID usando el método porId
        Optional<Producto> producto = service.porId(id);

        // Si el producto existe (está presente)
        if (producto.isPresent()) {

            // Se crea un nuevo item del carrito con cantidad 1 y el producto encontrado
            ItemCarro item = new ItemCarro(1, producto.get());

            // Se obtiene la sesión actual del usuario
            HttpSession sesion = req.getSession();

            // Se declara un objeto para manejar los detalles del carrito
            DetalleCarro detalleCarro;

            // Si no existe un carrito en la sesión, se crea uno nuevo
            if (sesion.getAttribute("carro") == null) {
                detalleCarro = new DetalleCarro(); // Nuevo carrito vacío
                sesion.setAttribute("carro", detalleCarro); // Se guarda en la sesión
            } else {
                // Si ya existe un carrito, se obtiene de la sesión
                detalleCarro = (DetalleCarro) sesion.getAttribute("carro");
            }

            // Se agrega el nuevo producto (item) al carrito
            detalleCarro.addItemCarro(item);
        }

        // Finalmente, se redirige al usuario a la página del carrito para visualizar los productos
        resp.sendRedirect(req.getContextPath() + "/ver-carro.jsp");
    }
}
