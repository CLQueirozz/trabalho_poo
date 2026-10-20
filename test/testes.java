package test;

        
import model.Artigo;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import service.Biblioteca;
import exception.UsuarioNaoEncontradoException;
import exception.MaterialNaoEncontradoException;
import exception.MultaInexistenteException;
import exception.MaterialIndisponiveException;


import java.util.Scanner;


public class testes {
       public static void main (String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Usuario thais = new Usuario ("Thais Lindquist", "0879", "thaislindquist@gmail");
        Livro livro_thais = biblioteca.buscarLivroPorTitulo("1984");
        Emprestimo emprestimo = new Emprestimo(thais,livro_thais, "2026-06-06", "2026-06-14");
        biblioteca.registrarEmprestimoLivro(thais, emprestimo);
        System.out.println("Material atrasado? " + emprestimo.isAtrasado());
        try{
                biblioteca.registrarDevolucao(thais);
        }catch (IllegalStateException e) {
                System.out.println("Erro:"+ e.getMessage());
        }
        
        



       }
}