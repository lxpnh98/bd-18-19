package transformacao;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Livro
{
    private String nome;
    private String resumo;
    private LocalDate data;
    private Genero genero;
    private ArrayList<Genero> generos;
    private Autor autor;
    private ArrayList<Copia> copias;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public Livro()
    {
        this.nome = null;
        this.resumo = null;
        this.data = null;
        this.genero = null;
        this.generos = null;
        this.autor = null;
        this.copias = null;
    }
    
    public Livro(String nome, String resumo, LocalDate data, Genero genero, ArrayList<Genero> generos, Autor autor, ArrayList<Copia> copias)
    {
        this.nome = nome;
        this.resumo = resumo;
        this.data = data;
        this.genero = genero;
        this.generos = generos;
        this.autor = autor;
        this.copias = copias;
    }
    
    public Livro(Livro livro)
    {
        this.nome = livro.getNome();
        this.resumo = livro.getResumo();
        this.data = livro.getData();
        this.genero = livro.getGenero();
        this.generos = livro.getGeneros();
        this.autor = livro.getAutor();
        this.copias = livro.getCopias();
    }
    
    //Gets---------------------------------------------------------------------------------------------------------
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getResumo()
    {
        return this.resumo;
    }
    
    public LocalDate getData()
    {
        return this.data;
    }
    
    public Genero getGenero()
    {
        return this.genero.clone();
    }
    
    public ArrayList<Genero> getGeneros()
    {
        ArrayList<Genero> generos = new ArrayList<Genero>();
        for(Genero genero : this.generos)
            generos.add(genero.clone());
        return generos;
    }
    
    public Autor getAutor()
    {
        return this.autor.clone();
    }
    
    public ArrayList<Copia> getCopias()
    {
        ArrayList<Copia> copias = new ArrayList<Copia>();
        for(Copia copia : this.copias)
            copias.add(copia.clone());
        return copias;
    }
    
    //Sets---------------------------------------------------------------------------------------------------------
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setResumo(String resumo)
    {
        this.resumo = resumo;
    }
    
    public void setData(LocalDate data)
    {
        this.data = data;
    }
    
    public void setGenero(Genero genero)
    {
        this.genero = genero;
    }
    
    public void setGeneros(ArrayList<Genero> generos)
    {
        this.generos = generos;
    }
    
    public void setAutor(Autor autor)
    {
        this.autor = autor;
    }
    
    public void setCopias(ArrayList<Copia> copias)
    {
        this.copias = copias;
    }
    
    /*//Clone---------------------------------------------------------------------------------------------------------
    
    public Livro clone()
    {
        return new Livro(this);
    }*/
}