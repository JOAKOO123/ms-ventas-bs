package cl.duoc.bs_ventas_bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.bs_ventas_bs.model.dto.PedidoDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransacionDTO;
import cl.duoc.bs_ventas_bs.model.dto.WebPayTransactionQueryResponseDTO;
import cl.duoc.bs_ventas_bs.service.VentasService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    VentasService ventasService;
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findPedidoById(@PathVariable("id") Long id) {
        PedidoDTO pedidoDTO = ventasService.findPedidoById(id);
        return (pedidoDTO != null)?  new ResponseEntity<>(pedidoDTO, HttpStatus.OK) :
                                     new ResponseEntity<>(HttpStatus.NOT_FOUND);     
                                        
    }

    @PostMapping("")
public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
    PedidoDTO newPedido = ventasService.insertPedido(pedidoDTO);
    return (newPedido != null) ?
           new ResponseEntity<>(newPedido, HttpStatus.CREATED) :
           new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}

@PostMapping("/webpay/confirm")
public ResponseEntity<String> confirmWebPayTransaction(@RequestBody WebPayTransacionDTO webPayTransacionDTO) {
    String result = ventasService.confirmPedidoTransaction(webPayTransacionDTO);
    return ResponseEntity.ok(result);
}

@PostMapping("/webpay/query")
public ResponseEntity<WebPayTransactionQueryResponseDTO> queryWebPayTransaction(@RequestBody WebPayTransacionDTO webPayTransacionDTO) {
    WebPayTransactionQueryResponseDTO result = ventasService.queryPedidoTransaction(webPayTransacionDTO);
    return ResponseEntity.ok(result);
}



    

}
