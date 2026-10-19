package model;

import java.util.ArrayList;

public class Usuario extends Pessoa {
    public ArrayList<MateriaBiblioteca> MaterialJaEmprestado;
    public Multa multa;
    public boolean pago;
    public Emprestimo MaterialEmprestado;

    private static int proximaMatricula = 1000;

    private int matricula;

    public Usuario(String nome, String cpf, String email, int matricula, Multa multa, Emprestimo MaterialEmprestado) {
        super(nome, cpf, email);
        this.matricula = proximaMatricula++;
        this.multa = multa;
        this.pago = multa.isPaga();
        this.MaterialEmprestado = MaterialEmprestado;
    }

    public Usuario(String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.matricula = proximaMatricula++;
        this.MaterialJaEmprestado = new ArrayList<>();
        this.multa = null;
        this.pago = true;
        this.MaterialEmprestado = null;
    }
    public int getMatricula() {
        return matricula;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Emprestimo getMaterialEmprestado() {
        return MaterialEmprestado;
    }
    public void setMaterialEmprestado(Emprestimo materialEmprestado) {
        this.MaterialEmprestado = materialEmprestado;
    }

    public ArrayList<MateriaBiblioteca> getMaterialJaEmprestado() {
        return MaterialJaEmprestado;
    }

    public void setMaterialJaEmprestado(Emprestimo emprestimo) {
        MaterialJaEmprestado.add(emprestimo.getMateria());
    }

    public double getValorMulta() {
        return getMulta().getValor();
    }

    public boolean isDevedor() {
        return !pago;
    }

    public void setDevedor(boolean devedor) {
        this.pago = devedor;
    }
}

