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
    public void testAgregarProducto() {
        Producto nuevo = new Producto("Juego", 45.00);
        productoService.agregarProducto(nuevo);
        assertEquals(3, productoService.listarProductos().size());
    }

    @Test
    public void testListarProductos() {
        List<Producto> productos = productoService.listarProductos();
        assertEquals(2, productos.size());
    }

    @Test
    public void testBuscarPorNombreExistente() {
        Producto resultado = productoService.buscarPorNombre("libro");
        assertNotNull(resultado);
        assertEquals("Libro", resultado.getNombre());
    }

    @Test
    public void testBuscarPorNombreInexistente() {
        Producto resultado = productoService.buscarPorNombre("Zapato");
        assertNull(resultado);
    }
}
