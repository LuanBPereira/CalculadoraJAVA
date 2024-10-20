import java.io.*;
import java.time.LocalDate;

public class ArquivoService {

    private final static String CAMINHO_ARQUIVO = "operacoes_persistence.txt";
    private final static LocalDate DATA_ATUAL = LocalDate.now();

    public void adicionarEmArquivo(String operacaoFormatada)  {
        try (BufferedWriter arqEscritor = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            // Verifica se a data atual não é igual à de hoje; se não for, exibe a mensagem.
            if (!DATA_ATUAL.equals(LocalDate.now())) {
                System.out.println("\nOperações de: " + DATA_ATUAL);
            }
            arqEscritor.write(operacaoFormatada);
            arqEscritor.newLine();

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void exibirArquivo() {
        File arq = new File(CAMINHO_ARQUIVO);

        if(!arq.exists()) {
            System.out.println("Nenhum arquivo encontrado.");
            return;
        }

        try(BufferedReader arqLeitor = new BufferedReader(new FileReader(arq))) {
            String linha;

            while((linha = arqLeitor.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
