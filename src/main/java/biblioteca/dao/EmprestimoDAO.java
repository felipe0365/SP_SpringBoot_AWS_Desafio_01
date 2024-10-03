package biblioteca.dao;

import biblioteca.model.Livro;

import java.math.BigDecimal;

public interface EmprestimoDAO {

    void pegarEmprestado(Livro livro);

    void devolverEmprestimo(Livro livro);

    boolean consultarPossibilidadeEmprestimo();

    BigDecimal consultarMulta();
}
