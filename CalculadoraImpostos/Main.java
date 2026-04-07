package CalculadoraImpostos;

// 1. Interface Comum
interface ImpostoStrategy {
    double calcular(double valor);
}

// 2. Estratégias Concretas
class Icms implements ImpostoStrategy {
    @Override
    public double calcular(double valor) { return valor * 0.18; }
}

class Iss implements ImpostoStrategy {
    @Override
    public double calcular(double valor) { return valor * 0.05; }
}

// 3. Contexto
class CalculadoraImposto {
    public double calcular(double valor, ImpostoStrategy imposto) {
        return imposto.calcular(valor);
    }
}

// 4. Método Main
public class Main {
    public static void main(String[] args) {
        CalculadoraImposto calc = new CalculadoraImposto();
        double valorVenda = 100.0;

        double valorIcms = calc.calcular(valorVenda, new Icms());
        double valorIss = calc.calcular(valorVenda, new Iss());

        System.out.println("Valor do ICMS: R$ " + valorIcms);
        System.out.println("Valor do ISS: R$ " + valorIss);
    }
}