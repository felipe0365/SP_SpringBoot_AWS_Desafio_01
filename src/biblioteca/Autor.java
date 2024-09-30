package biblioteca;

public class Autor {

    private String nome;
    private String dataNascimento;
    private String nacionalidade;
    private String biografia;

    public Autor() {
    }

    public Autor(String nome, String dataNascimento, String nacionalidade, String biografia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getBiografia() {
        return biografia;
    }
}
