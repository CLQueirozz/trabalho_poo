package model;

public class Emprestimo {
    private Usuario usuario;
    private MateriaBiblioteca materia;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean atrasado;
    private boolean devolvido;


    public Emprestimo(Usuario usuario, MateriaBiblioteca materia, String dataEmprestimo, String dataDevolucao) {
        this.usuario = usuario;
        this.materia = materia;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.atrasado = false;
        this.devolvido = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MateriaBiblioteca getMateria() {
        return materia;
    }

    public void setMateria(MateriaBiblioteca materia) {
        this.materia = materia;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtrasado() {
        if(this.dataDevolucao.compareTo(java.time.LocalDate.now().toString()) < 0 && !this.devolvido) {
            this.atrasado = true;
        }
        return atrasado;
    }

    public void setAtrasado(boolean atrasado) {
        this.atrasado = atrasado;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
