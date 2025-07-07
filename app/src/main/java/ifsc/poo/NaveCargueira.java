package ifsc.poo;

public class NaveCargueira extends NaveEspacial implements Blindada {
    private double cargaAtual;
    private double cargaMaxima;
    private boolean blindagemAtiva;

    public NaveCargueira(double velocidadeMaxima, double cargaMaxima) {
        super(Math.min(velocidadeMaxima, 20), 0); // autônoma
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = 0;
        this.blindagemAtiva = false;
    }

    public void carregar(double quantidade) {
        if (cargaAtual + quantidade <= cargaMaxima) {
            cargaAtual += quantidade;
            System.out.println(identificador() + ": Carga atual = " + cargaAtual);
            if ((cargaAtual / cargaMaxima) > 0.7) {
                ativarBlindagem();
            }
        }
    }

    public void ativarBlindagem() {
        if (!blindagemAtiva) {
            blindagemAtiva = true;
            System.out.println(identificador() + ": Blindagem ativada");
        }
    }


    public void desativarBlindagem() {
        if (velocidadeAtual == 0 && blindagemAtiva) {
            blindagemAtiva = false;
            System.out.println(identificador() + ": Blindagem desativada");
        }
    }


    public void decolar() {
        System.out.println(identificador() + ": Decolando");
    }


    public void pousar() {
        if (velocidadeAtual == 0) {
            System.out.println(identificador() + ": Pousando");
        }
    }


    public void acelerar(double incremento) {
        velocidadeAtual = Math.min(velocidadeAtual + incremento, velocidadeMaxima);
        System.out.println(identificador() + ": Acelerando para " + velocidadeAtual + " Mm/h");
    }


    public void frear(double decremento) {
        velocidadeAtual = Math.max(0, velocidadeAtual - decremento);
        System.out.println(identificador() + ": Reduzindo para " + velocidadeAtual + " Mm/h");
    }
}
