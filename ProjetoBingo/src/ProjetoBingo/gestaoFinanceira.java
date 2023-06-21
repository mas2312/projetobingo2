package ProjetoBingo;
import java.util.ArrayList;
import java.util.List;
class gestaoFinanceira {
    private double valorArrecadado;
    private double saldo;
    private List<Transacao> transacoes;

    public gestaoFinanceira() {
        valorArrecadado = 0.0;
        saldo = 0.0;
        transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(String descricao, double valor) {
        Transacao transacao = new Transacao(descricao, valor);
        transacoes.add(transacao);
        saldo += valor;
        if (valor > 0) {
            valorArrecadado += valor;
        }
    }

    public void mostrarBalanca() {
        System.out.println("=== Balanço Financeiro ===");
        System.out.println("Valor arrecadado: R$" + valorArrecadado);
        System.out.println("Saldo atual: R$" + saldo);
        System.out.println("Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao.getDescricao() + " - R$" + transacao.getValor());
        }
        System.out.println("===========================");
    }
}
