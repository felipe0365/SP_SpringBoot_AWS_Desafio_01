package biblioteca.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Membro extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "data_associacao")
    private LocalDate dataAssociacao;

    @OneToMany(mappedBy = "membro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimos;

    @Column(name = "multa")
    private BigDecimal multaTotal = BigDecimal.ZERO;


    public Membro() {
    }

    public Membro(String nome, String endereco, String telefone, String email, LocalDate dataAssociacao, BigDecimal multaTotal) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataAssociacao = dataAssociacao;
        this.emprestimos = new ArrayList<>();
        this.multaTotal = multaTotal;
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

    public BigDecimal getMultaTotal() {
        return multaTotal;
    }

    public void setMultaTotal(BigDecimal multaTotal) {
        this.multaTotal = multaTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
