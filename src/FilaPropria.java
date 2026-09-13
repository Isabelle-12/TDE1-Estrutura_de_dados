public class FilaPropria implements EstruturaDeDados{
    private Pixel[] pixels;
    private int inicio = 0;
    private int fim = -1;

    public FilaPropria(int quantidade) {
        pixels = new Pixel[quantidade];

    }

    public void enfileirar(Pixel p){
        if(fim == pixels.length - 1) return;
        fim++;
        pixels[fim] = p;
    }

    public Pixel desenfileirar(){
        if(inicio > fim) return null;
        Pixel pixelRemovido  = pixels[inicio];
        inicio++;
        return pixelRemovido ;
    }

    @Override
    public boolean estaVazia(){
        return inicio > fim;
    }

    @Override
    public void inserir(Pixel p) {
        enfileirar(p);
    }

    @Override
    public Pixel remover() {
        return desenfileirar();
    }
}
