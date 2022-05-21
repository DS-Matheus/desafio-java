package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@Getter @EqualsAndHashCode
public class Banco {

    private String nome;
    private Set<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new LinkedHashSet<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public void listarContas(){
        espacoConsole();
        System.out.println("=== Lista de Contas ===");
        for (Conta conta: contas){
            imprimirInfoConta(conta);
        }
    }

    private void imprimirInfoConta(Conta conta) {
        this.verificarTipoConta(conta);
        conta.imprimirInfoConta();
    }

    private void verificarTipoConta(Conta conta){
        switch (conta.getTipo()){
            case 1:
                System.out.println("\n=== Conta Corrente ===");
                break;
            case 2:
                System.out.println("\n=== Conta Poupança ===");
                break;
        }
    }

    public void atualizarContas(Conta conta){
        contas.add(conta);

    }

    public void atualizarContas(Conta conta1, Conta conta2){
        contas.add(conta1);
        contas.add(conta2);
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void listarClientes(){
        espacoConsole();
        System.out.println("=== Lista de Clientes ===\n");

        clientes.sort(new comparatorClientes());
        for(Cliente cliente : clientes){
            System.out.println("--- " + cliente.getNome());
        }
    }

    private class comparatorClientes implements Comparator<Cliente> {

        @Override
        public int compare(Cliente o1, Cliente o2) {
            return o1.getNome().compareToIgnoreCase(o2.getNome());
        }

    }

    public void espacoConsole(){
        for(int i = 0; i < 2; i++){
            System.out.print("\n");
        }
    }
}

