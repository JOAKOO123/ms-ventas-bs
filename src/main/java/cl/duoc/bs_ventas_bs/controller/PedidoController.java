package cl.duoc.bs_ventas_bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.bs_ventas_bs.model.dto.PedidoDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransacionDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransactionQueryResponseDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransactionResponseDTO;
import cl.duoc.bs_ventas_bs.service.VentasService;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pedidos")
@Log4j2
@Tag(name = "Pedidos", description = "API para gestionar pedidos y transacciones WebPay")
public class PedidoController {

    @Autowired
    private VentasService ventasService;

    @Operation(summary = "Obtiene un pedido por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findPedidoById(@PathVariable("id") Long id) {
        PedidoDTO pedidoDTO = ventasService.findPedidoById(id);
        if (pedidoDTO != null) {
            return ResponseEntity.ok(pedidoDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Crea una transacción de pedido para WebPay")
    @PostMapping("/sas")
    public ResponseEntity<WebPayTransactionResponseDTO> createPedidoTransaction(@RequestBody PedidoDTO pedidoDTO) {
        log.info("Creando transacción para pedido: {}", pedidoDTO);
        WebPayTransactionResponseDTO response = ventasService.createPedidoTransaction(pedidoDTO);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Confirma una transacción WebPay")
    @PostMapping("/webpay/confirm")
    public ResponseEntity<WebPayTransactionQueryResponseDTO> confirmWebPayTransaction(@RequestBody WebPayTransacionDTO webPayTransacionDTO) {
        WebPayTransactionQueryResponseDTO result = ventasService.confirmPedidoTransaction(webPayTransacionDTO);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Consulta una transacción WebPay")
    @PostMapping("/webpay/query")
    public ResponseEntity<WebPayTransactionQueryResponseDTO> queryWebPayTransaction(@RequestBody WebPayTransacionDTO webPayTransacionDTO) {
        WebPayTransactionQueryResponseDTO result = ventasService.queryPedidoTransaction(webPayTransacionDTO);
        return ResponseEntity.ok(result);
    }
}
