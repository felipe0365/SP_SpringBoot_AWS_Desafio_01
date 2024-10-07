package biblioteca.model;

import biblioteca.dao.imp.AutorImp;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "genero")
    private String genero;

    @Column(name = "quantidade")
    private int quantidade;

    public Livro() {
    }

    public Livro(String titulo, Autor autor, LocalDate dataPublicacao, String isbn, String genero, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
        this.genero = genero;
        this.quantidade = quantidade;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Autor getAutor() {
        return autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", dataPublicacao=" + dataPublicacao +
                ", isbn='" + isbn + '\'' +
                ", genero='" + genero + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
