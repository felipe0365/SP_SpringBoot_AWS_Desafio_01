package biblioteca.main;

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

        Autor tolkien = entityManager.find(Autor.class, 1);

        LivroImp teste = new LivroImp(entityManager);
        teste.deletarPorId(2L);

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