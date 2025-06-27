package cl.duoc.bs_ventas_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.bs_ventas_bs.model.dto.ProductoDTO;

@FeignClient(name = "ms-producto-bs-svc", url = "http://192.168.1.13:8281")

public interface ProductoBsFeignClient {

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoDTO> findProductById(@PathVariable("id") Long id);


}