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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

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
    @CPF(message = "cpf inválido")
    String cpf;
    @Column(name="nome")
    @NotBlank(message = "nome é obrigatório")
    //@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$")
    @Length(message="nome com no máximo 50 caracteres",max=50)
    String nome;
    @Column(name="sexo")
    @NotBlank(message = "sexo é obrigatório")
    @Pattern(regexp = "^(?:m|M|F|f)$", message = "caractere invalido para sexo")
    @Length(message="sexo precisa ser M ou F",max=1)
    String sexo;
    @Column(name="datanascimento")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone = "EST")
    @Temporal(TemporalType.DATE)
    Date datanascimento;
}
