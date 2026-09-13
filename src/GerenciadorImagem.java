import java.awt.image.BufferedImage; //Representa a imagem carregada na memoria
import java.io.File; //O caminho no disco
import java.io.IOException; //um tipo de erro que pode acontecer ao ler o arquivo
import javax.imageio.ImageIO; // realiza o trabalho de ler e escrever os arquivos das imagens

public class GerenciadorImagem {

    public BufferedImage abrirImagem(String caminho) throws IOException{ // meio que le qunado o arquivo falha dizendo que esta falhando
        File arquivo = new File(caminho); //cria referencia pro arquivo bulgo o seu caminho
        BufferedImage imagem = ImageIO.read(arquivo); // esse ele abre o arquivo e carrega o seu conteudo
        return imagem;
    }

    public int lerCor(BufferedImage imagem, int x, int y){
        return imagem.getRGB(x,y); // x é a coluna e y é a linha
        //é um metodo que vem pronto do BufferedImage ele devolve a cor do pixel especifico, então ele pega a cor por isso o GET
    }

    public void pintarPixel(BufferedImage imagem, int x, int y, int novaCor){
        imagem.setRGB(x,y,novaCor); //Aqui setamos uma nova cor por isso o SET ele escreve a novaCor naquela posição especifica da imagem
    }

    public void salvarImagem(BufferedImage imagem, String caminho) throws IOException{
        File arquivoSaida = new File(caminho);//cria uma reerencia apontando para onde queremos salvar o arquvio
        ImageIO.write(imagem,"png",arquivoSaida); //grava no memoria em formato de png
    }

}
