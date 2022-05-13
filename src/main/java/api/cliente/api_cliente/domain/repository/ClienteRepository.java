package api.cliente.api_cliente.domain.repository;

import api.cliente.api_cliente.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ClienteRepository extends JpaRepository<Cliente,Long>  {

    // @Query("SELECT u FROM User u WHERE u.login = ?1 and u.senha = ?2")
    // User findUserByLoginAndPassword(String login, String password);

}
