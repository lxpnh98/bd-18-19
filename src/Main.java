import extracao.ExtracaoFacade;
import transformacao.Transformador;

public class Main {

    public static void main(String[] args) {
        String user = args[0];
        String password = args[1];
        String driver;

        if (args.length <= 2) {
            driver = "com.mysql.cj.jdbc.Driver";
        } else {
            driver = "com.mysql.jdbc.Driver";
        }

        ExtracaoFacade e = new ExtracaoFacade(user, password, driver);
        Transformador t = new Transformador(e);
        t.transformar();
    }
}
