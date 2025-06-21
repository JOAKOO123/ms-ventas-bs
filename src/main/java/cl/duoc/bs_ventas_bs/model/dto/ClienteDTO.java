package cl.duoc.bs_ventas_bs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ClienteDTO {

    private Long id;
    private String nombre;
    private String contrasena;
    private String direccion;
    private String email;
    private String telefono;
}