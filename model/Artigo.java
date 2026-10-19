package model;

public class Artigo extends MateriaBiblioteca {
    private String autor;
    private String journal;
    private int ano;

    public Artigo(String titulo, boolean disponibilidade, String autor, String journal, int ano) {
        super(titulo, disponibilidade);
        this.autor = autor;
        this.journal = journal;
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
