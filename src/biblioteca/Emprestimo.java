package biblioteca;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Membro membro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private EstadoEmprestimo estado;
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
}
