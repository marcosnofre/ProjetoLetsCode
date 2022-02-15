package br.com.letscode.java;

public class ContaBancaria {

    private String nomeCliente;
    private String numConta;
    private double saldo;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "[Dados Bancarios] > " +
                "Nome: '" + nomeCliente + '\'' +
                ", Numero da Conta:  '" + numConta + '\'' +
                ", Saldo = " + saldo;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public boolean sacar(double valor){
        if ((saldo - valor) >= 0){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(ContaBancaria contraTransferencia, double valorTransferencia){
       if (valorTransferencia <= saldo) {
           this.sacar(valorTransferencia);
           contraTransferencia.depositar(valorTransferencia);
           return true;
       }
       return false;
    }

}
