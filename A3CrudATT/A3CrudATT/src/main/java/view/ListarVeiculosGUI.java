package view;

import dao.VeiculoDAO;
import model.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.util.List;

public class ListarVeiculosGUI extends JFrame {

    public ListarVeiculosGUI() {
        setTitle("Listar Veículos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Marca", "Modelo", "Ano", "Cor", "Placa", "Quilometragem", "Disponível?", "Preço", "Categoria", "Descrição"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tableModel);

        try (Connection conn = dao.ConexaoBD.getCon()) {  // puxando o bd
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            List<Veiculo> veiculos = veiculoDAO.buscarVeiculos(conn);

            for (Veiculo veiculo : veiculos) {
                Object[] dados = {
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getAno(),
                        veiculo.getCor(),
                        veiculo.getPlaca(),
                        veiculo.getQuilometragem(),
                        veiculo.getDisponivel(),
                        veiculo.getPrecoDiaria(),
                        veiculo.getCategoria(),
                        veiculo.getDescricao()     
                };
                tableModel.addRow(dados);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar veículos: " + e.getMessage());
        }

        add(new JScrollPane(tabela), BorderLayout.CENTER);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
