package transformacao;

public class Utilizador
{
    private int id;
    private String nome;
    private String email;
    private String contacto;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public Utilizador()
    {
        this.id = -1;
        this.nome = null;
        this.email = null;
        this.contacto = null;
    }
    
    public Utilizador(int id, String nome, String email, String contacto)
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.contacto = contacto;
    }
    
    public Utilizador(Utilizador utilizador)
    {
        this.id = utilizador.getId();
        this.nome = utilizador.getNome();
        this.email = utilizador.getEmail();
        this.contacto = utilizador.getContacto();
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
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getContacto()
    {
        return this.contacto;
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
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setContacto(String contacto)
    {
        this.contacto = contacto;
    }
    
    //Clone---------------------------------------------------------------------------------------------------------
    
    public Utilizador clone()
    {
        return new Utilizador(this);
    }
}
