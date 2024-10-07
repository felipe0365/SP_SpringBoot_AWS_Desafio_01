package biblioteca.dao.imp;

import biblioteca.dao.EmprestimoDAO;
import biblioteca.dao.MembroDAO;
import biblioteca.model.Livro;
import biblioteca.model.Membro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.math.BigDecimal;
import java.util.List;

public class MembroImp implements MembroDAO {

    private EntityManager entityManager;

    public MembroImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void cadastrar(Membro membro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(membro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void deletarPorId(Long id) {
        try {
            entityManager.getTransaction().begin();
            Membro membro = entityManager.find(Membro.class, id);
            if (membro != null) {
                entityManager.remove(membro);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Membro buscarPorId(Long id) {
        try {
            return entityManager.find(Membro.class, id);
        } catch (NoResultException e) {
            System.out.println("Nenhum membro encontrado com ID: " + id);
            return null;
        }
    }

    @Override
    public Membro buscarPorEmail(String email) {
        try {
            return entityManager.createQuery("SELECT m FROM Membro m WHERE m.email = :email", Membro.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nenhum membro encontrado com email: " + email);
            return null;
        }
    }

    @Override
    public List<Membro> listarTodos() {
        return entityManager.createQuery("FROM Membro", Membro.class).getResultList();
    }

    public boolean temMultaPendente(Membro membro) {
        return membro.getMultaTotal().compareTo(BigDecimal.ZERO) > 0;
    }

    public void aplicarMulta(Long membroId, BigDecimal multa) {
        try {
            entityManager.getTransaction().begin();
            Membro membro = entityManager.find(Membro.class, membroId);
            if (membro != null) {
                membro.setMultaTotal(membro.getMultaTotal().add(multa));
                entityManager.merge(membro);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}