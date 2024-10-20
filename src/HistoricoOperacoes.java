import java.util.ArrayList;
import java.util.List;

public class HistoricoOperacoes {

    private List<Operacao> historico = new ArrayList<>();
    private  ArquivoService arquivoService;

    public HistoricoOperacoes(ArquivoService arqService) {
        this.arquivoService = arqService;
    }

    public void adicionarOperacao(String tipoOperacao, double valor1, double valor2, double resultado) {
        if(historico.size() == 5) {
            historico.removeFirst();
            // remove o primeiro elemento caso passar de 5 operações
        }

        Operacao novaOperacao = new Operacao(tipoOperacao, valor1, valor2, resultado);
        historico.add(novaOperacao);
        arquivoService.adicionarEmArquivo(novaOperacao.formatarOperacao());
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }

        System.out.println("Histórico de operações:");
        for (Operacao op : historico) {
            System.out.println(op.formatarOperacao());
        }
    }

    public static class Operacao {
        public enum TipoOperacao { SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, DESCONHECIDA }

        private TipoOperacao tipoOperacao;
        private double a;
        private double b;
        private double resultado;

        public Operacao(String tipoOperacao, double a, double b, double resultado) {
            this.tipoOperacao = stringParaTipoOperacao(tipoOperacao);
            this.a = a;
            this.b = b;
            this.resultado = resultado;
        }

        public TipoOperacao stringParaTipoOperacao(String tipo) {
            try {
                return TipoOperacao.valueOf(tipo.toUpperCase());
            } catch (IllegalArgumentException e) {
                return TipoOperacao.DESCONHECIDA;
            }
        }

        public String formatarOperacao() {
            return switch (tipoOperacao) {
                case SOMA -> String.format("Soma: %.2f + %.2f = %.2f", a, b, resultado);
                case SUBTRACAO -> String.format("Subtração: %.2f - %.2f = %.2f", a, b, resultado);
                case MULTIPLICACAO -> String.format("Multiplicação: %.2f * %.2f = %.2f", a, b, resultado);
                case DIVISAO -> String.format("Divisão: %.2f / %.2f = %.2f", a, b, resultado);
                default -> "Operação desconhecida";
            };
        }
    }
}
