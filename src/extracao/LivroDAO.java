package extracao;

import java.util.HashSet;
import java.util.Set;
import transformacao.*;
import java.sql.*;


public class LivroDAO extends DAO {

    public LivroDAO(Connection c) {
        super(c);
    }

    public Set<Integer> keySet() throws SQLException {
        HashSet<Integer> r = new HashSet<>();

        Statement s = this.connection.createStatement();
        ResultSet rs = s.executeQuery("select Id from biblioteca.livro;");

        while (rs.next()) {
            r.add(rs.getInt("Id"));
        }

        rs.close();
        s.close();

        return r;
    }

    public Livro get(int id) throws SQLException {
        Livro livro = null;

        // get nome, resumo e data;
        PreparedStatement p = this.connection.prepareStatement("select * from biblioteca.livro where Id = ?;");
        ResultSet r = null;
        p.setInt(1, id);
        try {
            r = p.executeQuery();
            if (r.next()) {
                livro = new Livro(r.getNome("Titulo"),
                                  r.getResumo("Resumo"),
                                  r.getDataPublicacao("DataPublicacao").toLocalDateTime());
            } else {
                throw new SQLException("biblioteca.livro is empty.");
            }
        } finally {
            if (r != null) r.close();
            p.close();
        }

        return livro;
    }
}
