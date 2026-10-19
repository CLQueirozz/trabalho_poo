package model;

public abstract class MateriaBiblioteca {
    private String titulo;
    private int codigo;
    private boolean disponibilidade;

    public MateriaBiblioteca(String titulo, int codigo, boolean disponibilidade) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.disponibilidade = disponibilidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}