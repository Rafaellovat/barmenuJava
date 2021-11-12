package exerciciotres;


public class Funcionario
{
    private String nome;
    private int matricula;
    public Funcionario(String nome, int matricula)
    {
        this.nome = nome;
        this.matricula = matricula;
        System.out.println(String.format("Construtor de Funcionário: %1$s, %2$s", this.nome, this.matricula));
    }
}
