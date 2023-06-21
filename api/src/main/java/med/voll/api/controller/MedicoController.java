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


@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroMedico dados){
        repository.save(new Medico(dados)) ;//Transforma o DTO em Repository
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao){
        Page<DadosListagemMedicos> page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
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
}
