package br.com.salutarproject.projetoclinicasalutar;

import br.com.salutarproject.projetoclinicasalutar.entities.FichaPaciente;
import br.com.salutarproject.projetoclinicasalutar.services.FichaPacienteServiceImpl;
import br.com.salutarproject.projetoclinicasalutar.services.IFichaPacienteService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class FichaTests {

    @Autowired
    FichaPacienteServiceImpl fichaPacienteService;

    @Test
    void shouldCreateFicha(){
        var sut = new FichaPaciente();
        sut.setNomePaciente("Luis Felipe Rodrigues");
        var res = fichaPacienteService.cadastrar(sut);
        assertTrue(res != null && res.getUuid() != null && res.getAtivo() == 1);
    }
}
