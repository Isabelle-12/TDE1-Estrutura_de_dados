public class Pixel {
    //adicionas 2 atributos então pensa em uma imagem ela é separado por colunas e linhas
    private int linha;
    private int coluna;

    //Construtor com parametros então aqui vou falar o valor da minha coluna e da minha linha "contruimos o objeto"
    public Pixel(int coluna, int linha) { //new (2,3)
        this.coluna = coluna;
        this.linha = linha;
    }

    //metodos para ler/pegar os valores
    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
