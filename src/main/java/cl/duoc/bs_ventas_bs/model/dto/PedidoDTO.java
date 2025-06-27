package cl.duoc.bs_ventas_bs.model.dto;



import java.math.BigDecimal;
import java.util.List;
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
    
    private Long id_pedido;
    private Long cliente_id;
    private ClienteDTO cliente;
    private String fecha;
    private String estado;
    private BigDecimal total;
    private Integer descuento_id;
    private List<DetallePedidoDTO> detalles;
}
