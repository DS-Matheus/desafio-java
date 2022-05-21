package models;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente, 1);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato - Conta Corrente ===");
        super.imprimirInfoConta();
    }

}
