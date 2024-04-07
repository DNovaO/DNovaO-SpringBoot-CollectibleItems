package com.itq.VentasColeccionables;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import producto.com.Producto; // Importar la clase Producto del paquete adecuado
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ProductoRepository {
    private static final Map<Integer, Producto> productos = new HashMap<>(); // Cambiar el tipo de clave del Map a Integer, asumiendo que el ID es único

    @PostConstruct
    public void initData() {
        // Inicializamos los productos
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setName("Camiseta");
        producto1.setDescription("Una camiseta de algodón de alta calidad");
        producto1.setPrecio(20.0);
        producto1.setNumeroserie(12345); // Se agrega un número de serie como ejemplo
        producto1.setInventarios(10); // Se agrega una cantidad inicial de inventario
        producto1.setDescuentos(0); // No hay descuento inicialmente

        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setName("Figura coleccionable");
        producto2.setDescription("Una figura de acción coleccionable");
        producto2.setPrecio(35.0);
        producto2.setNumeroserie(67890); // Se agrega un número de serie como ejemplo
        producto2.setInventarios(5); // Se agrega una cantidad inicial de inventario
        producto2.setDescuentos(0); // No hay descuento inicialmente

        Producto producto3 = new Producto();
        producto3.setId(3);
        producto3.setName("Poster");
        producto3.setDescription("Un póster de edición limitada de una película famosa");
        producto3.setPrecio(15.0);
        producto3.setNumeroserie(13579); // Se agrega un número de serie como ejemplo
        producto3.setInventarios(20); // Se agrega una cantidad inicial de inventario
        producto3.setDescuentos(0); // No hay descuento inicialmente

        // Agregamos los productos al mapa utilizando el ID como clave
        productos.put(producto1.getId(), producto1);
        productos.put(producto2.getId(), producto2);
        productos.put(producto3.getId(), producto3);
    }

    // Método para encontrar un producto por su ID
    public Producto findProducto(int id) {
        Assert.isTrue(id > 0, "El ID del producto debe ser mayor que cero");
        return productos.get(id);
    }

    // Método para obtener todos los productos
    public List<Producto> getAllProductos() {
        return new ArrayList<>(productos.values());
    }
}
