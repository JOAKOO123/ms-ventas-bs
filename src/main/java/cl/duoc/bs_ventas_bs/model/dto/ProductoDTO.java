package cl.duoc.bs_ventas_bs.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Schema(description = "DTO que representa un perfume disponible en el catálogo de productos")
public class ProductoDTO {

    @Schema(description = "ID único del perfume", example = "101")
    private Long idProducto;

    @Schema(description = "Nombre del perfume", example = "Dior Sauvage")
    private String nombre;

    @Schema(description = "Descripción del perfume", example = "Fragancia fresca con notas de bergamota y ambroxan")
    private String descripcion;

    @Schema(description = "Precio del perfume", example = "69990.00")
    private BigDecimal precio;

    @Schema(description = "Cantidad de unidades disponibles en stock", example = "15")
    private Integer stock;

    @Schema(description = "Información del proveedor del perfume")
    private ProveedorDTO proveedor;
}

