package med.voll.api.medico;

import med.voll.api.controller.Medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

}
