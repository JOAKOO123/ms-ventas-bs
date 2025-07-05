package cl.duoc.bs_ventas_bs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration


public class SwaggerConfig {
    @Bean
  public OpenAPI apiInfo(){
        return new OpenAPI()
                   .info(new Info().title("API de ventas (ms-ventas-bs) - Perfulandia")
                                    .description("Microservicio encargado de gestionar el flujo de pedidos y la integración con el sistema de pagos Transbank (WebPay).\n" + //
                                                                                "Expone endpoints para registrar pedidos y sus detalles, así como para iniciar, confirmar y consultar transacciones de pago.\n" + //
                                                                                "Utiliza  Feignclient para comunicarse con los servicios de clientes, productos y con la API de Transbank.\n" + //
                                                                                "Gestiona el intercambio de datos mediante DTOs que encapsulan la información necesaria para los pedidos y las transacciones WebPay.")
                                    .version("1.0.0"));
    }
}