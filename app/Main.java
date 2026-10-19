package app;

import model.Artigo;
import model.Livro;
import model.Usuario;
import service.Biblioteca;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao = 0;

        while (opcao != 7) {
                        System.out.println("\nBem-vindo à Biblioteca!");
                System.out.println("Escolha uma opção:");
                System.out.println("1. Buscar livro por título");
                System.out.println("2. Buscar artigo por título");
                System.out.println("3. Cadastrar novo livro");
                System.out.println("4. Cadastrar novo artigo");
                System.out.println("5. Cadastrar novo usuário");
                System.out.println("6. Registrar devolução");
                System.out.println("7. Sair");

                

        try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                case 1: {
                        System.out.print("Digite o título do livro: ");
                        String tituloLivro = scanner.nextLine();

                        Livro livro =
                                biblioteca.buscarLivroPorTitulo(tituloLivro);

                        if (livro != null) {
                                if (livro.isDisponibilidade()) {
                                System.out.println("Livro encontrado: "+ livro.getTitulo()+ " - Disponível para empréstimo.");
                        } else {
                                System.out.println( "Livro encontrado: "+ livro.getTitulo()+ " - Indisponível para empréstimo."
                                );
                        }
                        } else {
                                System.out.println("Livro não encontrado.");
                        }

                        break;
                }

                case 2: {
                        System.out.print("Digite o título do artigo: ");
                        String tituloArtigo = scanner.nextLine();

                        Artigo artigo =
                                biblioteca.buscarArtigoPorTitulo(tituloArtigo);

                        if (artigo != null) {
                                if (artigo.isDisponibilidade()) {
                                        System.out.println("Artigo encontrado: "+ artigo.getTitulo()+ " - Disponível para empréstimo."
                                );
                        } else {
                                System.out.println( "Artigo encontrado: "+ artigo.getTitulo()+ " - Indisponível para empréstimo."
                                );
                        }
                        } else {
                                System.out.println("Artigo não encontrado.");
                        }

                        break;
                }

                case 3: {
                        System.out.print("Digite o título do livro: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Digite o código do livro: ");
                        int codigo = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o autor do livro: ");
                        String autor = scanner.nextLine();

                        System.out.print("Digite a editora do livro: ");
                        String editora = scanner.nextLine();

                        System.out.print("Digite o ISBN do livro: ");
                        String isbn = scanner.nextLine();

                        Livro novoLivro = new Livro(titulo, codigo, true, autor, editora, isbn);

                        biblioteca.CadastrarLivro(novoLivro);

                        System.out.println("Livro cadastrado com sucesso.");
                        break;
                }

                case 4: {
                        System.out.print("Digite o título do artigo: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Digite o código do artigo: ");
                        int codigo = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o autor do artigo: ");
                        String autor = scanner.nextLine();

                        System.out.print("Digite o jornal no qual o artigo foi publicado: ");
                        String jornal = scanner.nextLine();

                        System.out.print("Digite o ano do artigo: ");
                        int ano = Integer.parseInt(scanner.nextLine());

                        Artigo novoArtigo = new Artigo(titulo, codigo, true, autor, jornal, ano);

                        biblioteca.CadastrarArtigo(novoArtigo);

                        System.out.println("Artigo cadastrado com sucesso.");
                        break;
                }

                case 5: {
                        System.out.println("Digite os dados do usuário para cadastro.");

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        biblioteca.cadastrarUsuario(nome, cpf, email);

                        System.out.println("Usuário cadastrado com sucesso.");
                        break;
                }

                case 6: {
                        System.out.print("Digite a matrícula do usuário: ");
                        int matricula =Integer.parseInt(scanner.nextLine());
                        Usuario usuario =biblioteca.buscarUsuarioPorMatricula(matricula);

                        if (usuario == null) {
                                System.out.println("Usuário não encontrado.");
                                break;
                        }

                        if (usuario.getMaterialEmprestado() == null) {
                                System.out.println("O usuário não possui nenhum material emprestado.");
                                break;
                        }

                        System.out.print("Digite o título do material a ser devolvido: " );
                        String nomeMaterial = scanner.nextLine();

                        String tituloEmprestado = usuario.getMaterialEmprestado().getMateria().getTitulo();

                        if (!nomeMaterial.equalsIgnoreCase(tituloEmprestado)) {
                                System.out.println("Esse material não corresponde ao empréstimo do usuário.");
                                break;
                        }

                        biblioteca.registrarDevolucao(usuario);

                        System.out.println("Operação de devolução processada.");
                        break;
                }

                case 7:
                        System.out.println("Saindo do sistema. Até logo!");
                        break;

                default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

        } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número onde solicitado.");

        } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println( "Não foi possível realizar a operação: "+ e.getMessage());
        }
        }

        scanner.close();
}
}
