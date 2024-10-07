package biblioteca.dao;

import biblioteca.model.Autor;

import java.util.List;

public interface AutorDAO {

    void cadastrar(Autor autor);

    void deletarPorId(Long id);

    Autor buscarPorId(Long id);

    Autor buscarPorNome(String nome);

    List<Autor> listarTodos();

    boolean autorExiste(String nome);
}
