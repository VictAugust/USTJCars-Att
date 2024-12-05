package dao;

import model.Veiculo;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VeiculoDAO {

    public void adicionarVeiculo(Connection conn, Veiculo veiculo) {
        String sqlInsert = "INSERT INTO veiculos (marca, modelo, ano, cor, placa, quilometragem, preco_diaria, disponivel, categoria, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
        try (PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
            stm.setString(1, veiculo.getMarca());
            stm.setString(2, veiculo.getModelo());
            stm.setInt(3, veiculo.getAno());
            stm.setString(4, veiculo.getCor());
            stm.setString(5, veiculo.getPlaca());
            stm.setInt(6, veiculo.getQuilometragem());
            stm.setDouble(7, veiculo.getPrecoDiaria());
            stm.setString(8, veiculo.getDisponivel());
            stm.setString(9, veiculo.getCategoria());
            stm.setString(10, veiculo.getDescricao());
            stm.execute();
        }catch(SQLIntegrityConstraintViolationException eq){
            JOptionPane.showMessageDialog(null, "Erro: Placa já cadastrada no sistema!", "Placa Duplicada", JOptionPane.WARNING_MESSAGE);
            eq.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
            try {
                if (!conn.getAutoCommit()) {
                    conn.rollback();
                }
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
    }

    public ArrayList<Veiculo> buscarVeiculos(Connection conn) {
        String sqlSelect = "SELECT marca, modelo, ano, cor, placa, quilometragem, preco_diaria, disponivel, categoria, descricao FROM veiculos";
        ArrayList<Veiculo> lista = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setQuilometragem(rs.getInt("quilometragem"));
                veiculo.setPrecoDiaria(rs.getDouble("preco_diaria"));
                veiculo.setDisponivel(rs.getString("disponivel"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setDescricao(rs.getString("descricao"));
                lista.add(veiculo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizarVeiculo(Connection conn, Veiculo veiculo) {
        String sqlUpdate = "UPDATE veiculos SET marca = ?, modelo = ?, ano = ?, cor = ?, quilometragem = ?, preco_diaria = ?, disponivel = ?, categoria = ?, descricao = ? WHERE placa = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
            stm.setString(1, veiculo.getMarca());
            stm.setString(2, veiculo.getModelo());
            stm.setInt(3, veiculo.getAno());
            stm.setString(4, veiculo.getCor());
            stm.setInt(5, veiculo.getQuilometragem());
            stm.setDouble(6, veiculo.getPrecoDiaria());
            stm.setString(7, veiculo.getDisponivel());
            stm.setString(8, veiculo.getCategoria());
            stm.setString(9, veiculo.getDescricao());
            stm.setString(10, veiculo.getPlaca());
            stm.execute();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (!conn.getAutoCommit()) {
                    conn.rollback();
                }
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
    }

    public void excluirVeiculo(Connection conn, String placa) {
        String sqlDelete = "DELETE FROM veiculos WHERE placa = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
            stm.setString(1, placa);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (!conn.getAutoCommit()) {
                    conn.rollback();
                }
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
    }
}
