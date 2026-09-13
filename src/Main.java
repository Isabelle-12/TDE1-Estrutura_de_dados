import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GerenciadorImagem gerenciador = new GerenciadorImagem();
        FloodFill floodFill = new FloodFill();

        // Configurações do processamento
        String imagemEntradaPilha = "src/imagens/PILHA.png";
        String imagemEntradaFila = "src/imagens/Fila.png";
        int linhaInicial = 5;
        int colunaInicial = 5;
        int novaCor = 0xFFFF69B4; // rosa
        int intervaloFrames = 2000;

        // ---- Processamento com Pilha ----
        System.out.println("Processando com Pilha...");
        BufferedImage imagemPilha = gerenciador.abrirImagem(imagemEntradaPilha);
        EstruturaDeDados pilha = new PilhaPropria(imagemPilha.getWidth() * imagemPilha.getHeight() * 4);
        floodFill.preencherComAnimacao(imagemPilha, linhaInicial, colunaInicial, novaCor, pilha, "src/imagens/frames_pilha", intervaloFrames);
        gerenciador.salvarImagem(imagemPilha, "src/imagens/resultado_pilha.png");
        System.out.println("Concluído! Resultado salvo em resultado_pilha.png");

        // ---- Processamento com Fila ----
        System.out.println("Processando com Fila...");
        BufferedImage imagemFila = gerenciador.abrirImagem(imagemEntradaFila);
        EstruturaDeDados fila = new FilaPropria(imagemFila.getWidth() * imagemFila.getHeight() * 4);
        floodFill.preencherComAnimacao(imagemFila, linhaInicial, colunaInicial, novaCor, fila, "src/imagens/frames_fila", intervaloFrames);
        gerenciador.salvarImagem(imagemFila, "src/imagens/resultado_fila.png");
        System.out.println("Concluído! Resultado salvo em resultado_fila.png");

    }
}