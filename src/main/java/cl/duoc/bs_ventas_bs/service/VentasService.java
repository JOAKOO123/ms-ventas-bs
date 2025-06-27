package cl.duoc.bs_ventas_bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.bs_ventas_bs.clients.ClienteBsFeignClient;
import cl.duoc.bs_ventas_bs.clients.PedidoBsFeignClient;
import cl.duoc.bs_ventas_bs.clients.ProductoBsFeignClient;
import cl.duoc.bs_ventas_bs.clients.WebPayFeignClient;
import cl.duoc.bs_ventas_bs.model.dto.ClienteDTO;
import cl.duoc.bs_ventas_bs.model.dto.DetallePedidoDTO;
import cl.duoc.bs_ventas_bs.model.dto.PedidoDTO;
import cl.duoc.bs_ventas_bs.model.dto.ProductoDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransacionDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransactionQueryResponseDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransactionRequestDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransactionResponseDTO;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class VentasService {
    @Autowired
    PedidoBsFeignClient pedidoBsFeignClient;

    @Autowired
    ProductoBsFeignClient productoBsFeignClient;
    
    @Autowired
    ClienteBsFeignClient clienteBsFeignClient;

    @Autowired
    WebPayFeignClient webPayFeignClient;

public WebPayTransactionResponseDTO createPedidoTransaction(PedidoDTO pedidoDTO) {
    log.info("PedidoDTO: {}", pedidoDTO);
    WebPayTransactionRequestDTO webPayTransactionRequestDTO = new WebPayTransactionRequestDTO("00001",pedidoDTO.getId_pedido().toString(),pedidoDTO.getTotal().intValue(),"dsa");
    WebPayTransactionResponseDTO webPayTransactionResponseDTO = webPayFeignClient.generateTransaction("597055555532", "579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C", webPayTransactionRequestDTO);
    return webPayTransactionResponseDTO;
}

public WebPayTransactionQueryResponseDTO confirmPedidoTransaction(WebPayTransacionDTO webPayTransacionDTO) {
    WebPayTransactionQueryResponseDTO response = webPayFeignClient.queryTransaction("597055555532","579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C",webPayTransacionDTO.getToken());
    log.info("confirmPedidoTransaction: {}", response);
    return response;
}

public WebPayTransactionQueryResponseDTO queryPedidoTransaction(WebPayTransacionDTO webPayTransacionDTO) {
    WebPayTransactionQueryResponseDTO response = webPayFeignClient.queryTransaction("597055555532","579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C",webPayTransacionDTO.getToken());
    log.info("queryPedidoTransaction: {}", response);
    return response;
}
    public PedidoDTO findPedidoById(Long id) {
        PedidoDTO pedidoDTO = pedidoBsFeignClient.findPedidoById(id).getBody();

        if (pedidoDTO.getCliente_id() != null && pedidoDTO.getCliente() == null) {
            ClienteDTO cliente = clienteBsFeignClient.findClienteById(pedidoDTO.getCliente_id()).getBody();
            pedidoDTO.setCliente(cliente);
        }
        if (pedidoDTO.getDetalles() != null) {
            for (DetallePedidoDTO detalle : pedidoDTO.getDetalles()) {
                if (detalle.getProducto() == null && detalle.getProducto_id() != null) {
                    ProductoDTO productoCompleto = productoBsFeignClient.findProductById(detalle.getProducto_id()).getBody();
                    detalle.setProducto(productoCompleto);
                }
            }
        }

        return pedidoDTO;
    }

    public PedidoDTO insertPedido(PedidoDTO pedidoDTO) {
    PedidoDTO dto = pedidoBsFeignClient.crearPedido(pedidoDTO).getBody();

    for (DetallePedidoDTO detallePedidoDTO : dto.getDetalles()) {
        Long productoId = detallePedidoDTO.getProducto().getIdProducto();
        ProductoDTO producto = productoBsFeignClient.findProductById(productoId).getBody();
        detallePedidoDTO.setProducto(producto);
    }

    return dto;
}
}
