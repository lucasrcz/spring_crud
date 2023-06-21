package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroMedico dados, UriComponentsBuilder uriBuilder){
        Medico medico = new Medico(dados);
        repository.save(medico) ;//Transforma o DTO em Repository
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri(); // Gera caminho uri

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico)); //Retorna código 201 e retorna DTO de detalhes da criação
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao){
        Page<DadosListagemMedicos> page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new); //ResponseEntity recebe objetos de páginas
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) throws Exception {
        Medico medico = repository.findById(dados.getId()).orElseThrow(() -> new Exception("Não encontrei um Médico"));
        medico.AtualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    
    @DeleteMapping("/{id}")
    @Transactional  //Exclusão lógica
    public ResponseEntity desativar(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);
        medico.desativar();

        return ResponseEntity.noContent().build();
    }
    //Exclusão física (os dados são apagados do database)
    //public void excluir(@PathVariable Long id){
        //repository.deleteById(id);

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);


        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    
}
