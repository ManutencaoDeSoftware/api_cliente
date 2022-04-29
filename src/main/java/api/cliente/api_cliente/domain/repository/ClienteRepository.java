package api.cliente.api_cliente.domain.repository;

import api.cliente.api_cliente.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ClienteRepository extends JpaRepository<Cliente,Long>  {

    @Query("SELECT u FROM Cliente u WHERE u.cpf = ?1")
    Cliente findClienteByCpf(String cpf);

}
