package cl.duoc.bs_ventas_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BsVentasBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsVentasBsApplication.class, args);
	}

}
