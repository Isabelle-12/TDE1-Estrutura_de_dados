import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GerenciadorImagem {

    public BufferedImage abrirImagem(String caminho) throws IOException{
        File arquivo = new File(caminho);
        BufferedImage imagem = ImageIO.read(arquivo);
        return imagem;
    }

    public int lerCor(BufferedImage imagem, int x, int y){
        return imagem.getRGB(x,y);

    }

    public void pintarPixel(BufferedImage imagem, int x, int y, int novaCor){
        imagem.setRGB(x,y,novaCor);
    }

    public void salvarImagem(BufferedImage imagem, String caminho) throws IOException{
        File arquivoSaida = new File(caminho);
        ImageIO.write(imagem,"png",arquivoSaida);
    }

}
