package transformacao;

public class Funcionario
{
    private int id;
    private String nome;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public Funcionario()
    {
        this.id = -1;
        this.nome = null;
    }
    
    public Funcionario(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }
    
    public Funcionario(Funcionario funcionario)
    {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
    }
    
    //Gets---------------------------------------------------------------------------------------------------------
    
    public int getId()
    {
        return this.id;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    //Sets---------------------------------------------------------------------------------------------------------
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    //Clone---------------------------------------------------------------------------------------------------------
    
    public Funcionario clone()
    {
        return new Funcionario(this);
    }
}