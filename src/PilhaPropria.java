//PILHA SIMPLES ARRAY
//LIFO quem entra por ultimo sai por primeiro

public class PilhaPropria {
    private Pixel[] pixels;
    private int topo = 0;

    public PilhaPropria(int capacidade) {
        pixels = new Pixel[capacidade]; // crio o array de verdade, já com o tamanho máximo que ele vai precisar
        // (a capacidade recebida por fora, ex: largura * altura da imagem) — reservo esse espaço
        // todo de uma vez, e ele não muda de tamanho depois.
    }

    //adicionando um pixel
    public void empilhar(Pixel p){
        if(topo == pixels.length) return; //então ele verifica se ja não esta ce=heia sua pilha
        pixels[topo] = p; //aqui estou dizendo que pixels[0] = p significa que esse pixel que eu coloquei esta no indice 0
        topo++; // aqui eu incremento então topo = topo + 1 -> topo = 0 + 1, estou dizendo que agora o meu proximo topo é no inidice 1
    }

    //retirando um pixel
    public Pixel desempilhar(){
        if(topo == 0) return null; //veirifico se minha pilha esta vazia
        topo--; // topo = topo - 1 então topo = 1 - 1 topo = 0, o que sinfica que o elemnto que vamos tirar da nossa pilha é o do indice 0
        return pixels[topo]; //ele esta me retornando o elemento do indece 0
    }

    public  boolean estaVazia(){
        return topo == 0; // verifica se topo é igual a 0, ou seja,
        // se não tem nenhum elemento guardado;
        // retorna um boolean: true se estiver vazia (topo == 0), false se tiver pelo menos 1 elemento guardado
    }
}
