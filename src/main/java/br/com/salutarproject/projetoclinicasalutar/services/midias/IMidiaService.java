package br.com.salutarproject.projetoclinicasalutar.services.midias;

import br.com.salutarproject.projetoclinicasalutar.entities.Midia;

import java.util.List;

public interface IMidiaService {


    Midia cadastrarNova(Midia midia);
    Midia alterarDados(Midia midia);
    boolean excluirMidia(Long id);
    Midia recuperarPeloId(Long id);
    List<Midia> recuperarTodos();
}
