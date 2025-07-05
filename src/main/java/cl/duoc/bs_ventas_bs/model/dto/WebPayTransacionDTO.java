package cl.duoc.bs_ventas_bs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Schema(description = "DTO para la transacción WebPay")
public class WebPayTransacionDTO {
    
    @Schema(description = "Token de la transacción", example = "abc123token")
    private String token;

}
