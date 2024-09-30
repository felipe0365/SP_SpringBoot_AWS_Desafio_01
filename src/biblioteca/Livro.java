package biblioteca;

import java.time.LocalDate;

public class Livro {

    private String titulo;
    private Autor autor;
    private LocalDate dataPublicacao;
    private String isbn;
    private String genero;
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
}
