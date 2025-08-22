Testes_Parte1
Tarefa Streams + Teste (Parte 1)

 O que o programa faz
 Lê no console `Nome,Sexo` (ex.: `Maria,F`)
 Usa Stream + lambda para filtrar somente mulheres
Imprime no console a lista de mulheres

 Como rodar
 Execute `Main` (Run 'Main.main()').
 Digite algumas linhas:
 Saída esperada:

3. Saída esperada:
Lista de mulheres:
Maria (F)
Ana   (F)

 Teste JUnit (Parte 1)
 Classe: `src/test/java/app/tests/part1/FiltroMulheresTest.java`
 O teste chama `FiltroMulheres.filtrarMulheres()` e garante que:
 a lista **não está vazia**
  todas as pessoas da lista têm sexo  F ou Feminino

Para rodar o teste: Run FiltroMulheresTest

 Tecnologias
 Java 11
 JUnit 5 (org.junit.jupiter 5.8.2)

