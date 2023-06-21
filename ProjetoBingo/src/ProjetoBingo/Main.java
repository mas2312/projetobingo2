package ProjetoBingo;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bingo bingo = new Bingo();

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Editar cliente");
            System.out.println("3. Deletar cliente");
            System.out.println("4. Vender cartela");
            System.out.println("5. Realizar sorteio");
            System.out.println("6. Gestão Financeira");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    bingo.cadastrarCliente(nome, telefone);
                    break;
                case 2:
                    System.out.print("Nome do cliente a ser editado: ");
                    String nomeAntigo = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    bingo.editarCliente(nomeAntigo, novoNome, novoTelefone);
                    break;
                case 3:
                    System.out.print("Nome do cliente a ser deletado: ");
                    String nomeDeletar = scanner.nextLine();
                    bingo.deletarCliente(nomeDeletar);
                    break;
                case 4:
                    System.out.print("Nome do cliente para vender a cartela: ");
                    String nomeVender = scanner.nextLine();
                    Cliente clienteVender = bingo.buscarCliente(nomeVender);
                    if (clienteVender != null) {
                        bingo.venderCartela(clienteVender);
                        System.out.println("Cartela vendida com sucesso para o cliente " + clienteVender.getNome());
                    } else {
                        System.out.println("Cliente não encontrado. Deseja cadastrar um novo cliente? (S/N)");
                        String cadastrarNovo = scanner.nextLine();
                        if (cadastrarNovo.equalsIgnoreCase("S")) {
                            System.out.print("Nome do novo cliente: ");
                            String novoNomeCliente = scanner.nextLine();
                            System.out.print("Telefone do novo cliente: ");
                            String novoTelefoneCliente = scanner.nextLine();
                            bingo.cadastrarCliente(novoNomeCliente, novoTelefoneCliente);
                            System.out.println("Cartela vendida com sucesso para o novo cliente.");
                        }
                    }
                    break;
                case 5:
                    bingo.realizarSorteio();
                    break;
                case 6:
                    System.out.println("=== Gestão Financeira ===");
                    System.out.println("Valor arrecadado: R$" + bingo.getRendaTotal());
                    System.out.println("Saldo atual: R$" + bingo.getSaldo());
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}