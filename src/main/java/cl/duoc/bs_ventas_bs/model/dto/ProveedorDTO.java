package cl.duoc.bs_ventas_bs.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@ToString
@Schema(description = "DTO que representa un proveedor de perfumes")
public class ProveedorDTO {

    @Schema(description = "ID único del proveedor", example = "1")
    private Integer idProveedor;

    @Schema(description = "Nombre del proveedor", example = "Distribuidora Fragancias Chile")
    private String nombre;

    @Schema(description = "Correo electrónico de contacto del proveedor", example = "contacto@fraganciaschile.cl")
    private String email;

    @Schema(description = "Número de teléfono del proveedor", example = "+56987654321")
    private String telefono;
}
