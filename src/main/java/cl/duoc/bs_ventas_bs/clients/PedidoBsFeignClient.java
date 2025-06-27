package cl.duoc.bs_ventas_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.duoc.bs_ventas_bs.model.dto.PedidoDTO;

@FeignClient(name = "ms-pedido-bd", url = "http://localhost:8180")
public interface PedidoBsFeignClient {

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDTO> findPedidoById(@PathVariable("id") Long id);

    @PostMapping("/pedidos")
    public HttpEntity<PedidoDTO> crearPedido(@RequestBody PedidoDTO pedidoDTO);

}
