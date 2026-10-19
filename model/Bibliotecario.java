package model;

public class Bibliotecario extends Pessoa {
    private int identificador;

    public Bibliotecario(String nome, String cpf, String email, int identificador) {
        super(nome, cpf, email);
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    }
