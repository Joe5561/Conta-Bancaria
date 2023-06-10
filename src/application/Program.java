package application;

import entities.Conta;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.print("BEM VINDO, ESCOLHA A OPÇÃO, DIGITE 1 PARA ENTRAR NO SISTEMA OU 0 PARA SAIR: ");
            int opcao;
            String validar = sc.next();
            if (validar.matches("\\d+")) {
                opcao = Integer.parseInt(validar);
            } else {
                System.out.print("ESTE CAMPO NÃO RECEBE CARACTERES, APENAS NÚMEROS");
                System.out.println();
                continue;
            }

            if (opcao == 1) {
                System.out.print("DIGITE O NÚMERO DA CONTA: ");
                int numeroConta;
                String validaNumeroConta = sc.next();
                if (validaNumeroConta.matches("\\d+")) {
                    numeroConta = Integer.parseInt(validaNumeroConta);
                } else {
                    System.out.print("NÚMERO INVÁLIDO");
                    System.out.println();
                    continue;
                }

                System.out.print("ENTRE COM O NOME: ");
                sc.nextLine();
                String nomeConta = sc.nextLine().toUpperCase();
                if (nomeConta.matches("[a-zA-Z]+")) {
                    System.out.print(nomeConta + " ");
                } else {
                    System.out.print("ESTE CAMPO NÃO PODE CONTER NÚMEROS");
                    System.out.println();
                    continue;
                }

                System.out.print("ENTRE COM O CPF: ");
                int cpf;
                String validaCpf = sc.next();
                if (validaCpf.matches("\\d+")) {
                    cpf = Integer.parseInt(validaCpf);
                } else {
                    System.out.print("CPF INVÁLIDO, DIGITE APENAS NÚMEROS NESTE CAMPO");
                    System.out.println();
                    continue;
                }

                System.out.print("INFORME SUA IDADE: ");
                int idade;
                String validarIdade = sc.next();
                if (validarIdade.matches("\\d+")) {
                    idade = Integer.parseInt(validarIdade);
                } else {
                    System.out.print("ERRO, DIGITE APENAS NÚMEROS NESTE CAMPO");
                    System.out.println();
                    continue;
                }

                Conta conta = new Conta(numeroConta, nomeConta, cpf, idade);
                System.out.println();
                System.out.print("SALDO EM CONTA: " + conta.getSaldo() + " " + " NOME: " + conta.getNome()
                        + " " +
                        "CPF: " + conta.getCpf() + " " + "NÚMERO DA CONTA: " + conta.getNumero());
                System.out.println();
                System.out.print("ENTRE COM O VALOR DO DEPÓSITO: ");
                double valorDeposito;
                String validarDeposito = sc.next();
                if (validarDeposito.matches("\\d+")) {
                    valorDeposito = Double.parseDouble(validarDeposito);
                } else {
                    System.out.print("ENTRE APENAS COM VALORES NUMÉRICOS");
                    System.out.println();
                    continue;
                }
                conta.depositar(valorDeposito);

                System.out.println();
                System.out.print("SALDO ATUALIZADO PARA: " + conta.getSaldo() + " NOME: " + conta.getNome() +
                        " NÚMERO DA CONTA: " + conta.getNumero() + " CPF: " + conta.getCpf());
                System.out.println();
                System.out.print("DESEJA EFETUAR UM SAQUE? DIGITE 1 PARA SIM OU 0 PARA NÃO: ");
                int opSaque;
                String validarSaque = sc.next();
                if (validarSaque.matches("\\d+")) {
                    opSaque = Integer.parseInt(validarSaque);
                } else {
                    System.out.print("DIGITE APENAS VALOR NUMÉRICO NESTE CAMPO");
                    System.out.println();
                    continue;
                }

                System.out.println();
                if (opSaque == 1) {
                    System.out.println();
                    System.out.print("DIGITE O VALOR A SER RETIRADO: ");
                    double sacarValor;
                    String validarValor = sc.next();
                    if (validarValor.matches("\\d+")) {
                        sacarValor = Double.parseDouble(validarValor);
                    } else {
                        System.out.print("DIGITE APENAS VALORES NUMÉRICOS NESTE CAMPO");
                        System.out.println();
                        continue;
                    }

                    conta.sacar(sacarValor);
                    System.out.println();
                    System.out.println("SALDO ATUALIZADO PARA: " + conta.getSaldo() +
                            " CPF: " + conta.getCpf() +
                            " NOME: " + conta.getNome() +
                            " IDADE: " + conta.getIdade());
                    System.out.println();
                } else {
                    System.out.println("SALDO ATUAL DE: " + conta.getSaldo() +
                            " CPF: " + conta.getCpf() +
                            " NOME: " + conta.getNome() +
                            " IDADE: " + conta.getIdade());
                }
            } else if (opcao == 0) {
                System.exit(0);
                sc.close();
            } else {
                System.out.println();
                System.out.println("OPÇÃO INVALIDA!!  ESCOLHA 1 PARA INICIAR OU 0 PARA FECHAR O PROGRAMA.");
                System.out.println();
            }
        } while (true);
    }
}
