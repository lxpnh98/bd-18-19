package transformacao;

import java.time.LocalDate;

public class RequisicaoLivro
{
    private int id;
    private LocalDate dataReq;
    private LocalDate dataEnt;
    private int prazo;
    private double taxa;
    private Copia livroReq;
    private Funcionario func;
    private Utilizador uti;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public RequisicaoLivro()
    {
        this.id = -1;
        this.dataReq = null;
        this.dataEnt = null;
        this.prazo = 0;
        this.taxa = 0;
        this.livroReq = null;
        this.func = null;
        this.uti = null;
    }
    
    public RequisicaoLivro(int id, LocalDate dataReq, LocalDate dataEnt, int prazo, double taxa, Copia livroReq, Funcionario func, Utilizador uti)
    {
        this.id = id;
        this.dataReq = dataReq;
        this.dataEnt = dataEnt;
        this.prazo = prazo;
        this.taxa = taxa;
        this.livroReq = livroReq;
        this.func = func;
        this.uti = uti;
    }
    
    public RequisicaoLivro(RequisicaoLivro requisicaoLivro)
    {
        this.id = requisicaoLivro.getId();
        this.dataReq = requisicaoLivro.getDataReq();
        this.dataEnt = requisicaoLivro.getDataEnt();
        this.prazo = requisicaoLivro.getPrazo();
        this.taxa = requisicaoLivro.getTaxa();
        this.livroReq = requisicaoLivro.getLivroReq();
        this.func = requisicaoLivro.getFunc();
        this.uti = requisicaoLivro.getUti();
    }
    
    //Gets---------------------------------------------------------------------------------------------------------
    
    public int getId()
    {
        return this.id;
    }
    
    public LocalDate getDataReq()
    {
        return this.dataReq;
    }
    
    public LocalDate getDataEnt()
    {
        return this.dataEnt;
    }
    
    public int getPrazo()
    {
        return this.prazo;
    }
    
    public double getTaxa()
    {
        return this.taxa;
    }
    
    public Copia getLivroReq()
    {
        return this.livroReq.clone();
    }
    
    public Funcionario getFunc()
    {
        return this.func.clone();
    }
    
    public Utilizador getUti()
    {
        return this.uti.clone();
    }
    
    //Sets---------------------------------------------------------------------------------------------------------
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setDataReq(LocalDate dataReq)
    {
        this.dataReq = dataReq;
    }
    
    public void setDataEnt(LocalDate dataEnt)
    {
        this.dataEnt = dataEnt;
    }
    
    public void setPrazo(int prazo)
    {
        this.prazo = prazo;
    }
    
    public void setTaxa(double taxa)
    {
        this.taxa = taxa;
    }
    
    public void setLivroReq(Copia livroReq)
    {
        this.livroReq = livroReq;
    }
    
    public void setFunc(Funcionario func)
    {
        this.func = func;
    }
    
    public void setUti(Utilizador uti)
    {
        this.uti = uti;
    }
    
    //Clone---------------------------------------------------------------------------------------------------------
    
    public RequisicaoLivro clone()
    {
        return new RequisicaoLivro(this);
    }
}