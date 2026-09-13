
import java.awt.image.BufferedImage;

public class FloodFill {
    private GerenciadorImagem gerenciador;

    public FloodFill() {
        gerenciador = new GerenciadorImagem();
    }

    public void preencher(BufferedImage imagem, int linhaInicial, int colunaInicial, int novaCor, EstruturaDeDados estrutura) {
        int corDeFundo = gerenciador.lerCor(imagem, colunaInicial, linhaInicial);
        estrutura.inserir(new Pixel(linhaInicial, colunaInicial));

        while (!estrutura.estaVazia()) {
            Pixel atual = estrutura.remover();

            int linha = atual.getLinha();
            int coluna = atual.getColuna();

            // está dentro dos limites da imagem
            if (linha < 0 || linha >= imagem.getHeight() || coluna < 0 || coluna >= imagem.getWidth()) {
                continue;
            }

            // a cor desse pixel é igual à cor de fundo original
            int corAtual = gerenciador.lerCor(imagem, coluna, linha);
            if (corAtual != corDeFundo) {
                continue;
            }

            // se passou nas duas checagens pinta o pixel
            gerenciador.pintarPixel(imagem, coluna, linha, novaCor);

            // insere os 4 vizinhos (cima, baixo, esquerda, direita)
            estrutura.inserir(new Pixel(linha - 1, coluna)); // cima
            estrutura.inserir(new Pixel(linha + 1, coluna)); // baixo
            estrutura.inserir(new Pixel(linha, coluna - 1)); // esquerda
            estrutura.inserir(new Pixel(linha, coluna + 1)); // direita
        }
    }
}