package ps2.restapi;

public class Disciplina {
    private int id;
    private String nome;
    private String sigla;
    private String curso;
    private int semestre;

    public Disciplina{}{}
    public Disciplina(int id, String nome, String sigla, String curso, int semestre) {
        this.id = id;
        this.nome = nome;
        this.semestre = semestre;
        this.sigla = sigla;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getSemestre() {
        return semestre;
    }
    public void SetSemestre(int semestre) {
        this.semestre = semestre;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
