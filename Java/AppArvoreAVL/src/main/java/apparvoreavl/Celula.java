package apparvoreavl;

public class Celula {

    private int valor;
    private int altura;
    private Celula esquerda;
    private Celula direita;

    public Celula() {
        this.altura = 0;
        this.esquerda = null;
        this.direita = null;
    }

    public Celula(int valor) {
        this.valor = valor;
        this.altura = 0;
        this.esquerda = null;
        this.direita = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Celula getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Celula esquerda) {
        this.esquerda = esquerda;
    }

    public Celula getDireita() {
        return direita;
    }

    public void setDireita(Celula direita) {
        this.direita = direita;
    }
}
