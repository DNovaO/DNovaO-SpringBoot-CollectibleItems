package com.itq.VentasColeccionables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import producto.com.GetProductoResponse;
import producto.com.GetProductoRequest;

@Endpoint
public class CollecionablesEndpoint {
    private static final String NAMESPACE_URI = "http://com.Producto";

    private ProductoRepository productoRepository;

    @Autowired
    public CollecionablesEndpoint(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse VentaCliente(@RequestPayload GetProductoRequest request) {
        GetProductoResponse response = new GetProductoResponse();
        response.setProducto(productoRepository.findProducto(request.getId()));

        return response;
    }
}
