package models;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta{

    private final int AGENCIA_PADRAO = 1;
    private static int NUMERO_CONTA = 1;
    protected int agencia, numero, tipo;
    //Tipo 1 = Corrente, Tipo 2 = Poupança
    protected Double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, int tipo){
        this.agencia = AGENCIA_PADRAO;
        this.numero = NUMERO_CONTA++;
        this.tipo = tipo;
        this.saldo = 0d;
        this.cliente = cliente;
    }

    @Override
    public void sacar(Double valor) {
        if (valor <= this.getSaldo()){
            efetuarSaque(valor);
        }
        else
            mensagemFaltaSaldo(valor);
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
        System.out.println("\n== Depósito concluído! ==");

        System.out.println("R$ " + String.format("%.2f", valor) + " adicionados em conta " + getTipoConta() +
                "\nAgradecemos a preferência " + this.getCliente().getNome());
    }

    @Override
    public void transferir(Double valor, Conta contaDestino) {
        if (valor <= this.getSaldo()){
            efetuarTransferencia(valor, contaDestino);
        }
        else
            mensagemFaltaSaldo(valor);
    }

    protected void imprimirInfoConta() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }

    private String getTipoConta(){

        String tipo = "";
        switch (this.getTipo()){
            case 1:
                tipo = "corrente";
                break;
            case 2:
                tipo = "poupança";
                break;
        }
        return tipo;
    }

    private void efetuarSaque(Double valor){
        this.saldo -= valor;
        System.out.println("\n== Saque realizado! ==");

        System.out.println("R$ " + String.format("%.2f", valor) + " deduzidos da conta " + getTipoConta() +
                "\nAgradecemos a preferência " + this.getCliente().getNome());
    }

    private void efetuarTransferencia(Double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("\n== Transferencia realizada com sucesso! ==\nR$ " + String.format("%.2f", valor)
                + " enviados para a conta " + contaDestino.getTipoConta() + " de '" + contaDestino.getCliente().getNome() + "'"
                + "\nSaldo atual: R$ " + String.format("%.2f",this.getSaldo())
                + "\nAgradecemos a preferência " + this.getCliente().getNome());
    }

    private void mensagemFaltaSaldo(Double valor){
        System.out.println("\n== Operação não realizada! ==" + "\nVocê não possuí saldo suficiente" +
                "\nTitular: " + this.cliente.getNome() + "\nTipo de Conta: " + getTipoConta() +
                "\nValor Saldo: R$ " + String.format("%.2f",this.getSaldo()) + "\nValor Operação: R$ " + String.format("%.2f",valor));
    }
}