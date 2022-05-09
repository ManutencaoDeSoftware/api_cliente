package api.cliente.api_cliente.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="cep")
    @NotBlank(message = "cep é obrigatório")
    @Length(message="cep com no máximo 8 caracteres",max=8)
    String cep;
    @Column(name="rua")
    @NotBlank(message = "rua é obrigatório")
    @Length(message="rua com no máximo 50 caracteres",max=50)
    String rua;
    @Column(name="bairro")
    @NotBlank(message = "bairro é obrigatório")
    @Length(message="bairro com no máximo 50 caracteres",max=50)
    String bairro;
    @Column(name="numero")
    @NotNull(message = "numero é obrigatório")
    int numero;
    @Column(name="cidade")
    @NotBlank(message = "cidade é obrigatório")
    @Length(message="cidade com no máximo 50 caracteres",max=50)
    String cidade;
    @Column(name="uf")
    @NotBlank(message = "uf é obrigatório")
    @Length(message="uf com no máximo 2 caracteres",max=2)
    String UF;
    @OneToOne(mappedBy = "endereco")
    Cliente cliente;
}
