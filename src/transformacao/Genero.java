package transformacao;

public class Genero
{
    private String desig;
    private String desc;
    
    //Construtores---------------------------------------------------------------------------------------------------------
    
    public Genero()
    {
        this.desig = null;
        this.desc = null;
    }
    
    public Genero(String desig, String desc)
    {
        this.desig = desig;
        this.desc = desc;
    }
    
    public Genero(Genero genero)
    {
        this.desig = genero.getDesig();
        this.desc = genero.getDesc();
    }
    
    //Gets---------------------------------------------------------------------------------------------------------
    
    public String getDesig()
    {
        return this.desig;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
    //Sets---------------------------------------------------------------------------------------------------------
    
    public void setDesig(String desig)
    {
        this.desig = desig;
    }
    
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
    //Clone---------------------------------------------------------------------------------------------------------
    
    public Genero clone()
    {
        return new Genero(this);
    }
}