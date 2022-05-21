package models;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente, 2);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato - Conta Poupança ===");
        super.imprimirInfoConta();
    }

}
