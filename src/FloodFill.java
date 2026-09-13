import java.awt.image.BufferedImage;
import java.io.IOException;

public class FloodFill {
    private GerenciadorImagem gerenciador;
    public FloodFill() {
        gerenciador = new GerenciadorImagem();
    }


    public void preencher(BufferedImage imagem,int linhaInicial, int colunaInicial,int novaCor,EstruturaDeDados estrutura) {

        int corDeFundo = gerenciador.lerCor(imagem, colunaInicial, linhaInicial);
        estrutura.inserir(new Pixel(linhaInicial, colunaInicial));


        while (!estrutura.estaVazia()) {

            Pixel atual = estrutura.remover(); //
            int linha = atual.getLinha();
            int coluna = atual.getColuna();


            if (linha < 0 || linha >= imagem.getHeight() || coluna < 0 || coluna >= imagem.getWidth()) {
                continue;
            }


            int corAtual = gerenciador.lerCor(imagem, coluna, linha);
            if (corAtual != corDeFundo) {
                continue;
            }

            gerenciador.pintarPixel(imagem, coluna, linha, novaCor);


            estrutura.inserir(new Pixel(linha - 1, coluna));
            estrutura.inserir(new Pixel(linha + 1, coluna));
            estrutura.inserir(new Pixel(linha, coluna - 1));
            estrutura.inserir(new Pixel(linha, coluna + 1));
        }
    }

    public void preencherComAnimacao(BufferedImage imagem, int linhaInicial, int colunaInicial, int novaCor, EstruturaDeDados estrutura, String pastaSaida, int intervaloFrames) throws IOException {
        int corDeFundo = gerenciador.lerCor(imagem, colunaInicial, linhaInicial);
        estrutura.inserir(new Pixel(linhaInicial, colunaInicial));

         int contador = 0;
         int numeroFrame = 0;

            while (!estrutura.estaVazia()) {

                Pixel atual = estrutura.remover();
                int linha = atual.getLinha();
                int coluna = atual.getColuna();

                if (linha < 0 || linha >= imagem.getHeight() || coluna < 0 || coluna >= imagem.getWidth()) {
                    continue;
                }

                int corAtual = gerenciador.lerCor(imagem, coluna, linha);
                if (corAtual != corDeFundo) {
                    continue;
                }

                gerenciador.pintarPixel(imagem, coluna, linha, novaCor);

                contador++;
                if (contador % intervaloFrames == 0) {
                    numeroFrame++;
                    gerenciador.salvarImagem(imagem, pastaSaida + "/frame_" + numeroFrame + ".png");
                }

                estrutura.inserir(new Pixel(linha - 1, coluna));
                estrutura.inserir(new Pixel(linha + 1, coluna));
                estrutura.inserir(new Pixel(linha, coluna - 1));
                estrutura.inserir(new Pixel(linha, coluna + 1));
            }
        }
    }
