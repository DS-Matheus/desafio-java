package models;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta{

    private final int AGENCIA_PADRAO = 1;
    private int NUMERO_CONTA = 1;
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
        this.saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(Double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfoConta() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }

}