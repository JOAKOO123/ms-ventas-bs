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
@Schema(description = "Respuesta de la transacción WebPay")
public class WebPayTransactionResponseDTO {

    @Schema(description = "Token único de la transacción", example = "abc123tokenxyz")
    private String token;

    @Schema(description = "URL para redirigir al usuario a la pasarela de pago", example = "https://webpay.example.com/pay/abc123tokenxyz")
    private String url;

}

