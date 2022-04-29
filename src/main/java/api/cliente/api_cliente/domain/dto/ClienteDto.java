package api.cliente.api_cliente.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    Long id;
    String cpf;
    String nome;
    String sexo;
    Date dataNascimento;  
}
