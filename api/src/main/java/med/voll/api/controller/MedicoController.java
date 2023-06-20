package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import med.voll.api.medico.CadastroMedico;


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
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        Medico medico = repository.getReferenceById(dados.getId());
        medico.AtualizarInformacoes(dados);
    }

    
    @DeleteMapping("/{id}")
    @Transactional  //Exclusão lógica
    public void desativar(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);
        medico.desativar();
    }
    //Exclusão física (os dados são apagados do database)
    //public void excluir(@PathVariable Long id){
        //repository.deleteById(id);
}
