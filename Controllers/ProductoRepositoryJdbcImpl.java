package Controllers;


import Repositorio.Repository;
import models.Categoria;
import models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {

    private Connection conn;

    // Obtiene la conexión mediante el constructor
    public ProductoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        // Consulta SQL para listar productos con su categoría
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombreCategoria as categoria FROM productos AS p INNER JOIN categorias AS c ON (p.idcategoria = c.id) order by p.id asc")) {

            while (rs.next()) {
                Producto p = getProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;

        // Consulta SQL para buscar un producto por ID
        try (PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombreCategoria as categoria FROM productos AS p INNER JOIN categorias AS c ON (p.idcategoria = c.id) WHERE p.id=?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = getProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;

        // Determina si es una inserción (id=0) o una actualización (id>0)
        if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
            sql = "UPDATE productos SET nombreProducto=?, idCategoria=?, stock=?, precio=?, descripcion=?, fechaElaboracion=?, fechaCaducidad=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos (nombreProducto, idCategoria, stock, precio, descripcion, fechaElaboracion, fechaCaducidad) VALUES(?, ?, ?, ?, ?, ?, ?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getCategoria().getId());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setString(5, producto.getDescripcion());
            stmt.setDate(6, Date.valueOf(producto.getFechaElaboracion())); // Asume java.time.LocalDate
            stmt.setDate(7, Date.valueOf(producto.getFechaCaducidad())); // Asume java.time.LocalDate

            // Si es una actualización, se añade el ID como último parámetro
            if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
                stmt.setLong(8, producto.getIdProducto());
            }

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        // Consulta SQL para eliminar un producto por ID
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto(1L, "Laptop", "Electrónico", 256.20);
        p.setIdProducto(rs.getLong("id"));
        p.setNombre(rs.getString("nombreProducto"));
        p.setStock(rs.getInt("stock"));
        p.setPrecio(rs.getDouble("precio"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setFechaElaboracion(rs.getDate("fechaElaboracion").toLocalDate());
        p.setFechaCaducidad(rs.getDate("fechaCaducidad").toLocalDate());

        // Creamos un nuevo objeto de tipo Categoria
        Categoria c = new Categoria();
        c.setid(rs.getLong("idCategoria"));
        c.setNombreCategoria(rs.getString("categoria")); // Obtenido del JOIN

        p.setCategoria(c);
        return p;
    }
}