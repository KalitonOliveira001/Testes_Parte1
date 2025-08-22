package app; // diz que esta classe está dentro do pacote "app"

// Classe que representa uma pessoa (tem nome e sexo)
public class Pessoa {

    // Guardamos o nome da pessoa
    private final String nome;

    // Guardamos o sexo informado (ex.: "F", "M", "Feminino", "Masculino")
    private final String sexo;

    // Construtor: quando criamos uma Pessoa, passamos nome e sexo
    public Pessoa(String nome, String sexo) {
        this.nome = nome;   // guarda o nome
        this.sexo = sexo;   // guarda o sexo
    }

    // Devolve o nome (para outras classes poderem ler)
    public String getNome() {
        return nome;
    }

    // Devolve o sexo (para outras classes poderem ler)
    public String getSexo() {
        return sexo;
    }

    // Diz como a pessoa aparece quando imprimimos no console
    @Override
    public String toString() {
        return nome + " (" + sexo + ")";
    }
}
