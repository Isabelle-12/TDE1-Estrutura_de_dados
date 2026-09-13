//FILA SIMPLES ARRAY
//FIFO quem entra primeiro sai primeiro

public class FilaPropria implements EstruturaDeDados{
    private Pixel[] pixels;
    private int inicio = 0;
    private int fim = -1;

    public FilaPropria(int quantidade) {
        pixels = new Pixel[quantidade];

    }

    public void enfileirar(Pixel p){
        if(fim == pixels.length - 1) return; //verifica que a fila esta cheia
        fim++; //adicono um elemento na fila então fim = -1 + 1 = 0 vou adiconar o meu elmento no indice 0
        pixels[fim] = p; //aqui estou falando que meu elmento vai ficar no indice 0
    }

    public Pixel desenfileirar(){
        if(inicio > fim) return null; //verifica se a fila esta vazia
        Pixel pixelRemovido  = pixels[inicio]; // Quardo o primeiro elemento da fila pois ele tem o comportamento FIFO
        inicio++; //avanço o ponteiro de início "descartando" a posição que acabou de ser atendida antes estava no 0, agora aponta pro próximo 1
        return pixelRemovido ; //retorna o elmento removido
    }

    @Override
    public boolean estaVazia(){
        return inicio > fim; // ele vai me retornar tru quando a fila estiver vazia e false se ela tiver elementos nela
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
