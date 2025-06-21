package cl.duoc.bs_ventas_bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.bs_ventas_bs.clients.PedidoBsFeignClient;
import cl.duoc.bs_ventas_bs.clients.ProductoBsFeignClient;
import cl.duoc.bs_ventas_bs.model.dto.DetallePedidoDTO;
import cl.duoc.bs_ventas_bs.model.dto.PedidoDTO;
import cl.duoc.bs_ventas_bs.model.dto.ProductoDTO;


@Service
public class VentasService {
    @Autowired
    PedidoBsFeignClient pedidoBsFeignClient;

    @Autowired
    ProductoBsFeignClient productoBsFeignClient;

    public PedidoDTO findPedidoById(Long id){
        PedidoDTO pedidoDTO = pedidoBsFeignClient.findPedidoById(id).getBody();
        for(DetallePedidoDTO detallePedidoDTO : pedidoDTO.getDetalles()){
            Long productoId = detallePedidoDTO.getProducto().getIdProducto();
            ProductoDTO producto = productoBsFeignClient.findProductById(productoId).getBody();
            detallePedidoDTO.setProducto(producto);
        }
        return pedidoDTO;
    }

}
