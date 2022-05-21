import models.*;

public class Main {
    public static void main(String[] args) {

//        criar banco
        Banco banco1 = new Banco("Bradesco");

//        criar cliente1 e suas contas
        Cliente cliente1 = new Cliente("Matheus");
        banco1.adicionarCliente(cliente1);

//        criar poupança
        Conta cp1 = new ContaPoupanca(cliente1);
        banco1.adicionarConta(cp1);

//        criar corrente
        Conta cc1 = new ContaCorrente(cliente1);
        banco1.adicionarConta(cc1);

//        deposito
        cc1.depositar(250d);
        banco1.atualizarContas(cc1);

//===============================================================

//        criar cliente2 e suas contas
        Cliente cliente2 = new Cliente("Lucas");
        banco1.adicionarCliente(cliente2);

//        criar poupança
        Conta cp2 = new ContaPoupanca(cliente2);
        banco1.adicionarConta(cp2);

//        criar corrente
        Conta cc2 = new ContaCorrente(cliente2);
        banco1.adicionarConta(cc2);

//        operações
        cc2.depositar(500d);
        cc2.transferir(250d, cp1);
        banco1.atualizarContas(cc2, cp1);

//        listar clientes/contas
        banco1.listarClientes();
        banco1.listarContas();
    }
}