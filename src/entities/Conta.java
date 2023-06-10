package entities;

public class Conta {

    private int numero;
    private String nome;
    private int cpf;
    private double saldo;
    private int idade;


    public Conta() {
    }

    public Conta(Integer numero, String nome, int cpf, Double saldoInicial) {
        this.numero = numero;
        this.nome = nome;
        this.cpf = cpf;
        depositar(saldoInicial);
    }

    public Conta(Integer numero, String nome, int cpf, int idade) {
        this.numero = numero;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public Double getSaldo() {
        return saldo;
    }

    public int getIdade() {
        return idade;
    }

    public void depositar(double quantia) {
        saldo += quantia;
        if (quantia >= 10000) {
            double acrescimo = quantia * 0.01;
            saldo += acrescimo;
        }
    }

    public void sacar(double quantia) {
        saldo -= quantia + 5.0;
        if (idade >= 60){
            double desconto = quantia * 0.10;
            saldo += desconto;
        }
    }

    @Override
    public String toString() {
        return
                "Número: " + numero +
                        ", Nome: " + nome +
                        ", Saldo: " + String.format("%.2f", saldo) +
                        ", CPF: " + cpf
                ;
    }
}