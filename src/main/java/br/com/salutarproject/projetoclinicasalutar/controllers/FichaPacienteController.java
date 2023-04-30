package br.com.salutarproject.projetoclinicasalutar.controllers;

import br.com.salutarproject.projetoclinicasalutar.entities.FichaPaciente;
import br.com.salutarproject.projetoclinicasalutar.services.fichas.IFichaPacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FichaPacienteController {

    private final IFichaPacienteService fichaPacienteService;

    @GetMapping("/fichas/busca")
    public ResponseEntity<List<FichaPaciente>> recuperarPeloNome(@RequestParam(name = "nome") String nome){
        List<FichaPaciente> fichaPacienteList = fichaPacienteService.buscarPorNome(nome);
        if(fichaPacienteList.size() > 0 ){
            return ResponseEntity.ok(fichaPacienteList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/fichas")
    public ResponseEntity<FichaPaciente> cadastrarNovaFicha(@RequestBody FichaPaciente fichaPaciente) throws URISyntaxException {
        var res = fichaPacienteService.cadastrar(fichaPaciente);
        if(res != null) {
            return ResponseEntity.created(new URI("/fichas/" + res.getId())).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> buscarPeloId(@PathVariable Long id){
        FichaPaciente res = fichaPacienteService.recuperarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> alterarFicha(@RequestBody FichaPaciente fichaPaciente,
                                                      @PathVariable Long id){
        if (fichaPaciente.getId() == null) {
            fichaPaciente.setId(id);
        }
        FichaPaciente res = fichaPacienteService.alterar(fichaPaciente);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/fichas/{id}")
    public ResponseEntity<FichaPaciente> deletarFicha(@PathVariable Long id){
        boolean res = fichaPacienteService.excluir(id);
        if(res) {
            return ResponseEntity.ok(fichaPacienteService.recuperarPeloId(id));
        }
        return ResponseEntity.notFound().build();
    }
}
