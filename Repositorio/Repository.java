package Repositorio;

import models.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Repository<P> {
    List<Producto> listar() throws SQLException;

    Producto porId(Long id) throws SQLException;

    void guardar(Producto producto) throws SQLException;

    void eliminar(Long id) throws SQLException;
}
