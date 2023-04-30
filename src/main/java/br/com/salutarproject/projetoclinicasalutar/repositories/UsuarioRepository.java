package br.com.salutarproject.projetoclinicasalutar.repositories;

import br.com.salutarproject.projetoclinicasalutar.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}
