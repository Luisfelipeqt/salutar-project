package br.com.salutarproject.projetoclinicasalutar.repositories;

import br.com.salutarproject.projetoclinicasalutar.entities.FichaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichaPacienteRepository extends JpaRepository<FichaPaciente, Long> {
    List<FichaPaciente> findByNomePacienteContaining(String palavraChave);
}
