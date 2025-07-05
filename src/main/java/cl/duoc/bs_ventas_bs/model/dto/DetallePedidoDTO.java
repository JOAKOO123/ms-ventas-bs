package cl.duoc.bs_ventas_bs.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "DTO que representa el detalle de un pedido")
public class DetallePedidoDTO {

    @Schema(description = "ID único del detalle de pedido", example = "101")
    private Long id;

    @Schema(description = "ID del pedido al que pertenece este detalle", example = "10")
    private Long pedido_id;

    @Schema(description = "ID del producto asociado", example = "5")
    private Long producto_id;

    @Schema(description = "Información del producto asociado")
    private ProductoDTO producto;

    @Schema(description = "Cantidad de productos en el pedido", example = "2")
    private Integer cantidad;

    @Schema(description = "Precio unitario del producto", example = "14990.00")
    private BigDecimal precio_unitario;
}

