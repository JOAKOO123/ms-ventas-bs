package cl.duoc.bs_ventas_bs.model.dto;



import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PedidoDTO {
    
    @JsonProperty(value="id")
    private Long id;
    @JsonProperty(value="cliente_id")
    private ClienteDTO clienteId;
    @JsonProperty(value="fecha")
    private String fecha;
    @JsonProperty(value="estado")
    private String estado;
    @JsonProperty(value="total")
    private BigDecimal total;
    @JsonProperty(value="decuento_id")
    private Integer descuentoId;
    @JsonProperty(value="detalles")
    private List<DetallePedidoDTO> detalles;
}
