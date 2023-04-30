package br.com.salutarproject.projetoclinicasalutar.services.usuarios;

import br.com.salutarproject.projetoclinicasalutar.config.security.SalutarToken;
import br.com.salutarproject.projetoclinicasalutar.config.security.TokenUtil;
import br.com.salutarproject.projetoclinicasalutar.entities.Usuario;
import br.com.salutarproject.projetoclinicasalutar.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService{

    private final UsuarioRepository usuarioRepository;


    @Override
    public Usuario criarUsuario(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return usuarioRepository.save(usuario);
    }


    @Override
    public SalutarToken realizarLogin(Usuario dadosLogin) {

        var res = usuarioRepository.findByLogin(dadosLogin.getLogin());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(res != null) {
            if(encoder.matches(dadosLogin.getSenha(), res.getSenha())) {
                return TokenUtil.encode(res);
            }
        }
        return null;
    }

}
