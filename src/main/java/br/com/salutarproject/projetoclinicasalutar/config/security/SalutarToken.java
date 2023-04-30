package br.com.salutarproject.projetoclinicasalutar.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalutarToken {

    private String token;
    private long dias_expiracao;
}
