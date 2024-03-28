import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaTeste {

    private static ArrayList<Livro> biblioteca = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do{
            System.out.println();
            System.out.println("........MENU DE OPÇÕES........");
            System.out.println("1. Cadastrar Livros...........");
            System.out.println("2. Emprestar Livro............");
            System.out.println("3. Devolver Livro.............");
            System.out.println("4. Listar todos os Livros.....");
            System.out.println("5. Pesquisar por Livro........");
            System.out.println("6. Sair.......................");
            System.out.println("Escolha a opção que deseja: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    emprestarLivro();
                    break;
                case 3:
                    devolverLivro();
                    break;
                case 4:
                    listarLivros();
                    break;
                case 5:
                   pesquisarLivro();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }

        }while(opcao != 6);
        sc.close();
    }

    private static void cadastrarLivro() {
        System.out.print("Informe o título do livro: ");
        String titulo = sc.nextLine();
        if (titulo.isEmpty()) {
            System.out.println("O título do livro não pode estar em branco. Tente novamente.");
            return;
        }

        System.out.print("Informe o nome do autor do livro: ");
        String autor = sc.nextLine();
        if (autor.isEmpty()) {
            System.out.println("O autor do livro não pode estar em branco. Tente novamente.");
            return;
        }

        biblioteca.add(new Livro(titulo, autor));
        System.out.println("Livro cadastrado com sucesso!");
    }



    private static void emprestarLivro() {
        System.out.print("Informe o título do livro que deseja emprestar: ");
        String titulo = sc.nextLine();

        for (Livro livro : biblioteca) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.emprestar();
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }



    private static void devolverLivro() {
        System.out.print("Digite o título do livro que deseja devolver: ");
        String titulo = sc.nextLine();
        for (Livro livro : biblioteca) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.devolver();
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void listarLivros() {
        if (biblioteca.isEmpty()) {
            System.out.println("Ainda não há livros cadastrados!");
        } else {
            System.out.println("--- Lista de Livros ---");
            for (Livro livro : biblioteca) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Disponível: " + (livro.livroDisponivel() ? "Sim" : "Não"));
                System.out.println();
            }
        }
    }

    private static void pesquisarLivro() {
        System.out.println("Digite o termo de pesquisa (título ou autor): ");
        String termo = sc.nextLine();

        boolean encontrado = false;
        for (Livro livro : biblioteca) {
            if (livro.getTitulo().equalsIgnoreCase(termo) || livro.getAutor().equalsIgnoreCase(termo)) {
                System.out.println("Livro encontrado:");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Disponível: " + (livro.livroDisponivel() ? "Sim" : "Não"));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado para o termo de pesquisa '" + termo + "'.");
        }
    }


}


