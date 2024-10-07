/*package biblioteca.service;

import biblioteca.model.*;
import biblioteca.dao.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.EntityManager;

public class BibliotecaService {

    private final EmprestimoDAO emprestimoDAO;
    private final LivroDAO livroDAO;
    private final MembroDAO membroDAO;
    private final EntityManager em;

    public BibliotecaService(EmprestimoDAO emprestimoDAO, LivroDAO livroDAO, MembroDAO membroDAO, EntityManager em) {
        this.emprestimoDAO = emprestimoDAO;
        this.livroDAO = livroDAO;
        this.membroDAO = membroDAO;
        this.em = em;
    }

    public void pegarEmprestado(Long livroId, Long membroId) {
        em.getTransaction().begin();
        try {
            Livro livro = livroDAO.buscarPorId(livroId);
            Membro membro = membroDAO.buscarPorId(membroId);

            if (livro == null || livro.getQuantidade() <= 0) {
                throw new IllegalStateException("Livro não disponível.");
            }
            if (membro == null || membro.temMultaPendente()) {
                throw new IllegalStateException("Membro não existe ou possui multas pendentes.");
            }

            livro.setQuantidade(livro.getQuantidade() - 1);
            Emprestimo emprestimo = new Emprestimo(livro, membro, LocalDate.now(), EstadoEmprestimo.ATIVO);
            emprestimo.setDataDevolucaoPrevista(LocalDate.now().plusWeeks(2));

            emprestimoDAO.registrar(emprestimo);
            em.merge(livro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao realizar empréstimo.");
        }
    }

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
                emprestimo.setMulta(multa);

                Membro membro = emprestimo.getMembro();
                membro.setMultaTotal(membro.getMultaTotal().add(multa));
            }

            Livro livro = emprestimo.getLivro();
            livro.setQuantidade(livro.getQuantidade() + 1);
            emprestimo.setEstado(EstadoEmprestimo.CONCLUIDO);

            emprestimoDAO.devolver(emprestimo);
            em.merge(livro);
            em.merge(membro);  // Atualizar membro, pois alteramos a multa
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao realizar devolução.");
        }
    }
}
 */