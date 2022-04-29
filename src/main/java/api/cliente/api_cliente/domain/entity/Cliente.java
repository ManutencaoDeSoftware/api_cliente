package api.cliente.api_cliente.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="cpf")
    @Length(message="Cpf com no máximo 50 caracteres",max=50)
    String cpf;
    @Column(name="nome")
    @Length(message="Nome com no máximo 50 caracteres",max=50)
    String nome;
    @Column(name="sexo")
    @Length(message="Sexo com no máximo 50 caracteres",max=50)
    String sexo;
    
    @Column(name="datanascimento")
    @Temporal(TemporalType.DATE)
    Date datanascimento;
}
