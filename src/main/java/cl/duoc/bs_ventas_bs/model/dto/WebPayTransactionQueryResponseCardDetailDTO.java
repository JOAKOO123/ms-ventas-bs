package cl.duoc.bs_ventas_bs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Schema(description = "Detalle de la tarjeta en la respuesta de consulta WebPayTransaction")
public class WebPayTransactionQueryResponseCardDetailDTO {

    @JsonProperty("card_number")
    @Schema(description = "Número de la tarjeta", example = "1234-5678-9012-3456")
    private String cardNumber;

}


