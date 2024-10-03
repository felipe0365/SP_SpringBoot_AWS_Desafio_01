package biblioteca.dao;

import biblioteca.model.Livro;

import java.util.List;

public interface LivroDAO {

    void cadastrar(Livro livro);

    void atualizar(Livro livro);

    void deletar(Livro livro);

    Livro buscarPorId(Long id);

    Livro buscarPorIsbn(String isbn);

    List<Livro> listarTodos();
}
