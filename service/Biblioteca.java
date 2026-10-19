package service;
import model.Artigo;
import model.Livro;
import model.MateriaBiblioteca;
import model.Multa;
import model.Usuario;
import model.Bibliotecario;
import model.Emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Biblioteca {
    private ArrayList<MateriaBiblioteca> materiais = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();

        public Biblioteca(){
        cadastrarMateriais();
        cadastrarUsuariosIniciais();
        cadastrarBibliotecariosIniciais();
        }
    private void cadastrarMateriais() {

// Livros
materiais.add(new Livro("O Senhor dos Aneis", 1, true,
        "J.R.R. Tolkien", "HarperCollins", "9788595084759"));

materiais.add(new Livro("1984", 2, true,
        "George Orwell", "Companhia das Letras", "9788535914849"));

materiais.add(new Livro("Dom Casmurro", 3, true,
        "Machado de Assis", "Principis", "9786555520418"));

materiais.add(new Livro("O Pequeno Principe", 4, true,
        "Antoine de Saint-Exupery", "HarperCollins", "9788595081512"));

materiais.add(new Livro("Harry Potter e a Pedra Filosofal", 5, true,
        "J.K. Rowling", "Rocco", "9788532530783"));

materiais.add(new Livro("O Hobbit", 6, true,
        "J.R.R. Tolkien", "HarperCollins", "9788595084742"));

materiais.add(new Livro("Orgulho e Preconceito", 7, true,
        "Jane Austen", "Martin Claret", "9788544001820"));

materiais.add(new Livro("Crime e Castigo", 8, true,
        "Fiodor Dostoievski", "Editora 34", "9788573261630"));

materiais.add(new Livro("A Revolucao dos Bichos", 9, true,
        "George Orwell", "Companhia das Letras", "9788535909555"));

materiais.add(new Livro("Capitaes da Areia", 10, true,
        "Jorge Amado", "Companhia das Letras", "9788535914061"));

materiais.add(new Livro("Memorias Postumas de Bras Cubas", 11, true,
        "Machado de Assis", "Penguin-Companhia", "9788563560150"));

materiais.add(new Livro("A Metamorfose", 12, true,
        "Franz Kafka", "Companhia das Letras", "9788535911206"));

materiais.add(new Livro("Cem Anos de Solidao", 13, true,
        "Gabriel Garcia Marquez", "Record", "9788501012074"));

materiais.add(new Livro("A Hora da Estrela", 14, true,
        "Clarice Lispector", "Rocco", "9788532528546"));

materiais.add(new Livro("Grande Sertao: Veredas", 15, true,
        "Joao Guimaraes Rosa", "Companhia das Letras", "9788535925692"));

materiais.add(new Livro("Frankenstein", 16, true,
        "Mary Shelley", "DarkSide Books", "9788566636112"));

materiais.add(new Livro("Dracula", 17, true,
        "Bram Stoker", "DarkSide Books", "9788566636341"));

materiais.add(new Livro("A Divina Comedia", 18, true,
        "Dante Alighieri", "Editora 34", "9788573261487"));

materiais.add(new Livro("Sapiens", 19, true,
        "Yuval Noah Harari", "Companhia das Letras", "9788525432186"));

materiais.add(new Livro("Duna", 20, true,
        "Frank Herbert", "Aleph", "9788576573138"));


// Artigos
materiais.add(new Artigo("A Teoria da Relatividade", 21, true,
        "Albert Einstein", "Annalen der Physik", 1905));

materiais.add(new Artigo("On the Electrodynamics of Moving Bodies", 22, true,
        "Albert Einstein", "Annalen der Physik", 1905));

materiais.add(new Artigo("The Structure of DNA", 23, true,
        "James D. Watson e Francis H. C. Crick",
        "Nature", 1953));

materiais.add(new Artigo("Induced Radioactivity", 24, true,
        "Irene Joliot-Curie e Frederic Joliot",
        "Nature", 1934));

materiais.add(new Artigo("A Mathematical Theory of Communication", 25, true,
        "Claude E. Shannon", "Bell System Technical Journal", 1948));
}


private void cadastrarUsuariosIniciais() {
        usuarios.add(new Usuario(
                "Ana Silva",
                "12345678901",
                "ana.silva@email.com"
        ));
    usuarios.add(new Usuario(
                "Bruno Santos",
                "23456789012",
                "bruno.santos@email.com"
        ));
    
        usuarios.add(new Usuario(
                "Carolina Oliveira",
                "34567890123",
                "carolina.oliveira@email.com"
        ));
    
        usuarios.add(new Usuario(
                "Daniel Costa",
                "45678901234",
                "daniel.costa@email.com"
        ));
    
        usuarios.add(new Usuario(
                "Eduarda Martins",
                "56789012345",
                "eduarda.martins@email.com"
        ));
    
        usuarios.add(new Usuario(
                "Felipe Almeida",
                "67890123456",
                "felipe.almeida@email.com"
        ));
    
        usuarios.add(new Usuario(
                "Gabriela Souza",
                "78901234567",
                "gabriela.souza@email.com"
        ));
    
        usuarios.add(new Usuario(
                "Henrique Lima",
                "89012345678",
                "henrique.lima@email.com"
        ));
    }

    private void cadastrarBibliotecariosIniciais() {

        bibliotecarios.add(new Bibliotecario(
                "Mariana Ferreira",
                "12345678901",
                "mariana.ferreira@biblioteca.com",
                2001
        ));
    
        bibliotecarios.add(new Bibliotecario(
                "Ricardo Mendes",
                "23456789012",
                "ricardo.mendes@biblioteca.com",
                2002
        ));
    
        bibliotecarios.add(new Bibliotecario(
                "Patricia Almeida",
                "34567890123",
                "patricia.almeida@biblioteca.com",
                2003
        ));
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (MateriaBiblioteca material : materiais) {
            if (material instanceof Livro && material.getTitulo().equalsIgnoreCase(titulo)) {
                return (Livro) material;
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    public Artigo buscarArtigoPorTitulo(String titulo) {
        for (MateriaBiblioteca material : materiais) {
            if (material instanceof Artigo && material.getTitulo().equalsIgnoreCase(titulo)) {
                return (Artigo) material;
            }
        }
        return null; // Retorna null se o artigo não for encontrado
    }

    public ArrayList<MateriaBiblioteca> getMateriais() {
        return materiais;
    }

    public ArrayList<MateriaBiblioteca> cadastrarNovosLivros(Livro livro) {
        materiais.add(livro);
        return materiais;
    }
    
    public ArrayList<MateriaBiblioteca> cadastrarNovosArtigos(Artigo artigo) {
        materiais.add(artigo);
        return materiais;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Usuario> cadastrarNovosUsuarios(Usuario usuario) {
        usuarios.add(usuario);
        return usuarios;
    }

    public ArrayList<MateriaBiblioteca> getMateriaisDisponiveis() {
        ArrayList<MateriaBiblioteca> materiaisDisponiveis = new ArrayList<>();
        for (MateriaBiblioteca material : materiais) {
            if (material.isDisponibilidade()) {
                materiaisDisponiveis.add(material);
            }
        }
        return materiaisDisponiveis;
    }

public Usuario buscarUsuarioPorMatricula(int matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == matricula) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

public void cadastrarUsuario(String nome, String cpf, String email) {
        Usuario novoUsuario = new Usuario(nome, cpf, email);
        usuarios.add(novoUsuario);
        
    }

public double calcularMulta(String dataDevolucao) {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate dataLimite = LocalDate.parse(dataDevolucao, formato);
    LocalDate hoje = LocalDate.now();

    // Se não estiver atrasado, não há multa
    if (!hoje.isAfter(dataLimite)) {
        return 0.0;
    }

    // Calcula a quantidade de dias de atraso
    long diasAtraso = ChronoUnit.DAYS.between(dataLimite, hoje);

    // Cada semana iniciada gera uma cobrança
    long semanasAtraso = (diasAtraso + 6) / 7;

    double valorPorSemana = 10.0;

    return semanasAtraso * valorPorSemana;
}

public Multa gerarMulta( double valor, String dataVencimento, String dataPagamento, String motivo, boolean paga) {
        return new Multa(valor, dataVencimento, dataPagamento, motivo, paga);
    }


    public Usuario removerMulta(Usuario usuario) {
        usuario.setMulta(new Multa(0.0, null, null, null, true));
        return usuario;
    }

    public void registrarEmprestimo(Usuario usuario, MateriaBiblioteca material, String dataEmprestimo, String dataDevolucao) {
        if (usuario.getMaterialEmprestado() != null) {
            System.out.println("O usuário já possui um livro emprestado.");
            return;
        }

        if (!material.isDisponibilidade()) {
            System.out.println("O material não está disponível para empréstimo.");
            return;
        }
        else {}
        Emprestimo emprestimo = new Emprestimo(usuario, material, dataEmprestimo, dataDevolucao);
        usuario.setMaterialEmprestado(emprestimo);
        material.setDisponibilidade(false);
        }
    

    public void registrarDevolucao(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário inválido");
        }
        Emprestimo emprestimo = usuario.getMaterialEmprestado(); 

        if (emprestimo == null) {
            throw new IllegalStateException("O usuário não possui nenhum material emprestado");
        }

        if (emprestimo.isAtrasado()) {
            double valor = calcularMulta(emprestimo.getDataDevolucao());
            usuario.setDevedor(true);
            Multa multa = gerarMulta(valor, emprestimo.getDataDevolucao(), null, "Devolução atrasada", false);
            usuario.setMulta(multa);
            throw new IllegalStateException("O usuário possui uma multa pendente de R$" + valor + " e não pode devolver o material.");
            
        }

            usuario.setMaterialJaEmprestado(emprestimo);
            usuario.setMaterialEmprestado(null);
            

    }

    public void CadastrarLivro(Livro livro) {
        materiais.add(livro);
    }

    public void CadastrarArtigo(Artigo artigo) {
        materiais.add(artigo);
    }
    


}



