package edu.betania.dio;

public class Curso extends Conteudos{

    private int cargaHoraria;

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso: " + getTitulo();
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 15d;
    }

}
