import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final ArquivoService ARQUIVO_SERVICE = new ArquivoService();
    private static final HistoricoOperacoes HO = new HistoricoOperacoes(ARQUIVO_SERVICE);
    private static final OperacoesMatematicas OP = new OperacoesMatematicas(HO);

    public static void main(String[] args) {
        int escolha;

        do {
            escolha = exibirMenu();
            escolherOpcaoMenu(escolha);
        } while (escolha != 7);

        SCAN.close();
    }

    private static int exibirMenu() {
        int opcaoEscolhida;
        while (true) {
            try {
                System.out.println(
                        """
                        \nCalculadora
                        1 - Somar
                        2 - Subtração
                        3 - Multiplicação
                        4 - Divisão
                        5 - Histórico de operações
                        6 - Exibir operações do arquivo
                        7 - Sair
                        """
                );
                opcaoEscolhida = Integer.parseInt(SCAN.nextLine());
                return opcaoEscolhida;

            } catch (InputMismatchException e) {
                System.out.println("Opção indisponível. Erro: " + e.getMessage());
            }
        }
    }

    private static void escolherOpcaoMenu(int escolha) {
        switch (escolha) {
            case 1:
                OP.somar();
                break;
            case 2:
                OP.subtrair();
                break;
            case 3:
                OP.multiplicar();
                break;
            case 4:
                OP.dividir();
                break;
            case 5:
                HO.exibirHistorico();
                break;
            case 6:
                ARQUIVO_SERVICE.exibirArquivo();
                break;
            case 7:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção indisponível.");
                break;
        }
    }
}
