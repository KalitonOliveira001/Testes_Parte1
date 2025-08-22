import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import app.Pessoa;

public class TesteMulheres {

    @Test
    public void deveConterSomenteMulheres() {
        // Criando lista de pessoas (igual ao Main)
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Ana", "F"),
                new Pessoa("Maria", "F"),
                new Pessoa("Carlos", "M"),
                new Pessoa("Joana", "F"),
                new Pessoa("Pedro", "M")
        );

        // Filtrar somente mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        // Verificar que TODAS na lista filtrada são mulheres
        boolean somenteMulheres = mulheres.stream()
                .allMatch(p -> p.getSexo().equalsIgnoreCase("F"));

        // Teste: se houver algum homem, o teste vai falhar
        assertTrue("A lista contém alguém que não é mulher!", somenteMulheres);
    }
}
