package biblioteca.dao.imp;

import biblioteca.dao.LivroDAO;
import biblioteca.dao.RelatorioDAO;
import biblioteca.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

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

    }

    @Override
    public void atualizar(Livro livro) {

    }

    @Override
    public void deletar(Livro livro) {

    }

    @Override
    public Livro buscarPorId(Long id) {
        return null;
    }

    @Override
    public Livro buscarPorIsbn(String isbn) {
        return null;
    }

    @Override
    public List<Livro> listarTodos() {
        return null;
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
