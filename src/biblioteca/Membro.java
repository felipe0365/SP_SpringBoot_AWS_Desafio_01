package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Membro {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataAssociacao;

    private List<Emprestimo> emprestimos;

    public Membro() {
    }

    public Membro(String nome, String endereco, String telefone, String email, LocalDate dataAssociacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataAssociacao = dataAssociacao;

        this.emprestimos = new ArrayList<>();
    }
}
