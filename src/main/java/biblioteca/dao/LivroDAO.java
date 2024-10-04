package biblioteca.dao;

import biblioteca.model.Livro;

import java.util.List;

public interface LivroDAO {

    void cadastrar(Livro livro);

    void deletarPorId(Long id);

    Livro buscarPorId(Long id);

    Livro buscarPorIsbn(String isbn);

    List<Livro> listarTodos();
}
