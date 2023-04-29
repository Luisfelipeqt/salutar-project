package br.com.salutarproject.projetoclinicasalutar.services;

import br.com.salutarproject.projetoclinicasalutar.entities.FichaPaciente;

import java.util.List;

public interface IFichaPacienteService {

    FichaPaciente cadastrar(FichaPaciente novaFicha);
    FichaPaciente alterar(FichaPaciente alterarFicha);
    List<FichaPaciente> buscarPorNome(String nome);
    FichaPaciente recuperarPeloId(Long id);
    boolean excluir(Long id);

}
