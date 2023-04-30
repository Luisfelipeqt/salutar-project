package br.com.salutarproject.projetoclinicasalutar.services.usuarios;

import br.com.salutarproject.projetoclinicasalutar.config.security.SalutarToken;
import br.com.salutarproject.projetoclinicasalutar.entities.Usuario;

public interface IAuthService {
    Usuario criarUsuario(Usuario usuario);
    SalutarToken realizarLogin(Usuario dadosLogin);
}
