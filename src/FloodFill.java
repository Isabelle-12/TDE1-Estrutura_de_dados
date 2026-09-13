import java.awt.image.BufferedImage;
import java.io.IOException;

public class FloodFill {
    private GerenciadorImagem gerenciador;
    public FloodFill() {
        gerenciador = new GerenciadorImagem();
    }

    //                    Onde vamos pintar                 onde começamos                  a cor que vamos pintar     Como fazer a pintura por Pilha ou Fila
    public void preencher(BufferedImage imagem,             int linhaInicial, int colunaInicial,        int novaCor,               EstruturaDeDados estrutura) {

        int corDeFundo = gerenciador.lerCor(imagem, colunaInicial, linhaInicial); //guarda a cor original do pixel inicial, antes de qualquer modificação — vai servir de referência pra saber quais pixels ainda fazem parte da área a ser preenchida
        estrutura.inserir(new Pixel(linhaInicial, colunaInicial)); //coloca o pixel inicial dentro da estrutura, para começar o processo

        //enquanto não tiver vazia então ele continua rodando enquanto ainda tiver um pixel esperando para ser pintado
        while (!estrutura.estaVazia()) {

            Pixel atual = estrutura.remover(); //
            int linha = atual.getLinha();
            int coluna = atual.getColuna();


            // está dentro dos limites da imagem
            if (linha < 0 || linha >= imagem.getHeight() || coluna < 0 || coluna >= imagem.getWidth()) {
                continue;
            }

            // a cor desse pixel é igual à cor de fundo original ou ja foi pintada
            int corAtual = gerenciador.lerCor(imagem, coluna, linha);
            if (corAtual != corDeFundo) {
                continue;
            }

            // se passou nas duas checagens pinta o pixel então se esta dentro dos limites da imagem e se a cor foi pintada certa
            gerenciador.pintarPixel(imagem, coluna, linha, novaCor);

            // aqui meio que voce espalha a cor que voce colocou a cor vai para cima, baixo, direita e esquerda
            estrutura.inserir(new Pixel(linha - 1, coluna)); // cima
            estrutura.inserir(new Pixel(linha + 1, coluna)); // baixo
            estrutura.inserir(new Pixel(linha, coluna - 1)); // esquerda
            estrutura.inserir(new Pixel(linha, coluna + 1)); // direita
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
