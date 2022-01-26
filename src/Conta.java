
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected LocalDate dataAbertura;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.dataAbertura = LocalDate.now();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.println(String.format("\nTransferência de %.2f da conta %s para conta %s.", valor, this.numero, contaDestino.getNumero()));
	}

	@Override
	public int getNumero() {
		return numero;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s, Sexo: %s", this.cliente.getNome(), this.cliente.getSexo()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Data de abertura: %s", this.dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

}