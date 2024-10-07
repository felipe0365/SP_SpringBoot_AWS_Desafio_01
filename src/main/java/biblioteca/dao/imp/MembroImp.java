package biblioteca.dao.imp;

import biblioteca.dao.MembroDAO;
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
            e.printStackTrace();
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
            e.printStackTrace();
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

    // Método adicional para verificar multas
    public boolean temMultaPendente(Membro membro) {
        return membro.getMultaTotal().compareTo(BigDecimal.ZERO) > 0;
    }

    // Método auxiliar para gerenciar multas
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
    /*
    public void devolverEmprestimo(Long emprestimoId) {
        em.getTransaction().begin();
        try {
            Emprestimo emprestimo = emprestimoDAO.buscarPorId(emprestimoId);
            if (emprestimo == null) {
                throw new IllegalStateException("Empréstimo não encontrado.");
            }

            LocalDate hoje = LocalDate.now();
            if (hoje.isAfter(emprestimo.getDataDevolucaoPrevista())) {
                long diasAtrasados = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), hoje);
                BigDecimal multaPorDia = new BigDecimal("5.00"); // Exemplo: R$ 5,00 por dia
                BigDecimal multa = multaPorDia.multiply(BigDecimal.valueOf(diasAtrasados));

                // Aplicar multa ao membro
                Membro membro = emprestimo.getMembro();
                membro.setMultaTotal(membro.getMultaTotal().add(multa));
                membroDAO.atualizar(membro); // Atualiza o membro no BD

                emprestimo.setMulta(multa);
            }

            Livro livro = emprestimo.getLivro();
            livro.setQuantidade(livro.getQuantidade() + 1);
            emprestimo.setEstado(EstadoEmprestimo.CONCLUIDO);

            emprestimoDAO.devolver(emprestimo);
            em.merge(livro);
            em.merge(membro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao realizar devolução.");
        }
    }
     */
}