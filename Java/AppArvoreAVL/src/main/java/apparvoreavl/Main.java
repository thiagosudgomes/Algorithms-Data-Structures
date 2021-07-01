package apparvoreavl;

// Applet: https://www.cs.usfca.edu/~galles/visualization/AVLtree.html        
public class Main {
    public static void main(String[] args) {
        int[] v = {30, 10, 20, 40, 50, 25, 15, 5};
        
        // Preenche a árvore com os números do vetor
        try {
            ArvoreAVL arv = new ArvoreAVL();
            for (int i = 0; i < v.length; i++) {
                arv.insere(v[i]);
            }

            // Imprime a árvore em ordem
            arv.imprimeEmOrdem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
