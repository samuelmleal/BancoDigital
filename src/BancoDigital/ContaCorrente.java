package BancoDigital;

public class ContaCorrente extends Conta{

    private int divida;


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if(valor<20){
            System.out.println("Não é possível sacar menos de 20 reais. Por favor, coloque outro valor");
        }
        saldo-=valor;
    }

    @Override
    public void depositar(double valor) {
    saldo+=valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    public void emprestimo(int valor){
        System.out.println(" Em quantos meses haverá a quitação da dívida?");
        int meses= scan.nextInt();
        if(valor<3000){
            System.out.println("Não é possível fazer empréstimos de valores inferiores a 3000 reais");
        }
        else if (valor>=3000 && meses<=12){
            saldo=+valor;
            divida = (int) (valor * Math.pow((1+0.15), meses ));
            System.out.println("A divida será de " + divida);
        }
        else if (valor>=10000 && meses<=24){
            saldo+=valor;
            divida=(int) (valor * Math.pow((1+0.20), meses));
            System.out.println("A divida sera de " + divida);
        }
        else{
            System.out.println("Não é possível fazer o empréstimo, por conta do prazo ser muito elevado");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===EXTRATO DA CONTA===");
        System.out.println(String.format("Titular : %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d" , agencia));
        System.out.println(String.format("Conta: %d", numero));
        System.out.println(String.format("Saldo: %.2f" , saldo));
        System.out.println(String.format("Divida: " + divida));
    }
}
