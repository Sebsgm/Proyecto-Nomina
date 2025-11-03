package Controlador;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import Conexion.Conexion;
import javax.swing.*;
import java.sql.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficaTotalPagadoEmpleados extends JInternalFrame {

    public GraficaTotalPagadoEmpleados() {
        setTitle("Total Pagado por Empleado");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setSize(700, 500);

        DefaultCategoryDataset dataset = obtenerDatosPagos();

        JFreeChart chart = ChartFactory.createBarChart(
                "Total Pagado por Empleado",
                "Empleado",
                "Total Pagado ($)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset obtenerDatosPagos() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT e.Nombre_completo, p.total_pago " +
                         "FROM pagos p INNER JOIN empleado e ON p.id_empleado = e.cedula";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("Nombre_completo");
                int totalPagado = rs.getInt("total_pago");
                dataset.addValue(totalPagado, "Total Pagado", nombre);
            }

            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los datos: " + e.getMessage());
        }

        return dataset;
    }
}