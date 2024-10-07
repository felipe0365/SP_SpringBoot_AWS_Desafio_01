package biblioteca.application;

import biblioteca.dao.imp.AutorImp;
import biblioteca.dao.imp.LivroImp;
import biblioteca.dao.imp.MembroImp;
import biblioteca.model.Autor;
import biblioteca.model.Livro;
import biblioteca.model.Membro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        int opcao = 0;
        boolean loop = true;
        while (loop) {

            System.out.println("BEM VINDO(a) A BIBLIOTECA");

            System.out.println();
            System.out.println("1) Cadastrar Livro");
            System.out.println("2) Buscar livro");
            System.out.println("3) Empréstimo de livro");
            System.out.println("4) Devolução de livro");
            System.out.println("5) Cadastrar Autor");
            System.out.println("6) Listar autores");
            System.out.println("7) Gerar relatório dos autores");
            System.out.println("8) Sair");
            System.out.println("O que deseja fazer? ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Livro livro = new Livro();
                    System.out.println("Digite o nome do livro: ");
                    String tituloLivro = sc.nextLine();
                    System.out.println("Digite o ISBS do livro: ");
                    String isbn = sc.nextLine();
                    System.out.println("Digite o genero do livro: ");
                    String genero = sc.nextLine();
                    System.out.println("Digite quantos livros desse possui na biblioteca: ");
                    int quantidadeLivros = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o ano de publicação do livro");
                    String dataString = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataPublicacao = LocalDate.parse(dataString, formatter);

                    System.out.println("O autor já está cadastro em nosso sistema? [S/N]");
                    String autorCadastrado = sc.nextLine();
                    if (autorCadastrado.equals("N")) {
                        Autor autor = new Autor();
                        System.out.println("Digite o nome do autor: ");
                        String nomeAutor = sc.nextLine();
                        AutorImp autorImp = new AutorImp(entityManager);
                        if (autorImp.autorExiste(nomeAutor)) {
                            System.out.println("Autor já cadastrado. Coloque o ID do autor ao cadastrar o livro");
                            continue;
                        }

                        System.out.println("Digite a data de nascimento do autor: ");
                        String dataNascimentoString = sc.nextLine();
                        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString);
                        System.out.println("Digite a nacionalidade do autor: ");
                        String nacionalidade = sc.nextLine();
                        System.out.println("Digite uma breve biografia do autor: ");
                        String biografia = sc.nextLine();

                        autor.setNome(nomeAutor);
                        autor.setDataNascimento(dataNascimento);
                        autor.setNacionalidade(nacionalidade);
                        autor.setBiografia(biografia);

                        entityManager.getTransaction().begin();
                        entityManager.persist(autor);
                        entityManager.getTransaction().commit();
                        break;

                    } else if (autorCadastrado.equals("S")) {
                        System.out.println("Digite o ID do autor: ");
                        String idAutorString = sc.nextLine();
                        Long idAutor = Long.parseLong(idAutorString);
                        AutorImp autor = new AutorImp(entityManager);
                        autor.buscarPorId(idAutor);

                        livro.setDataPublicacao(dataPublicacao);
                        livro.setAutor(autor);
                        livro.setIsbn(isbn);
                        livro.setQuantidade(quantidadeLivros);
                        livro.setGenero(genero);
                        livro.setTitulo(tituloLivro);
                    }
                case 2:
                    System.out.println("1) Buscar livro por ID");
                    System.out.println("2) Buscar livro por isbn");
                    String opc = sc.nextLine();
                    if (opc.equals("1")) {
                        System.out.println("Digite o id do livro: ");
                        long idLivro = Long.parseLong(sc.nextLine());
                        LivroImp buscaLivro = new LivroImp(entityManager);
                        System.out.println(buscaLivro.buscarPorId(idLivro));
                        continue;
                    } else if (opc.equals("2")) {
                        System.out.println("Digite o isbn do livro: ");
                        String isbn2 = sc.nextLine();
                        LivroImp buscaLivro = new LivroImp(entityManager);
                        System.out.println(buscaLivro.buscarPorIsbn(isbn2));
                        continue;
                    } else {
                        System.out.println("Valor inválido!");
                        continue;
                    }
                case 5:
                    System.out.println("Digite o nome do autor: ");
                    String nomeAutor = sc.nextLine();
                    System.out.println("Digite a data de nascimento do autor: ");
                    String dataNascimentoString = sc.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoString);
                    System.out.println("Digite a nacionalidade do autor: ");
                    String nacionalidade = sc.nextLine();
                    System.out.println("Digite uma breve biografia do autor: ");
                    String biografia = sc.nextLine();

                    Autor autor = new Autor();
                    autor.setNome(nomeAutor);
                    autor.setDataNascimento(dataNascimento);
                    autor.setNacionalidade(nacionalidade);
                    autor.setBiografia(biografia);

                    entityManager.getTransaction().begin();
                    entityManager.persist(autor);
                    entityManager.getTransaction().commit();
                    break;
                case 6:
                    AutorImp autorImp = new AutorImp(entityManager);
                    autorImp.listarTodos();
                    break;
                case 7:
                    AutorImp autorImpRelatorio = new AutorImp(entityManager);
                    autorImpRelatorio.gerarRelatorio();
                    break;
                case 8:
                    loop = false;
                    break;

            }

        }



































        /*AutorImp autorImp = new AutorImp(entityManager);
        System.out.println(autorImp.gerarRelatorio());*/

        /*
        Membro elendil = entityManager.find(Membro.class, 1);

        elendil.setMultaTotal(BigDecimal.valueOf(0));

        entityManager.getTransaction().begin();
        entityManager.merge(elendil);
        entityManager.getTransaction().commit();
        System.out.println("done");
        /*

        /*
        teste.setTitulo("teste");
        teste.setAutor(tolkien);
        teste.setDataPublicacao(LocalDate.of(2000, 2, 4));
        teste.setIsbn("1234567890");
        teste.setGenero("Fantasia");
        teste.setQuantidade(1);

        entityManager.getTransaction().begin();
        entityManager.persist(teste);
        entityManager.getTransaction().commit();*/

        /*entityManager.getTransaction().begin();

        //find
        Autor tolkien = entityManager.find(Autor.class, 1);

        //insert
        Livro senhorDosAneis1 = new Livro();
        senhorDosAneis1.setTitulo("O Senhor dos Anéis: A Sociedade do Anel");
        senhorDosAneis1.setAutor(tolkien);
        senhorDosAneis1.setDataPublicacao(LocalDate.of(1954, 7, 29));
        senhorDosAneis1.setIsbn("978-972-1-04102-8");
        senhorDosAneis1.setGenero("Fantasia");
        senhorDosAneis1.setQuantidade(1);

        entityManager.persist(senhorDosAneis1);
        entityManager.getTransaction().commit();
        System.out.println("Done!");*/

    }
}