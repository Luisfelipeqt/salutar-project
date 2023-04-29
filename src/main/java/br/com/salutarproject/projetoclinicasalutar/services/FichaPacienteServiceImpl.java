package br.com.salutarproject.projetoclinicasalutar.services;

import br.com.salutarproject.projetoclinicasalutar.entities.FichaPaciente;
import br.com.salutarproject.projetoclinicasalutar.repositories.FichaPacienteRepository;
import br.com.salutarproject.projetoclinicasalutar.services.exceptions.FichaNotFoundExpcetion;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FichaPacienteServiceImpl implements IFichaPacienteService{

    @Autowired
    private FichaPacienteRepository fichaPacienteRepository;


    @Override
    public FichaPaciente cadastrar(FichaPaciente novaFicha) {

        novaFicha.setUuid(UUID.randomUUID().toString());
        novaFicha.setAtivo(1);

        return fichaPacienteRepository.save(novaFicha);
    }

    @Override
    public FichaPaciente alterar(FichaPaciente alterarFicha) {
        return fichaPacienteRepository.save(alterarFicha);
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
