package data;

import model.Cargo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoSQliteDAO implements CargoDAO {


    @Override
    public void salvar(Cargo c) {
        String sql = "INSERT INTO cargo (cargo) values (?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, c.getCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Cargo c) {
        String sql = "UPDATE cargo SET cargo=? WHERE idcargo=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,c.getCargo());
            stmt.setInt(2,c.getIdCargo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void apagar(Cargo c) {
        String sql = "DELETE FROM cargo WHERE idcargo=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,c.getIdCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Cargo buscar(int idCargo) {
        Cargo c = null;
        String sql = "SELECT * FROM cargo WHERE idcargo=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idCargo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                c = new Cargo(rs.getInt("idcargo"), rs.getString("cargo"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;

    }

    @Override
    public List<Cargo> buscarTodos() {
        String sql = "SELECT * FROM cargo";
        List<Cargo> listaCargos =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cargo c = new Cargo(rs.getInt("idcargo"), rs.getString("cargo"));
                listaCargos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCargos;

    }
}
