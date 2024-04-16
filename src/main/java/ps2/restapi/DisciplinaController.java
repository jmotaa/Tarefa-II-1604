package ps2.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DisciplinaController {

	private List<Disciplina> lista;

	public DisciplinaController() {
		this.lista = new ArrayList<>();
		lista.add(new Disciplina(1, "Linguagem de Programação 2", "LP2", "Sistemas de Informação", 3));
	}

	@GetMapping("/api/lista")
	Iterable<Professor> getDisciplina() {
		return this.lista;
	}
	
	@GetMapping("/api/lista/{id}")
	Optional<Disciplina> getADisciplina(@PathVariable long id) {
		for (Disciplina d: lista) {
			if (p.getId() == id) {
				return Optional.of(d);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/lista")
	Professor createDisciplina(@RequestBody Disciplina d) {
		long maxId = 1;
		for (Disciplina di: lista) {
			if (di.getId() > maxId) {
				maxId = di.getId();
			}
		}
		d.setId(maxId+1);
		lista.add(d);
		return d;
	}
	
	@PutMapping("/api/lista/{diId}")
	Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long diId) {
		Optional<Disciplina> opt = this.getDisciplina(diId);
		if (opt.isPresent()) {
			Disciplina disciplina = opt.get();
			disciplina.setNome(novaDisciplina.getNome());
            disciplina.setSigla(novaDisciplina.getSigla());
            disciplina.setCurso(novaDisciplina.getCurso());
            disciplina.setSemestre(novaDisciplina.getSemestre());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/professores/{id}")
	void deleteProfessor(@PathVariable long id) {
		professores.removeIf(p -> p.getId() == id);
	}		
}