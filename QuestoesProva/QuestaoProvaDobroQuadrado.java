package QuestoesProva;

interface Operacao {
    int executar(int x);
}

class Dobro implements Operacao {
    @Override
    public int executar(int x) {
        return x * 2;
    }
}

class Quadrado implements Operacao {
    @Override
    public int executar(int x) {
        return x * x;
    }
}

public class QuestaoProvaDobroQuadrado {
    public static void main(String[] args) {
        Operacao[] operacoes = new Operacao[3];
        operacoes[0] = new Dobro();
        operacoes[1] = new Quadrado();
        operacoes[2] = new Dobro();

        int valor = 3;

        for (int i = 0; i < operacoes.length; i++) {
            valor = operacoes[i].executar(valor);
        }

        System.out.println(valor);
    }
}
