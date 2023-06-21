package ProjetoBingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


class Bingo {
    private static final int NUMEROS_TOTAIS = 75;
    private static final int NUMEROS_SORTEIO = 24;

    private Set<Integer> numerosSorteados;
    private List<Cliente> clientes;
    private double rendaTotal;
    private double saldo;

    public Bingo() {
        numerosSorteados = new HashSet<>();
        clientes = new ArrayList<>();
        rendaTotal = 0.0;
        saldo = 0.0;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void cadastrarCliente(String nome, String telefone) {
        if (!nome.matches(".*\\d.*")) {
            if (telefone.matches("\\d+")) {
                Cliente cliente = new Cliente(nome, telefone);
                clientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso.");
            } else {
                System.out.println("Telefone inválido. O telefone deve conter apenas números.");
                System.out.println("Cliente não cadastrado.");
            }
        } else {
            System.out.println("Nome inválido. O nome não pode conter números.");
            System.out.println("Cliente não cadastrado.");
        }
    }

    public void editarCliente(String nome, String novoNome, String novoTelefone) {
        if (!novoNome.matches(".*\\d.*")) {
            if (novoTelefone.matches("\\d+")) {
                Cliente cliente = buscarCliente(nome);
                if (cliente != null) {
                    cliente.setNome(novoNome);
                    cliente.setTelefone(novoTelefone);
                    System.out.println("Cliente editado com sucesso.");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            } else {
                System.out.println("Telefone inválido. O telefone deve conter apenas números.");
                System.out.println("Cliente não cadastrado.");
            }
        } else {
        	
            System.out.println("Nome inválido. O nome não pode conter números.");
            System.out.println("Cliente não cadastrado.");       
            }
        
    }

    public void deletarCliente(String nome) {
        Cliente cliente = buscarCliente(nome);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente deletado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void venderCartela(Cliente cliente) {
        double precoCartela = 10.0; // Preço fixo da cartela
        rendaTotal += precoCartela;
        saldo += precoCartela;
        gerarNumerosCartela(cliente);
    }

    private void gerarNumerosCartela(Cliente cliente) {
        Set<Integer> numerosCartela = new HashSet<>();

        Random random = new Random();
        while (numerosCartela.size() < NUMEROS_SORTEIO) {
            int numero = random.nextInt(NUMEROS_TOTAIS) + 1;
            numerosCartela.add(numero);
            cliente.adicionarNumeroCartela(numero); // Armazena o número na cartela do cliente
        }

        System.out.println("Cartela gerada para o cliente " + cliente.getNome());
        System.out.println("Números vendidos: " + numerosCartela);
    }

    public void realizarSorteio() {
        numerosSorteados.clear();

        Random random = new Random();
        while (numerosSorteados.size() < NUMEROS_SORTEIO) {
            int numero = random.nextInt(NUMEROS_TOTAIS) + 1;
            numerosSorteados.add(numero);
        }

        System.out.println("Sorteio realizado!");
        System.out.println("Números sorteados: " + numerosSorteados);
        calcularVencedores();
    }

    private void calcularVencedores() {
        List<Cliente> vencedores = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (numerosSorteados.containsAll(cliente.getNumerosCartela())) {
                vencedores.add(cliente);
            }
        }

        if (!vencedores.isEmpty()) {
            double premio = rendaTotal * 0.2; // Prêmio é 20% da renda total
            double premioPorVencedor = premio / vencedores.size();

            System.out.println("Vencedores:");
            for (Cliente vencedor : vencedores) {
                System.out.println(vencedor.getNome() + " - Prêmio: R$" + premioPorVencedor);
            }

            saldo -= premio;
        } else {
            System.out.println("Nenhum vencedor desta vez.");
        }
    }

    public double getRendaTotal() {
        return rendaTotal;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }
}