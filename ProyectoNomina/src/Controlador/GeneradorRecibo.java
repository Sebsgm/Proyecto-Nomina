package Controlador;

import Conexion.Conexion;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneradorRecibo {

    public void generarReportePDF(String cedulaEmpleado, String nombreEmpleado) {
        Document documento = new Document();
        try {
            Connection cn = Conexion.conectar();

            String ruta = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Reporte_Nomina_" + cedulaEmpleado + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Estilos
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font negritaFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            // Encabezado
            documento.add(new Paragraph("EMPRESA NOMINA PAYWISE PAYROLL.", tituloFont));
            documento.add(new Paragraph("Nit 101010108", normalFont));
            documento.add(new Paragraph("Documento soporte de pago nómina electrónica", tituloFont));
            documento.add(new Paragraph(" "));

            String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            documento.add(new Paragraph("Fecha de generación: " + fechaActual));
            documento.add(new Paragraph("Empleado: " + nombreEmpleado + " | Cédula: " + cedulaEmpleado));
            documento.add(new Paragraph(" "));
            
            // === Consulta datos bancarios ===
            String sqlBanco = "SELECT Nombre_banco, Tipo_cuenta, Numero_de_cuenta FROM banco WHERE id_cedula = ?";
            PreparedStatement pstBanco = cn.prepareStatement(sqlBanco);
            pstBanco.setString(1, cedulaEmpleado);
            ResultSet rsBanco = pstBanco.executeQuery();

            if (rsBanco.next()) {
                String nombreBanco = rsBanco.getString("Nombre_banco");
                String tipoCuenta = rsBanco.getString("Tipo_cuenta");
                String numeroCuenta = rsBanco.getString("Numero_de_cuenta");

                // Extraer últimos 4 dígitos
                String ultimos4 = (numeroCuenta != null && numeroCuenta.length() >= 4)
                    ? numeroCuenta.substring(numeroCuenta.length() - 4)
                    : numeroCuenta;

                documento.add(new Paragraph("Banco: " + nombreBanco));
                documento.add(new Paragraph("Cuenta: **** **** **** " + ultimos4 + " | Tipo: " + tipoCuenta));
            } else {
                documento.add(new Paragraph("Banco: No registrado"));
            }

            documento.add(new Paragraph(" "));

            // Tabla Devengados
            PdfPTable tablaDev = new PdfPTable(2);
            tablaDev.setWidthPercentage(100);
            tablaDev.setSpacingBefore(10);
            tablaDev.addCell(new PdfPCell(new Phrase("Concepto", negritaFont)));
            tablaDev.addCell(new PdfPCell(new Phrase("Valor", negritaFont)));

            String sqlDev = "SELECT salario, Sub_transporte, Gastos_representativos, Viaticos, Comisiones, " +
                    "Horas_trabajadas, Horas_extra_diurnas, Horas_extra_nocturnas, " +
                    "Horas_extra_dominicales_diurnas, Horas_extra_dominicales_nocturnas " +
                    "FROM devengados WHERE id_empleado = ?";
            PreparedStatement pst = cn.prepareStatement(sqlDev);
            pst.setString(1, cedulaEmpleado);
            ResultSet rsDev = pst.executeQuery();

            int totalDevengados = 0;
            while (rsDev.next()) {
                totalDevengados += agregarConcepto(tablaDev, "Salario", rsDev.getString("salario"));
                totalDevengados += agregarConcepto(tablaDev, "Auxilio de Transporte", rsDev.getString("Sub_transporte"));
                totalDevengados += agregarConcepto(tablaDev, "Gastos Representativos", rsDev.getString("Gastos_representativos"));
                totalDevengados += agregarConcepto(tablaDev, "Viáticos", rsDev.getString("Viaticos"));
                totalDevengados += agregarConcepto(tablaDev, "Comisiones", rsDev.getString("Comisiones"));
                totalDevengados += agregarConcepto(tablaDev, "Horas Extra Diurnas", rsDev.getString("Horas_extra_diurnas"));
                totalDevengados += agregarConcepto(tablaDev, "Horas Extra Nocturnas", rsDev.getString("Horas_extra_nocturnas"));
                totalDevengados += agregarConcepto(tablaDev, "Horas Extra Dom Diurnas", rsDev.getString("Horas_extra_dominicales_diurnas"));
                totalDevengados += agregarConcepto(tablaDev, "Horas Extra Dom Nocturnas", rsDev.getString("Horas_extra_dominicales_nocturnas"));
            }

            PdfPCell totalDev = new PdfPCell(new Phrase("Total Ingresos"));
            totalDev.setColspan(1);
            tablaDev.addCell(totalDev);
            tablaDev.addCell("$ " + totalDevengados);
            documento.add(tablaDev);

            // Tabla Descuentos
            PdfPTable tablaDesc = new PdfPTable(2);
            tablaDesc.setWidthPercentage(100);
            tablaDesc.setSpacingBefore(10);
            tablaDesc.addCell(new PdfPCell(new Phrase("Concepto", negritaFont)));
            tablaDesc.addCell(new PdfPCell(new Phrase("Valor", negritaFont)));

            String sqlDesc = "SELECT salud, pension, credito_empleado FROM descuentos WHERE id_empleado = ?";
            pst = cn.prepareStatement(sqlDesc);
            pst.setString(1, cedulaEmpleado);
            ResultSet rsDesc = pst.executeQuery();

            int totalDescuentos = 0;
            while (rsDesc.next()) {
                totalDescuentos += agregarConcepto(tablaDesc, "Salud", rsDesc.getString("salud"));
                totalDescuentos += agregarConcepto(tablaDesc, "Pensión", rsDesc.getString("pension"));
                totalDescuentos += agregarConcepto(tablaDesc, "Crédito Empleado", rsDesc.getString("credito_empleado"));
            }

            PdfPCell totalDesc = new PdfPCell(new Phrase("Total Deducciones"));
            totalDesc.setColspan(1);
            tablaDesc.addCell(totalDesc);
            tablaDesc.addCell("-$ " + totalDescuentos);
            documento.add(tablaDesc);

            // Neto a pagar
            int netoPagar = totalDevengados - totalDescuentos;
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("NETO A PAGAR: $ " + netoPagar, negritaFont));

            documento.close();
            cn.close();

            if (Desktop.isDesktopSupported()) {
                File file = new File(ruta);
                Desktop.getDesktop().open(file);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int agregarConcepto(PdfPTable tabla, String concepto, String valorStr) {
        if (valorStr != null && !valorStr.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(valorStr);
                if (valor > 0) {
                    tabla.addCell(concepto);
                    tabla.addCell("$ " + valorStr);
                    return valor;
                }
            } catch (NumberFormatException e) {
                // valor inválido, ignorar
            }
        }
        return 0;
    }
}

