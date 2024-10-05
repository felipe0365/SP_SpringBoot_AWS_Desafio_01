package biblioteca.main;

import biblioteca.dao.imp.AutorImp;
import biblioteca.dao.imp.LivroImp;
import biblioteca.model.Autor;
import biblioteca.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotecaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*AutorImp autorImp = new AutorImp(entityManager);
        System.out.println(autorImp.gerarRelatorio());*/

        Autor tolkien = entityManager.find(Autor.class, 1);

        AutorImp autores = new AutorImp(entityManager);
        autores.deletarPorId(4L);


        /*Autor CSLewis = new Autor();
        CSLewis.setNome("C. S. Lewis");
        CSLewis.setDataNascimento(LocalDate.of(1898, 11, 29));
        CSLewis.setNacionalidade("britânico");
        CSLewis.setBiografia("Clive Staples Lewis, comumente referido como C. S. Lewis (Belfast, 29 de novembro de 1898 — Oxford, 22 de novembro de 1963), foi um professor universitário, escritor, romancista, poeta, crítico literário, ensaísta e teólogo anglicano irlandês. Durante sua carreira acadêmica, foi professor e membro do Magdalen College, tanto da Universidade de Oxford como da Universidade de Cambridge. Ele é conhecido por seus trabalhos envolvendo tanto a apologia cristã – incluindo as obras O Problema do Sofrimento (1940), Milagres (1947) e Cristianismo Puro e Simples (1952) – quanto os temas de ficção e fantasia – com obras como As Crônicas de Nárnia (1950-56), Cartas de um diabo ao seu aprendiz (1942) e Trilogia Espacial (1938-45). Foi também um estudioso da literatura medieval e renascentista, tendo produzido alguns dos mais renomados trabalhos acadêmicos envolvendo esses temas no século XX.");
         */

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

        /* int opcao = 0;
        while(opcao != 5) {
            System.out.println("BEM VINDO(a) A BIBLIOTECA");

            System.out.println();
            System.out.println("1) Cadastrar Livro");
            System.out.println("2) Buscar livro");
            System.out.println("3) Empréstimo de livro");
            System.out.println("4) Devolução de livro");
            System.out.println("5) Sair");
            System.out.print("O que deseja fazer? ");
            opcao = sc.nextInt();

            if(opcao == 5) {
                System.out.println("Até a próxima!");
            }
        } */


    }
}