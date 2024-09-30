package biblioteca;

public class Autor extends Pessoa{

    private String dataNascimento;
    private String nacionalidade;
    private String biografia;

    public Autor() {
    }

    public Autor(String nome, String dataNascimento, String nacionalidade, String biografia) {
        super(nome);
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
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
