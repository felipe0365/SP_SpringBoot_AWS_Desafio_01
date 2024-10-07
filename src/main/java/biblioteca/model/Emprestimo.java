package biblioteca.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private EstadoEmprestimo estado;

    @Column(name = "multa", precision = 10, scale = 2)
    private BigDecimal multa;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Membro membro, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setEstado(EstadoEmprestimo estado) {
        this.estado = estado;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Livro getLivro() {
        return livro;
    }

    public Membro getMembro() {
        return membro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public EstadoEmprestimo getEstado() {
        return estado;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
