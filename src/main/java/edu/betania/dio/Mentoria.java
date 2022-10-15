package edu.betania.dio;


public class Mentoria extends Conteudos{

    @Override
    public String toString() {
        return "Mentoria: " + getDescricao();
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 5d;
    }
}
