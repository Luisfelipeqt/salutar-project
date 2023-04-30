package br.com.salutarproject.projetoclinicasalutar.controllers;

import br.com.salutarproject.projetoclinicasalutar.entities.Midia;
import br.com.salutarproject.projetoclinicasalutar.services.midias.IMidiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MidiaController {

    private final IMidiaService midiaService;


    @GetMapping("/midias")
    public List<Midia> findAll() {

        return midiaService.recuperarTodos();
    }

    @GetMapping("/midias/{id}")
    public ResponseEntity<Midia> recuperarPeloId(@PathVariable Long id){
        var media = midiaService.recuperarPeloId(id);
        if (media != null){
            return ResponseEntity.ok(media);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("midias")
    public ResponseEntity<Midia> adicionarNovaMedia(@RequestBody Midia midia){
        var novaMedia = midiaService.cadastrarNova(midia);
        if( novaMedia != null){
            return ResponseEntity.status(201).body(novaMedia);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/midias/{id}")
    public ResponseEntity<Midia> alterarDados(@RequestBody Midia midia, @PathVariable Long id){
        if(midia.getNumSeq() == null){
            midia.setNumSeq(id);
        }
        var alterada = midiaService.alterarDados(midia);
        if (alterada != null) {
            return ResponseEntity.ok(alterada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/midias/{id}")
    public ResponseEntity<?> excluirMidia(@PathVariable Long id){
        if(midiaService.excluirMidia(id)){
            return ResponseEntity.ok("Ok");
        }
        return ResponseEntity.noContent().build();

    }
}
