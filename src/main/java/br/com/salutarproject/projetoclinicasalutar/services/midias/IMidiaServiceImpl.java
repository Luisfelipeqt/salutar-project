package br.com.salutarproject.projetoclinicasalutar.services.midias;

import br.com.salutarproject.projetoclinicasalutar.entities.Midia;
import br.com.salutarproject.projetoclinicasalutar.repositories.MidiaRepository;
import br.com.salutarproject.projetoclinicasalutar.services.exceptions.MidiaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IMidiaServiceImpl implements IMidiaService{

    private MidiaRepository midiaRepository;


    @Override
    public Midia cadastrarNova(Midia midia) {
        return midiaRepository.save(midia);
    }

    @Override
    public Midia alterarDados(Midia midia) {
        return midiaRepository.save(midia);
    }

    @Override
    public boolean excluirMidia(Long id) {
        if(midiaRepository.existsById(id)) {
            midiaRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Midia recuperarPeloId(Long id) {
        return midiaRepository.findById(id).orElseThrow(() -> new MidiaNotFoundException("Midia não encontrada!"));
    }

    @Override
    public List<Midia> recuperarTodos() {
        return midiaRepository.findAll();
    }
}
