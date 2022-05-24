import models.*;

public class Main {
    public static void main(String[] args) {

//        criar banco
        Banco banco = new Banco();

//        criar cliente1 e suas contas
        Cliente cliente1 = new Cliente("Matheus");
        banco.adicionarCliente(cliente1);

//        criar poupança
        Conta cp1 = new ContaPoupanca(cliente1);
        banco.adicionarConta(cp1);

//        criar corrente
        Conta cc1 = new ContaCorrente(cliente1);
        banco.adicionarConta(cc1);

//        deposito
        cc1.depositar(250d);
        banco.atualizarContas(cc1);

//===============================================================

//        criar cliente2 e suas contas
        Cliente cliente2 = new Cliente("Lucas");
        banco.adicionarCliente(cliente2);

//        criar poupança
        Conta cp2 = new ContaPoupanca(cliente2);
        banco.adicionarConta(cp2);

//        criar corrente
        Conta cc2 = new ContaCorrente(cliente2);

//        operações
        cc2.depositar(500d);
        cc2.transferir(250d, cp1);
        banco.atualizarContas(cc2, cp1);

//===============================================================

//        criar cliente3 e suas contas
        Cliente cliente3 = new Cliente("Carla");
        banco.adicionarCliente(cliente3);

//        criar poupança
        Conta cp3 = new ContaPoupanca(cliente3);
        banco.adicionarConta(cp3);

//        criar corrente
        Conta cc3 = new ContaCorrente(cliente3);
        banco.adicionarConta(cc3);

//        operações
        cp3.depositar(150d);
        banco.atualizarContas(cp3);

//===============================================================

//        criar cliente4 e suas contas
        Cliente cliente4 = new Cliente("Joana");
        banco.adicionarCliente(cliente4);

//        criar poupança
        Conta cp4 = new ContaPoupanca(cliente4);
        banco.adicionarConta(cp4);

//        criar corrente
        Conta cc4 = new ContaCorrente(cliente4);
        banco.adicionarConta(cc4);

//        operações
        cc4.depositar(1000d);
        cc4.transferir(1100d, cp3);
        banco.atualizarContas(cc4, cp3);

//===============================================================

//        listar clientes/contas
        banco.listarClientes();
        banco.listarContas();
    }
}