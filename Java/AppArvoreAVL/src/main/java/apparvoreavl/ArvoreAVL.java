package apparvoreavl;

public class ArvoreAVL {

    private int altura;
    private Celula raiz;

    public ArvoreAVL() {
        this.altura = 0;
        this.raiz = null;
    }

    public int getAltura() {
        return this.altura;
    }

    private void setAltura(int altura) {
        this.altura = altura;
    }

    public void insere(int valor) {
        this.raiz = this.insere(this.raiz, valor);
    }

    private Celula insere(Celula no, int valor) {
        if (no == null) {
            return new Celula(valor);
        }

        if (valor < no.getValor()) {
            no.setEsquerda(insere(no.getEsquerda(), valor));
        } else if (valor > no.getValor()) {
            no.setDireita(insere(no.getDireita(), valor));
        } else {
            return no;
        }

        no.setAltura(1 + calculaMaiorAltura(no.getEsquerda(), no.getDireita()));

        int fb = calculaFatorBalanceamento(no);

        // Rotação simples à esquerda
        if (fb < -1 && valor > no.getDireita().getValor()) {
            return rotacaoEsquerda(no);
        }
        // Rotação simples à direita
        if (fb > 1 && valor < no.getEsquerda().getValor()) {
            return rotacaoDireita(no);
        }
        // Rotação dupla esquerda-direita
        if (fb > 1 && valor > no.getEsquerda().getValor()) {
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }
        // Rotação dupla direita-esquerda
        if (fb < -1 && valor < no.getDireita().getValor()) {
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private Celula rotacaoEsquerda(Celula no) {
        Celula aux = no.getDireita();
        Celula t = aux.getEsquerda();

        // Executa a rotação
        aux.setEsquerda(no);
        no.setDireita(t);

        // Atualiza as alturas
        no.setAltura(1 + this.calculaMaiorAltura(no.getEsquerda(), no.getDireita()));
        aux.setAltura(1 + this.calculaMaiorAltura(aux.getEsquerda(), aux.getDireita()));

        return aux;
    }

    private Celula rotacaoDireita(Celula no) {
        Celula aux = no.getEsquerda();

        // Executa a rotação
        no.setDireita(aux);
        aux.setEsquerda(no.getDireita());

        // Atualiza as alturas
        no.setAltura(1 + this.calculaMaiorAltura(no.getEsquerda(), no.getDireita()));
        aux.setAltura(1 + this.calculaMaiorAltura(aux.getEsquerda(), aux.getDireita()));

        return aux;
    }

    public void imprimeEmOrdem() {
        imprimeEmOrdem(this.raiz);
    }

    private void imprimeEmOrdem(Celula no) {
        if (no != null) {
            imprimeEmOrdem(no.getEsquerda());
            System.out.println(no.getValor());
            imprimeEmOrdem(no.getDireita());
        }
    }

    private int calculaMaiorAltura(Celula e, Celula d) {
        int alturaEsquerda = e != null ? e.getAltura() : 0;
        int alturaDireita = d != null ? d.getAltura() : 0;
        return alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;
    }

    private int calculaFatorBalanceamento(Celula no) {
        if (no != null) {
            int alturaEsquerda = no.getEsquerda() != null ? no.getEsquerda().getAltura() : 0;
            int alturaDireita = no.getDireita() != null ? no.getDireita().getAltura() : 0;
            return alturaEsquerda - alturaDireita;
        }
        return 0;
    }
}
