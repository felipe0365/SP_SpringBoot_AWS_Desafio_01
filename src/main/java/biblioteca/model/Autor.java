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

    /* Fazer a verificação se um autor existe no banco de dados pelo nome.
    Autor autorExistente = em.createQuery("SELECT a FROM Autor a WHERE a.nome = :nome", Autor.class).setParameter("nome", nomeAutor).getSingleResult();
        if (autorExistente != null) {
        autorExistente.setBiografia("John Ronald Reuel Tolkien,[1] CBE,[2] FRSL, conhecido internacionalmente por J. R. R. Tolkien (Bloemfontein, 3 de janeiro de 1892 – Bournemouth, 2 de setembro de 1973),[3] foi um escritor, professor universitário e filólogo britânico, nascido na atual África do Sul, que recebeu o título de doutor em Letras e Filologia pela Universidade de Liège e Dublin, em 1954,[4][5] e autor das obras como O Hobbit, O Senhor dos Anéis e O Silmarillion.[6] Em 28 de março de 1972, Tolkien foi nomeado Comendador da Ordem do Império Britânico pela Rainha Elizabeth II.");
        em.merge(autorExistente);
    } else {
        System.out.println("Autor não existe");
    }*/


}
