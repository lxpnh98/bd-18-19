package extracao;

import java.util.HashSet;
import java.util.Set;
import transformacao.*;
import java.sql.*;


public class AutorDAO extends DAO {

    public AutorDAO(Connection c) {
        super(c);
    }

    public Set<Integer> keySet() throws SQLException {
        HashSet<Integer> r = new HashSet<>();

        Statement s = this.connection.createStatement();
        ResultSet rs = s.executeQuery("select Id from biblioteca.autor;");

        while (rs.next()) {
            r.add(rs.getInt("Id"));
        }

        rs.close();
        s.close();

        return r;
    }

    public Autor get(int id) throws SQLException {
        Autor autor = null;

        // get nome, naturalidade, data nascimento e sexo;
        PreparedStatement p = this.connection.prepareStatement("select * from biblioteca.autor where Id = ?;");
        ResultSet r = null;
        p.setInt(1, id);
        try {
            r = p.executeQuery();
            if (r.next()) {
                autor = new Autor(r.getNome("Nome"),
                                  r.getNaturalidade("Naturalidade"),
                                  r.getDataNascimento("DataNascimento").toLocalDateTime(),
                                  r.getSexo("Sexo"),);
            } else {
                throw new SQLException("biblioteca.autor is empty.");
            }
        } finally {
            if (r != null) r.close();
            p.close();
        }

        return autor;
    }
}