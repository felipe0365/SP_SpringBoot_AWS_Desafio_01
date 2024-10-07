package biblioteca.dao.imp;

import biblioteca.dao.AutorDAO;
import biblioteca.dao.RelatorioDAO;
import biblioteca.model.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AutorImp extends Autor implements AutorDAO, RelatorioDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AutorImp() {
    }

    public AutorImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void cadastrar(Autor autor) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(autor);

            entityManager.getTransaction().commit();

            System.out.println("Autor cadastrado com sucesso: " + autor);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o autor: " + autor);
        } finally {
            entityManager.close();
        }
    }


    @Override
    public void deletarPorId(Long id) {
        try {
            entityManager.getTransaction().begin();

            Autor autor = entityManager.find(Autor.class, id);

            if (autor != null) {
                entityManager.remove(autor);
                System.out.println("Autor deletado com sucesso: " + autor);
            } else {
                System.out.println("Nenhum autor encontrado com ID: " + id);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o autor com ID: " + id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Autor buscarPorId(Long id) {
        Autor autor = null;

        try {
            autor = entityManager.createQuery("SELECT a FROM Autor a WHERE a.id = :id", Autor.class)
                    .setParameter("id", id)
                    .getSingleResult();

            System.out.println("Autor encontrado:");
            System.out.println("Id: " + autor.getId());
            System.out.println("Nome: " + autor.getNome());
            System.out.println("Data de Nascimento: " + autor.getDataNascimento());
            System.out.println("Nacionalidade: " + autor.getNacionalidade());

        } catch (NoResultException e) {
            System.out.println("Nenhum autor encontrado com id: " + id);
        } finally {
            entityManager.close();
        }

        return autor;
    }

    @Override
    public Autor buscarPorNome(String nome) {
        Autor autor = null;

        try {
            autor = entityManager.createQuery("SELECT a FROM Autor a WHERE a.nome = :nome", Autor.class)
                    .setParameter("nome", nome)
                    .getSingleResult();

            System.out.println("Autor encontrado:");
            System.out.println("Id: " + autor.getId());
            System.out.println("Nome: " + autor.getNome());
            System.out.println("Data de Nascimento: " + autor.getDataNascimento());
            System.out.println("Nacionalidade: " + autor.getNacionalidade());

        } catch (NoResultException e) {
            System.out.println("Nenhum autor encontrado com nome: " + nome);
        } finally {
            entityManager.close();
        }

        return autor;
    }

    @Override
    public List<Autor> listarTodos() {
        List<Autor> autores = entityManager.createQuery("FROM Autor", Autor.class).getResultList();

        StringBuilder autoresInfo = new StringBuilder("Autores:\n");

        for (Autor autor : autores) {
            autoresInfo.append(String.format(
                    "ID: %d, Nome: %s\n",
                    autor.getId(),
                    autor.getNome()
            ));
        }

        System.out.println(autoresInfo.toString());

        entityManager.close();

        return autores;
    }

    @Override
    public boolean autorExiste(String nome) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(a) FROM Autor a WHERE a.nome = :nome",
                    Long.class
            );
            query.setParameter("nome", nome);

            Long count = query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String gerarRelatorio() {
        List<Autor> autores = entityManager.createQuery("FROM Autor", Autor.class).getResultList();
        StringBuilder relatorio = new StringBuilder("Relatório de autores:\n");
        for (Autor autor : autores) {
            relatorio.append(String.format("Nome: %s, Data de Nascimento: %s, Nacionalidade: %s\n", autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade()));
        }
        entityManager.close();
        return relatorio.toString();
    }


}
