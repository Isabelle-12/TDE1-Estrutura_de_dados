public class PilhaPropria implements EstruturaDeDados{
    private Pixel[] pixels;
    private int topo = 0;

    public PilhaPropria(int capacidade) {
        pixels = new Pixel[capacidade];

    }


    public void empilhar(Pixel p){
        if(topo == pixels.length) return;
        pixels[topo] = p;
        topo++;
    }


    public Pixel desempilhar(){
        if(topo == 0) return null;
        topo--;
        return pixels[topo];
    }

    @Override
    public  boolean estaVazia(){
        return topo == 0;
    }

    @Override
    public void inserir(Pixel p) {
        empilhar(p);
    }

    @Override
    public Pixel remover() {
        return desempilhar();
    }
}
