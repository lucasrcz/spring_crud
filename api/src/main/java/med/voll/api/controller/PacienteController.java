package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosAtualizacaoPaciente;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import med.voll.api.paciente.CadastroPaciente;

@RequestMapping("pacientes")
@RestController
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    
    @PostMapping
    public void cadastrar(@RequestBody @Valid CadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 15 , sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        Paciente paciente = repository.getReferenceById(dados.getId());
        paciente.AtualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    //Exclusão física (os dados são apagados do database)
    public ResponseEntity excluir(@PathVariable Long id){
    repository.deleteById(id);

    return ResponseEntity.noContent().build();
    }


}
