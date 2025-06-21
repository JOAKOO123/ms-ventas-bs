package cl.duoc.bs_ventas_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.bs_ventas_bs.model.dto.ClienteDTO;

@FeignClient(name = "ms-cliente-bs-svc", url = "http://localhost:8081")
public interface ClienteBsFeignClient {
    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteDTO> findClienteById(@PathVariable("id") Long id);

}
