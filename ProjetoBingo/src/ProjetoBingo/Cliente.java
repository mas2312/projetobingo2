package ProjetoBingo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Cliente {
    private String nome;
    private String telefone;
    private List<Integer> numerosCartela;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.numerosCartela = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Integer> getNumerosCartela() {
        return numerosCartela;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void adicionarNumeroCartela(int numero) {
        numerosCartela.add(numero);
    }
}