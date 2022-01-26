
public class Main {

	public static void main(String[] args) {
		Cliente clienteVenilton = new Cliente("Venilton", "M");
		Cliente clienteSueelen = new Cliente("Sueelen", "F");
		
		Conta contaCorrenteVenilton = new ContaCorrente(clienteVenilton);
		Conta contaPoupancaVenilton = new ContaPoupanca(clienteVenilton);

		Conta contaCorrenteSueelen = new ContaCorrente(clienteSueelen);
		Conta contaPoupancaSueelen = new ContaPoupanca(clienteSueelen);


		contaCorrenteVenilton.depositar(100);
		contaCorrenteVenilton.transferir(100, contaPoupancaVenilton);
		contaCorrenteVenilton.imprimirExtrato();
		contaPoupancaVenilton.imprimirExtrato();

		contaPoupancaVenilton.transferir(100, contaPoupancaSueelen);
		contaPoupancaVenilton.imprimirExtrato();
		contaPoupancaSueelen.imprimirExtrato();
		contaPoupancaSueelen.transferir(50, contaCorrenteSueelen);
		contaCorrenteSueelen.imprimirExtrato();

	}

}
