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
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Biblioteca biblioteca = new Biblioteca();
                Usuario thais = new Usuario("Thaís Rodrigues lindquist", "0879", "thaislindquist@usp.br");
                biblioteca.cadastrarNovosUsuarios(thais);
                Livro livro_thais = biblioteca.buscarLivroPorTitulo("1984");

                public void registrar_emprestimo_atrasado(Usuario usuario, Livro livro, String DataEmprestimo, String DataDevolucao)
                {
                        Emprestimo emprestimo = new Emprestimo(usuario, livro, DataEmprestimo, DataDevolucao);
                        usuario.setMaterialEmprestado(emprestimo);
                }

                biblioteca.registrarEmprestimoLivro(thais, livro_thais);
                Usuario cecilia = new Usuario("Cecilia Luis de Queiroz", "1355", "ceciliaqueiroz@gmail.com");
                biblioteca.cadastrarNovosUsuarios(cecilia);
                Livro livro_ceci = biblioteca.buscarLivroPorTitulo("Dom Casmurro");
                biblioteca.registrarEmprestimoLivro(cecilia, livro_ceci);


        
                int opcao = 0;
        
                while (opcao != 9) {
                        System.out.println("\nBem-vindo à Biblioteca!");
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Buscar livro por título");
                        System.out.println("2. Buscar artigo por título");
                        System.out.println("3. Cadastrar novo livro");
                        System.out.println("4. Cadastrar novo artigo");
                        System.out.println("5. Cadastrar novo usuário");
                        System.out.println("6. Realizar empréstimo");
                        System.out.println("7. Registrar devolução");
                        System.out.println("8. Pagar multa");
                        System.out.println("9. Sair");
        
                        
        
                try {
                        opcao = Integer.parseInt(scanner.nextLine());
        
                        switch (opcao) {
        
                        case 1: {
                                System.out.print("Digite o título do livro: ");
                                String tituloLivro = scanner.nextLine();
        
                                Livro livro = biblioteca.buscarLivroPorTitulo(tituloLivro);
        
                                if (livro != null) {
                                        if (livro.isDisponibilidade()) {
                                        System.out.println("Livro encontrado: "+ livro.getTitulo()+ " - Disponível para empréstimo.");
                                } else {
                                        throw new MaterialIndisponiveException("Livro encontrado: "+ livro.getTitulo()+ " - Indisponível para empréstimo.");
                                }
                                } else {
                                        throw new MaterialNaoEncontradoException("Livro não encontrado.");
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
                                        throw new MaterialIndisponiveException("Artigo encontrado: "+ artigo.getTitulo()+ " - Indisponível para empréstimo."
                                        );
                                }
                                } else {
                                        throw new MaterialNaoEncontradoException("Artigo não encontrado.");
                                }
        
                                break;
                        }
        
                        case 3: {
                                System.out.print("Digite o título do livro: ");
                                String titulo = scanner.nextLine();
                                if (titulo == null || titulo.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O título do livro é obrigatório.");
                                }
        
                                System.out.print("Digite o autor do livro: ");
                                String autor = scanner.nextLine();
                                if (autor == null || autor.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O autor do livro é obrigatório.");
                                }
        
                                System.out.print("Digite a editora do livro: ");
                                String editora = scanner.nextLine();
        
                                System.out.print("Digite o ISBN do livro: ");
                                String isbn = scanner.nextLine();
        
                                Livro novoLivro = new Livro(titulo, true, autor, editora, isbn);
        
                                biblioteca.CadastrarLivro(novoLivro);
        
                                System.out.println("Livro cadastrado com sucesso.\nObrigado por contribuir com a comunidade acadêmica!");
                                break;
                        }
        
                        case 4: {
                                System.out.print("Digite o título do artigo: ");
                                String titulo = scanner.nextLine();
                                if (titulo == null || titulo.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O título do artigo é obrigatório.");
                                }
        
                                System.out.print("Digite o autor do artigo: ");
                                String autor = scanner.nextLine();
                                if (autor == null || autor.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O autor do artigo é obrigatório.");
                                }
        
                                System.out.print("Digite o jornal no qual o artigo foi publicado: ");
                                String jornal = scanner.nextLine();
        
                                System.out.print("Digite o ano do artigo: ");
                                int ano = Integer.parseInt(scanner.nextLine());
        
                                Artigo novoArtigo = new Artigo(titulo, true, autor, jornal, ano);
        
                                biblioteca.CadastrarArtigo(novoArtigo);
        
                                System.out.println("Artigo cadastrado com sucesso. \nObrigado por contribuir com a comunidade acadêmica!");
                                break;
                        }
        
                        case 5: {
                                System.out.println("Digite os dados do usuário para cadastro.");
        
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                if (nome == null || nome.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O nome do usuário é obrigatório.");
                                
                                }
        
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                if (cpf == null || cpf.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O CPF do usuário é obrigatório.");
                                }
                                if (biblioteca.buscarUsuarioPorCpf(cpf) != null) {
                                        throw new IllegalArgumentException("Usuário já cadastrado com este CPF.");
                                }
        
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                if (email == null || email.trim().isEmpty()) {
                                        throw new IllegalArgumentException("O email do usuário é obrigatório.");
                                }
        
                                biblioteca.cadastrarUsuario(nome, cpf, email);
                                Usuario usuario = biblioteca.buscarUsuarioPorCpf(cpf);
                                if (usuario == null) {
                                        throw new UsuarioNaoEncontradoException("Erro ao cadastrar usuário.");
                                }
                                System.out.println("Usuário cadastrado com sucesso. Sua matrícula é: " + usuario.getMatricula());
                                break;
                        }
                        case 6: {
                                System.out.print("Digite a matrícula do usuário: ");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                Usuario usuario = biblioteca.buscarUsuarioPorMatricula(matricula);
        
                                if (usuario == null) {
                                        throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
                                }
        
                                System.out.print("Digite o tipo de material a ser emprestado (1 para Livro, 2 para Artigo): ");
                                int tipoMaterial = Integer.parseInt(scanner.nextLine());
                                System.out.print("Digite o título do material a ser emprestado: ");
                                String nomeMaterial = scanner.nextLine();
        
                                if (tipoMaterial == 1) {
                                        Livro livro = (Livro) biblioteca.buscarLivroPorTitulo(nomeMaterial);
                                        if (livro == null) {
                                                throw new MaterialNaoEncontradoException("Livro não encontrado.");
                                        }
                                        else{
                                                if (!biblioteca.buscarLivroPorTitulo(nomeMaterial).isDisponibilidade()) {
                                                        throw new MaterialIndisponiveException("Livro encontrado: "+ biblioteca.buscarLivroPorTitulo(nomeMaterial).getTitulo()+ " - Indisponível para empréstimo.");
                                                }
                                                else{
                                                biblioteca.registrarEmprestimoLivro(usuario, livro);
                                                }
                                        }
                                } else if (tipoMaterial == 2) {
                                        Artigo artigo = (Artigo) biblioteca.buscarArtigoPorTitulo(nomeMaterial);
                                        if (artigo == null) {
                                                throw new MaterialNaoEncontradoException("Artigo não encontrado.");
                                        }
                                        else{
                                                if (!biblioteca.buscarArtigoPorTitulo(nomeMaterial).isDisponibilidade()) {
                                                        throw new MaterialIndisponiveException("Artigo encontrado: "+ biblioteca.buscarArtigoPorTitulo(nomeMaterial).getTitulo()+ " - Indisponível para empréstimo.");
                                                }
                                                else{
                                                        biblioteca.registrarEmprestimoArtigo(usuario, biblioteca.buscarArtigoPorTitulo(nomeMaterial));
                                                }
                                        }
                                } else {
                                        throw new IllegalArgumentException("Tipo de material inválido.");
                                }
        
                                System.out.println("Empréstimo realizado com sucesso.");
                                break;
                        }
                        case 7: {
                                System.out.print("Digite a matrícula do usuário: ");
                                int matricula =Integer.parseInt(scanner.nextLine());
                                Usuario usuario =biblioteca.buscarUsuarioPorMatricula(matricula);
        
                                if (usuario == null) {
                                        throw new exception.UsuarioNaoEncontradoException("Usuário não encontrado.");
                                        
                                }
        
                                if (usuario.getMaterialEmprestado() == null) {
                                        throw new MaterialNaoEncontradoException("O usuário não possui nenhum material emprestado.");
                                        
                                }
        
                                System.out.print("Digite o título do material a ser devolvido: " );
                                String nomeMaterial = scanner.nextLine();
        
                                String tituloEmprestado = usuario.getMaterialEmprestado().getMateria().getTitulo();
        
                                if (!nomeMaterial.equalsIgnoreCase(tituloEmprestado)) {
                                        throw new MaterialNaoEncontradoException("O usuário não possui este material emprestado.");
                                }
        
                                biblioteca.registrarDevolucao(usuario);
        
                                System.out.println("Operação de devolução processada.");
                                break;
                        }
        
                        case 8: {
                                System.out.print("Digite a matrícula do usuário: ");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                Usuario usuario = biblioteca.buscarUsuarioPorMatricula(matricula);
        
                                if (usuario == null) {
                                        throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
                                }
        
                                if (usuario.getMulta().getValor() == 0) {
                                        throw new MultaInexistenteException("O usuário não possui multas pendentes.");
                                }
        
                                biblioteca.pagarMulta(usuario.getMulta());
        
                                System.out.println("Multa paga com sucesso. Valor pago: R$" + usuario.getMulta());
                                break;
                        }
        
                        case 9: {
                                System.out.println("\nSaindo do sistema. Até logo!");
                                break;
                        }
        
                        default:
                                System.out.println("\nOpção inválida. Tente novamente.");
                        }
        
                } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Digite um número onde solicitado.");
                        
                } catch (MaterialNaoEncontradoException | UsuarioNaoEncontradoException | MultaInexistenteException e) {
                        System.out.println("Erro: " + e.getMessage());  
        
                }catch (IllegalStateException | IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                } catch (MaterialIndisponiveException e) {
                        System.out.println(e.getMessage());
                }
        
                
        }
        scanner.close();
        }
        }
        


    

