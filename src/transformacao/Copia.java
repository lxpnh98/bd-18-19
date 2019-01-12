package transformacao;

public class Copia
{
    private int id;
    private String estado;
    private boolean req;
    private int edicao;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public Copia()
    {
        this.id = -1;
        this.estado = null;
        this.req = false;
        this.edicao = 0;
    }
    
    public Copia(int id, String estado, boolean req, int edicao)
    {
        this.id = id;
        this.estado = estado;
        this.req = req;
        this.edicao = edicao;
    }
    
    public Copia(Copia copia)
    {
        this.id = copia.getId();
        this.estado = copia.getEstado();
        this.req = copia.getReq();
        this.edicao = copia.getEdicao();
    }
    
    //Gets---------------------------------------------------------------------------------------------------------
    
    public int getId()
    {
        return this.id;
    }
    
    public String getEstado()
    {
        return this.estado;
    }
    
    public boolean getReq()
    {
        return this.req;
    }
    
    public int getEdicao()
    {
        return this.edicao;
    }
    
    //Sets---------------------------------------------------------------------------------------------------------
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    
    public void setReq(boolean req)
    {
        this.req = req;
    }
    
    public void setEdicao(int edicao)
    {
        this.edicao = edicao;
    }
    
    //Clone---------------------------------------------------------------------------------------------------------
    
    public Copia clone()
    {
        return new Copia(this);
    }
}