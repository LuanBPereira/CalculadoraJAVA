import java.util.Scanner;

public class OperacoesMatematicas {

    private HistoricoOperacoes historicoOperacoes;
    private static final Scanner SCAN = new Scanner(System.in);

    public OperacoesMatematicas(HistoricoOperacoes historicoOperacoes) {
        this.historicoOperacoes = historicoOperacoes;

    }

    public void somar() {
        double[] numeros = entradaValores();
        double resultado = numeros[0] + numeros[1];

        System.out.printf("O resultado da soma é: %.2f\n", resultado);
        historicoOperacoes.adicionarOperacao("soma", numeros[0], numeros[1], resultado);
    }

    public void subtrair() {
        double[] numeros = entradaValores();
        double resultado = numeros[0] - numeros[1];

        System.out.printf("O resultado da subtração é: %.2f\n", resultado);
        historicoOperacoes.adicionarOperacao("subtracao", numeros[0], numeros[1], resultado );
    }

    public void multiplicar() {
        double[] numeros = entradaValores();
        double resultado = numeros[0] * numeros[1];

        System.out.printf("O resultado da multiplicação é: %.2f\n", resultado);
        historicoOperacoes.adicionarOperacao("multiplicacao", numeros[0], numeros[1], resultado );
    }

    public void dividir() {
        double[] numeros = entradaValores();

        if (numeros[1] == 0) {
            System.out.println("Erro: Divisão por zero não é permitida.");
            return;
        }

        double resultado = numeros[0] / numeros[1];

        System.out.printf("O resultado da divisão é: %.2f\n", resultado);
        historicoOperacoes.adicionarOperacao("divisao", numeros[0], numeros[1], resultado );
    }

    public double[] entradaValores() {
        boolean continuar = true;
        double a = 0;
        double b = 0;

        while (continuar) {
             try {
                 System.out.println("Digite o primeiro número: ");
                 a = Double.parseDouble(SCAN.nextLine());

                 System.out.println("Digite o segundo número: ");
                 b = Double.parseDouble(SCAN.nextLine());

                 continuar = false;
             } catch (NumberFormatException e) {
                 System.out.println("Entrada inválida. Erro: " + e.getMessage());
             }
        }

        return new double[] {a , b};
    }

}
