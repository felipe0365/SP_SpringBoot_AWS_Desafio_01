package biblioteca.dao.imp;

import biblioteca.dao.LivroDAO;
import biblioteca.dao.RelatorioDAO;
import biblioteca.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;

import java.util.List;

public class LivroImp implements LivroDAO, RelatorioDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LivroImp() {
    }

    public LivroImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void cadastrar(Livro livro) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(livro);

            entityManager.getTransaction().commit();

            System.out.println("Livro cadastrado com sucesso: " + livro);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o livro: " + livro);
        }
    }

    @Override
    public void deletarPorId(Long id) {
        try {
            entityManager.getTransaction().begin();

            Livro livro = entityManager.find(Livro.class, id);

            if (livro != null) {
                entityManager.remove(livro);
                System.out.println("Livro deletado com sucesso: " + livro);
            } else {
                System.out.println("Nenhum livro encontrado com ID: " + id);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o livro com ID: " + id);
        }
    }

    @Override
    public Livro buscarPorId(Long id) {
        try {
            Livro livro = entityManager.find(Livro.class, id);
            if (livro != null) {
                return livro;
            } else {
                System.out.println("Nenhum livro encontrado com ID: " + id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o livro com ID: " + id);
            return null;
        }
    }

    @Override
    public Livro buscarPorIsbn(String isbn) {
        try {
            return entityManager.createQuery("SELECT l FROM Livro l WHERE l.isbn = :isbn", Livro.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nenhum livro encontrado com ISBN: " + isbn);
            return null;
        }
    }

    @Override
    public List<Livro> listarTodos() {
        List<Livro> livros = entityManager.createQuery("FROM Livro", Livro.class).getResultList();

        StringBuilder livrosInfo = new StringBuilder("Livros:\n");
        for (Livro livro : livros) {
            livrosInfo.append(String.format("Título: %s\n", livro.getTitulo()));
        }
        System.out.println(livrosInfo.toString());

        entityManager.close();

        return livros;
    }

    @Override
    public String gerarRelatorio() {
        List<Livro> livros = entityManager.createQuery("FROM Livro", Livro.class).getResultList();
        StringBuilder relatorio = new StringBuilder("Relatório de livros:\n");
        for (Livro livro : livros) {
            relatorio.append(String.format("Título: %s, Autor: %s, ISBN: %s, Quantidade: %d\n", livro.getTitulo(), livro.getAutor().getNome(), livro.getIsbn(), livro.getQuantidade()));
        }
        entityManager.close();
        return relatorio.toString();
    }
}
