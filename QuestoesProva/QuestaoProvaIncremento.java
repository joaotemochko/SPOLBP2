package QuestoesProva;

interface Modificador {
    int alterar(int valor);
}

class Incremento implements Modificador {
    private int passo;

    public Incremento(int passo) {
        this.passo = passo;
    }

    @Override
    public int alterar(int valor) {
        return valor + passo;
    }
}

class Fator implements Modificador {
    private int multiplicador;

    public Fator(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public int alterar(int valor) {
        return valor * multiplicador;
    }
}

public class QuestaoProvaIncremento {
    public static void main(String[] args) {
        Modificador m1 = new Incremento(2);
        Modificador m2 = new Fator(3);
        Modificador m3 = new Incremento(5);

        // Atenção ao array: a referência m1 aparece duas vezes!
        Modificador[] fila = {m1, m2, m3, m1};

        int resultado = 1;

        for (Modificador m : fila) {
            resultado = m.alterar(resultado);
        }

        System.out.println(resultado);
    }
}
