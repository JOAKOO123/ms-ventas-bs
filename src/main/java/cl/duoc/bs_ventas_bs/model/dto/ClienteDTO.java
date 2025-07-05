package cl.duoc.bs_ventas_bs.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Schema(description = "DTO que representa a un cliente del sistema")
public class ClienteDTO {

    @Schema(description = "ID único del cliente", example = "1")
    private Long id_cliente;

    @Schema(description = "Nombre completo del cliente", example = "Juan Azocar")
    private String nombre;

    @Schema(description = "Contraseña del cliente", example = "1234segura")
    private String contrasena;

    @Schema(description = "Dirección del cliente", example = "Av. Siempre Viva 742")
    private String direccion;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Número de teléfono del cliente", example = "+56912345678")
    private String telefono;
}
