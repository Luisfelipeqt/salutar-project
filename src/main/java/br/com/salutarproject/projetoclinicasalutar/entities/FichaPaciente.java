package br.com.salutarproject.projetoclinicasalutar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_ficha_paciente")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FichaPaciente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @ToString.Include
    @Column(name = "id_ficha")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100)
    private String nomePaciente;

    @Column(name = "data_nasc")
    private LocalDate dataNascimento;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "numero_complemento", length = 45)
    private String numeroComplemento;

    @Column(name = "cidade", length = 45)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "ocupacao", length = 45)
    private String ocupacao;

    @Column(name = "diagnostico_clinico", columnDefinition = "TEXT")
    private String diagnosticoClinico;

    @Column(name = "queixa_principal", columnDefinition = "TEXT")
    private String queixaPrincipal;

    @Column(name = "hmp_hma", columnDefinition = "TEXT")
    private String hmpHma;

    @Column(name = "medicacoes", columnDefinition = "TEXT")
    private String medicacoes;

    @Column(name = "exames_complementares", columnDefinition = "TEXT")
    private String examesComplementares;

    @Column(name = "exame_fisico", columnDefinition = "TEXT")
    private String exameFisico;

    @Column(name = "conduta_clinica", columnDefinition = "TEXT")
    private String condutaClinica;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "uuid", length = 45)
    private String uuid;

    @Column(name = "link_foto", length = 255)
    private String linkFoto;

    @Column(name = "ativo")
    private Integer ativo;


}
