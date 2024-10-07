package biblioteca.dao;

import biblioteca.model.Membro;

import java.math.BigDecimal;
import java.util.List;

public interface MembroDAO {

    void cadastrar(Membro membro);

    void deletarPorId(Long id);

    void aplicarMulta(Long membroId, BigDecimal multa);

    Membro buscarPorId(Long id);

    Membro buscarPorEmail(String email);

    List<Membro> listarTodos();


}