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
public class DisciplinaController {

    private List<Disciplina> list;

    public DisciplinaController() {
        this.list = new ArrayList<>();
        // Corrigindo a chamada ao construtor com parâmetros corretos
        this.list.add(new Disciplina(1, "Linguagem de Programação 2", "LP2", "Sistemas de Informação", 3));
    }

    // GET: Retorna todas as disciplinas
    @GetMapping
    public List<Disciplina> getAllDisciplinas() {
        return list;
    }

    // GET: Retorna uma disciplina pelo ID
    @GetMapping("/{id}")
    public Disciplina getDisciplinaById(@PathVariable int id) {
        return list.stream()
                   .filter(d -> d.getId() == id)
                   .findFirst()
                   .orElse(null);
    }

    // POST: Adiciona uma nova disciplina
    @PostMapping
    public void addDisciplina(@RequestBody Disciplina disciplina) {
        list.add(disciplina);
    }

    // PUT: Atualiza uma disciplina existente pelo ID
    @PutMapping("/{id}")
    public void updateDisciplina(@PathVariable int id, @RequestBody Disciplina novaDisciplina) {
        Disciplina disciplina = getDisciplinaById(id);
        if (disciplina != null) {
            disciplina.setNome(novaDisciplina.getNome());
            disciplina.setSigla(novaDisciplina.getSigla());
            disciplina.setCurso(novaDisciplina.getCurso());
            disciplina.setSemestre(novaDisciplina.getSemestre());
        }
    }

    // DELETE: Remove uma disciplina pelo ID
    @DeleteMapping("/{id}")
    public void deleteDisciplina(@PathVariable int id) {
        list.removeIf(d -> d.getId() == id);
    }
}
