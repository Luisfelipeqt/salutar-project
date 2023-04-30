package br.com.salutarproject.projetoclinicasalutar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_midia")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Midia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ToString.Include
    @Column(name = "num_seq")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSeq;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "link_midia", length = 255)
    private String linkMidia;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private FichaPaciente fichaPaciente;
}
