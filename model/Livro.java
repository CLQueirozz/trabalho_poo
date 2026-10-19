package model;

public class Livro extends MateriaBiblioteca {
    private String autor;
    private String editora;
    private String ISBN;

    public Livro(String titulo, int codigo, boolean disponibilidade, String autor, String editora, String ISBN) {
        super(titulo, codigo, disponibilidade);
        this.autor = autor;
        this.editora = editora;
        this.ISBN = ISBN;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
