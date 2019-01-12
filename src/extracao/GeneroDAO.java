package extracao;

import java.util.HashSet;
import java.util.Set;
import transformacao.*;
import java.sql.*;


public class GeneroDAO extends DAO {

    public GeneroDAO(Connection c) {
        super(c);
    }

    public Set<Integer> keySet() throws SQLException {
        HashSet<Integer> r = new HashSet<>();

        Statement s = this.connection.createStatement();
        ResultSet rs = s.executeQuery("select Id from biblioteca.genero;");

        while (rs.next()) {
            r.add(rs.getInt("Id"));
        }

        rs.close();
        s.close();

        return r;
    }

    public Genero get(int id) throws SQLException {
        Genero genero = null;

        // get nome, naturalidade, data nascimento e sexo;
        PreparedStatement p = this.connection.prepareStatement("select * from biblioteca.genero where Id = ?;");
        ResultSet r = null;
        p.setInt(1, id);
        try {
            r = p.executeQuery();
            if (r.next()) {
                genero = new Genero(r.getDesig("Designacao"),
                                    r.getDesc("Descricao"));
            } else {
                throw new SQLException("biblioteca.genero is empty.");
            }
        } finally {
            if (r != null) r.close();
            p.close();
        }

        return genero;
    }
}
