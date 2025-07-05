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
@Schema(description = "Respuesta de consulta de la transacción WebPay")
public class WebPayTransactionQueryResponseDTO {

    @Schema(description = "VCI de la transacción", example = "TSY")
    private String vci;

    @Schema(description = "Monto de la transacción", example = "10000")
    private int amount;

    @Schema(description = "Estado de la transacción", example = "AUTHORIZED")
    private String status;

    @JsonProperty("buy_order")
    @Schema(description = "Orden de compra", example = "123456789")
    private String buyOrder;

    @JsonProperty("session_id")
    @Schema(description = "ID de sesión", example = "session123")
    private String sessionId;

    @JsonProperty("accounting_date")
    @Schema(description = "Fecha contable", example = "2023-07-05")
    private String accountinDate;

    @JsonProperty("transaction_date")
    @Schema(description = "Fecha de la transacción", example = "2023-07-05T15:30:00Z")
    private String transactionDate;

    @JsonProperty("authorization_code")
    @Schema(description = "Código de autorización", example = "123456")
    private String authorizationCode;

    @JsonProperty("payment_type_code")
    @Schema(description = "Código del tipo de pago", example = "VN")
    private String paymentTypeCode;

    @JsonProperty("response_code")
    @Schema(description = "Código de respuesta", example = "0")
    private int responseCode;

    @JsonProperty("installments_number")
    @Schema(description = "Número de cuotas", example = "1")
    private int installmentsNumber;

    @JsonProperty("card_detail")
    @Schema(description = "Detalle de la tarjeta utilizada")
    private WebPayTransactionQueryResponseCardDetailDTO cardDetailDTO;

}

