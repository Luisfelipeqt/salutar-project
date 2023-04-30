package br.com.salutarproject.projetoclinicasalutar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuarios")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome_usuario", length = 45)
    private String nome;

    @Column(name = "login", length = 45)
    private String login;

    @Column(name = "senha", length = 100)
    private String senha;
}
