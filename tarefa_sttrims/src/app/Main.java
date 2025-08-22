package app; // esta classe também está no pacote "app"

import java.util.ArrayList;          // lista que cresce (vamos guardar as pessoas aqui)
import java.util.List;               // tipo de lista
import java.util.Scanner;            // para ler o que digitamos no console
import java.util.stream.Collectors;  // para coletar o resultado do filtro (lambda)

// Classe principal do programa
public class Main {
    // Ponto de início do programa
    public static void main(String[] args) {
        // Criamos um leitor para o teclado/console
        Scanner scanner = new Scanner(System.in);

        // Criamos uma lista vazia onde vamos guardar todas as pessoas digitadas
        List<Pessoa> pessoas = new ArrayList<>();

        // Explicamos como o usuário deve digitar
        System.out.println("Digite nomes e sexos separados por vírgula (ex: Maria,F ou João,Masculino).");
        System.out.println("Digite 'sair' quando terminar:");

        // Este laço repete até o usuário digitar 'sair'
        while (true) {
            // Lê uma linha do console
            String linha = scanner.nextLine();

            // Se a pessoa escreveu 'sair', a gente para o laço
            if (linha.equalsIgnoreCase("sair")) {
                break;
            }

            // Ignora linhas em branco (se o usuário só apertar Enter)
            if (linha.trim().isEmpty()) {
                System.out.println("Linha vazia ignorada. Use o formato: Nome,Sexo");
                continue; // volta para o começo do while
            }

            // Separa o que foi digitado usando a vírgula
            String[] partes = linha.split(",");

            // Precisamos ter exatamente 2 partes: nome e sexo
            if (partes.length == 2) {
                // Tiramos espaços extras do começo/fim
                String nome = partes[0].trim();
                String sexo = partes[1].trim();

                // Criamos uma nova Pessoa com o nome e o sexo digitados
                Pessoa p = new Pessoa(nome, sexo);

                // Colocamos essa pessoa dentro da lista
                pessoas.add(p);
            } else {
                // Se não tiver vírgula ou tiver mais de uma, mostramos o formato correto
                System.out.println("Formato inválido. Use: Nome,Sexo  (ex: Ana,F ou Pedro,Masculino)");
            }
        }

        // Agora vamos filtrar SOMENTE as mulheres usando Stream + expressão lambda
        // O examinador pediu para usar if e else dentro da lambda, então vamos fazer isso:
        List<Pessoa> mulheres = pessoas.stream() // ligamos o "rio" de dados da lista
                .filter(p -> {                   // filtro: vamos decidir quem entra na nova lista
                    // Pegamos o sexo dessa pessoa (pode ser "F", "f", "Feminino", etc.)
                    String s = p.getSexo();

                    // Se o sexo for nulo, não é mulher (evita erro)
                    if (s == null) {
                        return false; // else implícito: não entra
                    }

                    // Deixamos o texto limpinho: sem espaços e com letras minúsculas
                    String normalizado = s.trim().toLowerCase();

                    // Aqui usamos if/else como o examinador pediu
                    if (normalizado.equals("f") || normalizado.equals("feminino")) {
                        // Se for "f" ou "feminino", é mulher → fica na lista
                        return true;
                    } else {
                        // Se não for, não é mulher → não entra
                        return false;
                    }
                })
                .collect(Collectors.toList());   // coletamos o resultado e transformamos em nova lista

        // Imprimimos um título bonitinho
        System.out.println("==================================");
        System.out.println("Lista de mulheres encontradas:");

        // Para cada mulher na lista, imprimimos no console
        mulheres.forEach(System.out::println);

        // Fechamos o leitor do teclado
        scanner.close();

        // Mensagem final para saber que acabou
        System.out.println("Fim. Obrigado!");
    }
}
