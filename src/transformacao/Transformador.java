package transformacao;

import extracao.ExtracaoFacade;

public class Transformador {
    private ExtracaoFacade extracao;

    public Transformador(ExtracaoFacade extracao) {
        this.extracao = extracao;
    }

    public void transformar() {
        System.out.println("transformar()");
    }
}
