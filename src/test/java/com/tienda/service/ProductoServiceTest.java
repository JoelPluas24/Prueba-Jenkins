package com.tienda.service;

import com.tienda.model.Producto;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoServiceTest {

    private ProductoService productoService;

    @Before
    public void setUp() {
        productoService = new ProductoService();
        productoService.agregarProducto(new Producto("Libro", 12.99));
        productoService.agregarProducto(new Producto("Película", 19.99));
    }

    @Test
    public void debeAgregarProductoCorrectamente() {
        // Arrange
        Producto nuevo = new Producto("Juego", 45.00);

        // Act
        productoService.agregarProducto(nuevo);

        // Assert
        assertEquals(3, productoService.listarProductos().size());
    }

    @Test
    public void debeListarTodosLosProductos() {
        // Act
        List<Producto> productos = productoService.listarProductos();

        // Assert
        assertEquals(2, productos.size());
    }

    @Test
    public void debeEncontrarProductoPorNombreExistente() {
        // Act
        Producto resultado = productoService.buscarPorNombre("libro");

        // Assert
        assertNotNull(resultado);
        assertEquals("Libro", resultado.getNombre());
    }

    @Test
    public void debeRetornarNullSiProductoNoExiste() {
        // Act
        Producto resultado = productoService.buscarPorNombre("Zapato");

        // Assert
        assertNull(resultado);
    }

    @Test
    public void debePermitirAgregarProductosConNombreDuplicado() {
        // Arrange
        Producto duplicado = new Producto("Libro", 15.00);

        // Act
        productoService.agregarProducto(duplicado);

        // Assert
        assertEquals(3, productoService.listarProductos().size());
    }
}
