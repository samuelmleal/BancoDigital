package BancoDigital;

import java.util.Scanner;

public abstract class Conta implements IConta {

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    Scanner scan = new Scanner(System.in);

    protected static final int AGENCIA_PADRAO=1;

    protected static int SEQUENCIAL=1;

    public Conta(Cliente cliente){
        this.agencia=Conta.AGENCIA_PADRAO;
        this.numero=SEQUENCIAL++;
        this.cliente=cliente;
    }

    public void sacar(double valor){
        if(valor<20){
            System.out.println("Não é possível sacar menos de 20 reais. Por favor, coloque outro valor");
        }
        saldo -=valor;
    }

    public void depositar(double valor){
        saldo+=valor;
    }

    public void emprestimo(int valor){
        System.out.println(" Em quantos meses haverá a quitação da dívida?");
        int meses=scan.nextInt();
        if(valor<3000){
            System.out.println("Não é possível fazer empréstimos de valores inferiores a 3000 reais");
        }
        else if (valor>=3000 && meses<=12){
            saldo=+valor;
            int divida = (int) (valor * Math.pow((1+0.15), 12));
            System.out.println("A divida será de " + divida);
        }
        else if (valor>=10000 && meses<=24){
            saldo+=valor;
            int divida=(int) (valor * Math.pow((1+0.20), 24));
            System.out.println("A divida sera de " + divida);
        }
        else{
            System.out.println("Não é possível fazer o empréstimo, por conta do prazo ser muito elevado");
        }
    }

    public void transferir(double valor, Conta contaDestino){
        sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
