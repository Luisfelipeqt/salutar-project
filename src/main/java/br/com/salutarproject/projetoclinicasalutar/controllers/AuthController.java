package br.com.salutarproject.projetoclinicasalutar.controllers;

import br.com.salutarproject.projetoclinicasalutar.config.security.SalutarToken;
import br.com.salutarproject.projetoclinicasalutar.entities.Usuario;
import br.com.salutarproject.projetoclinicasalutar.repositories.UsuarioRepository;
import br.com.salutarproject.projetoclinicasalutar.services.usuarios.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    private final UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> adicionarNovo(@RequestBody Usuario usuario) {
        var criarUsuario = authService.criarUsuario(usuario);
        if(criarUsuario != null) {
            return ResponseEntity.status(201).body(criarUsuario);
        }
        return ResponseEntity.badRequest().build(); //(400)
    }

    @PostMapping("/login")
    public ResponseEntity<SalutarToken> efetuarLogin(@RequestBody Usuario usuario) {
        SalutarToken token = authService.realizarLogin(usuario);
        if(token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }
}
