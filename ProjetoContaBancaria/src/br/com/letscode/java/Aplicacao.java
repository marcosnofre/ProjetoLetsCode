package br.com.letscode.java;

public class Aplicacao {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("*** Deposito e Saque Conta Corrente ***");

        ContaBancaria contaCorrente = new ContaBancaria();
        contaCorrente.setNomeCliente("Everton Luis");
        contaCorrente.setNumConta("111111");

        contaCorrente.depositar(100);

        realizarSaque(contaCorrente, 50);

        realizarSaque(contaCorrente, 70);

        System.out.println(contaCorrente);

        System.out.println();
        System.out.println("*** Deposito e Saque Conta Poupança ***");

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setNomeCliente("Jose Araujo");
        contaPoupanca.setNumConta("22222");
        //Colocar o dia atual para testar o rendimento
        contaPoupanca.setDiaRendimento(14);

        contaPoupanca.depositar(100);

        realizarSaque(contaPoupanca, 50);

        realizarSaque(contaPoupanca, 70);

        if(contaPoupanca.calcularNovoSaldo(0.5)){
            System.out.println("Rendimento Aplicado, Novo saldo é de: " +
                    contaPoupanca.getSaldo());
        }else{
            System.out.println("Hoje não é dia de rendimento, novo saldo não calculado");
        }

        System.out.println(contaPoupanca);

        System.out.println();
        System.out.println("*** Transferencia entre contas ***");

        System.out.println("Transferencia no valor de 10.00 da conta de: " +
                contaPoupanca.getNomeCliente() + ". Saldo: " + contaPoupanca.getSaldo());

        contaPoupanca.transferir(contaCorrente, 10.00);
        System.out.println("Novo saldo da Conta Poupança é de: " +
                contaPoupanca.getSaldo());

        System.out.println("Transferencia recebida no valor de 10.00");
        System.out.println("Novo saldo da Conta Corrente de: " +
                contaCorrente.getNomeCliente() + " é: " +
                contaCorrente.getSaldo());

    }

    private static void realizarSaque(ContaBancaria conta, double valor){
        if (conta.sacar(valor)){
            System.out.println("Saque efetuado com sucesso, novo saldo = " +
                    conta.getSaldo());
        }else {
            System.out.println("Saldo insuficiente para saque de " +
                    valor + " Saldo:  " +
                    conta.getSaldo());
        }
    }

}
