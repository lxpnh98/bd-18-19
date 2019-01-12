package transformacao;

import java.time.LocalDate;

public class Autor
{
    private String nome;
    private String nat;
    private LocalDate nasc;
    private String sexo;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public Autor()
    {
        this.nome = null;
        this.nat = null;
        this.nasc = null;
        this.sexo = null;
    }
    
    public Autor(String nome, String nat, LocalDate nasc, String sexo)
    {
        this.nome = nome;
        this.nat = nat;
        this.nasc = nasc;
        this.sexo = sexo;
    }
    
    public Autor(Autor autor)
    {
        this.nome = autor.getNome();
        this.nat = autor.getNat();
        this.nasc = autor.getNasc();
        this.nat = autor.getSexo();
    }
    
    //Gets---------------------------------------------------------------------------------------------------------
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getNat()
    {
        return this.nat;
    }
    
    public LocalDate getNasc()
    {
        return this.nasc;
    }
    
    public String getSexo()
    {
        return this.sexo;
    }
    
    //Sets---------------------------------------------------------------------------------------------------------
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setNat(String nat)
    {
        this.nat = nat;
    }
    
    public void setNasc(LocalDate nasc)
    {
        this.nasc = nasc;
    }
    
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }
    
    //Clone---------------------------------------------------------------------------------------------------------
    
    public Autor clone()
    {
        return new Autor(this);
    }
}