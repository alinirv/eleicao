package data;

import model.Candidato;
import model.Cargo;
import model.Partido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatoSQliteDAO implements CandidatoDAO {
    @Override
    public void salvar(Candidato a) {
        String sql = "INSERT INTO candidato values (?,?,?,?)";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,a.getNumero());
            stmt.setString(2,a.getNome());
            stmt.setInt(3,a.getPartido().getNumero());
            stmt.setInt(4,a.getCargo().getIdCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Candidato a) {
        String sql = "UPDATE candidato SET nome=?, partido=?, cargo=? WHERE numero=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,a.getNome());
            stmt.setInt(2,a.getPartido().getNumero());
            stmt.setInt(3, a.getCargo().getIdCargo());
            stmt.setInt(4,a.getNumero());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void apagar(Candidato a) {
        String sql = "DELETE FROM candidato WHERE numero=?";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,a.getNumero());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Candidato buscar(int numero) {
        String sql = "SELECT * FROM candidato WHERE numero=?";
        Candidato a=null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQliteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQliteDAO().buscar(rs.getInt("cargo"));
                a = new Candidato(rs.getInt("numero"),
                        rs.getString("nome"),
                        partido,cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Candidato> buscarTodos() {
        String sql = "SELECT * FROM candidato";
        List<Candidato> listaCandidato=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQliteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQliteDAO().buscar(rs.getInt("cargo"));
                Candidato a = new Candidato(rs.getInt("numero"),
                                            rs.getString("nome"),
                                            partido,cargo);
                listaCandidato.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCandidato;
    }
}
