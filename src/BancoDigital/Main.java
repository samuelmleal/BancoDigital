package BancoDigital;

public class Main {

    public static void main(String[] args) {

        Cliente Samuel = new Cliente();
        Samuel.setNome("Samuel");
        Cliente Lucas = new Cliente();
        Lucas.setNome("Lucas");

        Conta cc = new ContaCorrente(Samuel);
        Conta p1 = new ContaPoupança(Lucas);

        cc.depositar(600);
        p1.sacar(30);

        cc.emprestimo(13000);
        p1.transferir(40,cc);

        cc.imprimirExtrato();
        p1.imprimirExtrato();
    }
}
