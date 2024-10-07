package biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "autor")
public class Autor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "biografia")
    private String biografia;

    public Autor() {
    }

    public Autor(String nome, LocalDate dataNascimento, String nacionalidade) {
        super(nome);
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getBiografia() {
        return biografia;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", biografia='" + biografia + '\'' +
                '}';
    }
}
