package cl.duoc.bs_ventas_bs.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "DTO que representa un pedido realizado por un cliente, incluyendo sus detalles")
public class PedidoDTO {

    @Schema(description = "ID único del pedido", example = "2001")
    private Long id_pedido;

    @Schema(description = "ID del cliente que realizó el pedido", example = "15")
    private Long cliente_id;

    @Schema(description = "Datos del cliente asociado al pedido")
    private ClienteDTO cliente;

    @Schema(description = "Fecha en que se realizó el pedido", example = "2025-07-05")
    private String fecha;

    @Schema(description = "Estado actual del pedido", example = "PENDIENTE")
    private String estado;

    @Schema(description = "Monto total del pedido", example = "29980.00")
    private BigDecimal total;

    @Schema(description = "ID del descuento aplicado (si existe)", example = "3")
    private Integer descuento_id;

    @Schema(description = "Lista de detalles asociados al pedido")
    private List<DetallePedidoDTO> detalles;
}
