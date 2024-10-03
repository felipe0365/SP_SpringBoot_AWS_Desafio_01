package biblioteca.dao;

import biblioteca.model.Autor;

import java.util.List;

public interface AutorDAO {

    void cadastrar(Autor autor);

    void atualizar(Autor autor);

    void deletar(Autor autor);

    Autor buscarPorId(Long id);

    Autor buscarPorNome(String nome);

    List<Autor> listarTodos();
}
