package com.exemplo.projeto;

public class Validador {

    public boolean isMaiorDeIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade negativa");
        }
        return idade >= 18;
    }

    public boolean isEmailValido(String email) {
        return email != null && email.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");
    }
}
