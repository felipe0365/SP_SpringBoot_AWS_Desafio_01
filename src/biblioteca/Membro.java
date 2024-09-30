package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Membro extends Pessoa {

    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataAssociacao;

    private List<Emprestimo> emprestimos;

    public Membro() {
    }

    public Membro(String nome, String endereco, String telefone, String email, LocalDate dataAssociacao) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataAssociacao = dataAssociacao;
        this.emprestimos = new ArrayList<>();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(LocalDate dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }
}
