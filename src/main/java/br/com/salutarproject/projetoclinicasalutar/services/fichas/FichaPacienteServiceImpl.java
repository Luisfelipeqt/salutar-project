package br.com.salutarproject.projetoclinicasalutar.services.fichas;

import br.com.salutarproject.projetoclinicasalutar.entities.FichaPaciente;
import br.com.salutarproject.projetoclinicasalutar.repositories.FichaPacienteRepository;
import br.com.salutarproject.projetoclinicasalutar.services.exceptions.FichaNotFoundExpcetion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FichaPacienteServiceImpl implements IFichaPacienteService{

    private final FichaPacienteRepository fichaPacienteRepository;


    @Override
    public FichaPaciente cadastrar(FichaPaciente novaFicha) {

        novaFicha.setUuid(UUID.randomUUID().toString());
        novaFicha.setAtivo(1);

        return fichaPacienteRepository.save(novaFicha);
    }

    @Override
    public FichaPaciente alterar(FichaPaciente alterarFicha) {
        var tmp = fichaPacienteRepository.findById(alterarFicha.getId()).orElse(null);
        if(tmp != null) {
            if (alterarFicha.getAtivo() != null) {
                tmp.setAtivo(alterarFicha.getAtivo());
            }
            return fichaPacienteRepository.save(alterarFicha);
        }
        return null;
    }

    @Override
    public List<FichaPaciente> buscarPorNome(String nome) {
        return fichaPacienteRepository.findByNomePacienteContaining(nome);
    }

    @Override
    public FichaPaciente recuperarPeloId(Long id) {
        return fichaPacienteRepository.findById(id).orElseThrow(() -> new FichaNotFoundExpcetion("Ficha não encontrada!"));
    }

    @Override
    public boolean excluir(Long id) {
        var ficha = recuperarPeloId(id);
        if(ficha != null){
            ficha.setAtivo(0);
            fichaPacienteRepository.save(ficha);
            return true;
        }
        return false;
    }
}
