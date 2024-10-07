package biblioteca.dao.imp;

import biblioteca.dao.EmprestimoDAO;
import biblioteca.dao.RelatorioDAO;
import biblioteca.model.Emprestimo;
import biblioteca.model.EstadoEmprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Membro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmprestimoImp implements EmprestimoDAO, RelatorioDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EmprestimoImp() {
    }

    public EmprestimoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void pegarEmprestado(Membro membro, Long id) {
        try {
            membro = entityManager.find(Membro.class, membro);
            Livro livro = entityManager.find(Livro.class, id);
            MembroImp membroImp = new MembroImp(entityManager);
            int livroQtd = livro.getQuantidade();
            BigDecimal multaMembro = membro.getMultaTotal();
            double multa = multaMembro.doubleValue();

            if (livro == null || membro == null) {
                System.out.println("Nenhum livro ou autor encontrado.");
            } else if (livro != null && membro != null) {
                if (multa > 0) {
                    System.out.println("Membro não pode utilizar o serviço de empréstimo, pois está com multa ativa");
                } else {
                    Emprestimo emprestimo = new Emprestimo();
                    emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));
                    emprestimo.setDataEmprestimo(LocalDate.now());
                    emprestimo.setEstado(EstadoEmprestimo.ATIVO);
                    emprestimo.setLivro(livro);
                    emprestimo.setMembro(membro);
                    emprestimo.setMulta(BigDecimal.valueOf(0));

                    entityManager.getTransaction().begin();
                    entityManager.persist(emprestimo);
                    entityManager.getTransaction().commit();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void devolverEmprestimo(Membro membro, Long id) {
        try {
            entityManager.getTransaction().begin();
            membro = entityManager.find(Membro.class, membro);
            Emprestimo emprestimo = entityManager.find(Emprestimo.class, id);

            if (membro == null || emprestimo == null) {
                System.out.println("Nenhum empréstimo com esse membro com esse membro ou id");
            } else {
                LocalDate hoje = LocalDate.now();

                if (hoje.isAfter(emprestimo.getDataEmprestimo())) {
                    emprestimo.setEstado(EstadoEmprestimo.ATRASADO);
                    emprestimo.setMulta(BigDecimal.valueOf(5));
                    membro.setMultaTotal(emprestimo.getMulta());
                    entityManager.merge(emprestimo);
                } else {
                    emprestimo.setEstado(EstadoEmprestimo.CONCLUIDO);
                    entityManager.merge(emprestimo);
                }

            }
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String gerarRelatorio() {
        try {
            List<Emprestimo> emprestimos = entityManager.createQuery("FROM Emprestimo ", Emprestimo.class).getResultList();
            StringBuilder relatorio = new StringBuilder("Relatório de empréstimos:\n");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for (Emprestimo emprestimo : emprestimos) {
                String dataEmprestimo = emprestimo.getDataEmprestimo().format(formatter);
                String dataDevolucao = emprestimo.getDataDevolucao().format(formatter);
                relatorio.append(String.format("ID: %d, ID do livro: %d, ID do membro: %d, Data do empréstimo: %s, Data para Devolução: %s, Estado do empréstimo: %s, Multa: %.2f\n",
                        emprestimo.getId(), emprestimo.getLivro().getId(), emprestimo.getMembro().getId(),
                        dataEmprestimo, dataDevolucao, emprestimo.getEstado(),
                        emprestimo.getMulta()));
            }
            entityManager.close();
            return relatorio.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
