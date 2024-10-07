package biblioteca.dao;

import biblioteca.model.Livro;
import biblioteca.model.Membro;

import java.math.BigDecimal;

public interface EmprestimoDAO {

    void pegarEmprestado(Membro membro, Long id);

    void devolverEmprestimo(Membro membro, Long id);

}
