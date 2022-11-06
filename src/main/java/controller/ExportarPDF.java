package controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import java.awt.Color;

import model.ventaVo;

public class ExportarPDF extends HttpServlet{
    private List<ventaVo> getIdDetalleVenta;

    public ExportarPDF()
    {

    }

    public ExportarPDF(List<ventaVo> getIdDetalleVenta) {
        this.getIdDetalleVenta = getIdDetalleVenta;
    }

public void writeHeader(PdfPTable pdfPTable){
    PdfPCell cell=new PdfPCell();
    cell.setBackgroundColor(Color.darkGray);
    // Cantidad de celdas
    cell.setPadding(6);
    Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    font.setColor(Color.white);

    // Cabezera (Aquí se colocan las celdas con su respectivo nombre)
    cell.setPhrase(new Phrase("ID", font));
    pdfPTable.addCell(cell);
    cell.setPhrase(new Phrase("Cantidad vendida", font));
    pdfPTable.addCell(cell);
    cell.setPhrase(new Phrase("Precio Total", font));
    pdfPTable.addCell(cell);
    cell.setPhrase(new Phrase("No doc Cliente", font));
    pdfPTable.addCell(cell);
    cell.setPhrase(new Phrase("Nombre del cliente", font));
    pdfPTable.addCell(cell);
    cell.setPhrase(new Phrase("Cantidad del Producto", font));
    pdfPTable.addCell(cell);
  }

  public void writeTableData(PdfPTable pTable){
    for (ventaVo venta : getIdDetalleVenta) {
        pTable.addCell(String.valueOf(venta.getIdDetalleVenta()));
        pTable.addCell(String.valueOf(venta.getCantidadVendida()));
        pTable.addCell(String.valueOf(venta.getPrecioTotal()));
        pTable.addCell(String.valueOf(venta.getNoDocCliente()));
        pTable.addCell(String.valueOf(venta.getNombreCliente()));
        pTable.addCell(String.valueOf(venta.getcantidadProducto()));
    }
  }

  public void export(HttpServletResponse response){
    // Tamaño de hoja
    try (Document document = new Document(PageSize.A4)){
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Tipo de letra y color
        Font font =FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(20);
        font.setColor(Color.BLUE);

        // Titulo del archivo
        Paragraph paragraph = new Paragraph("Lista de ventas", font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        // Se agregar todo al documento
        document.add(paragraph);

        // 
        // Correción de tabla(Para darle mejor visión)
        //

        // Cantidad de columnas
        PdfPTable pdfPTable = new PdfPTable(6);
        // Todo lo que va a ocupar la tabla (en este caso es un 100%)
        pdfPTable.setWidthPercentage(100f);
        // Tamaño de celda
        pdfPTable.setWidths(new float[]{1.5f,2.5f,3.0f,3.5f,3.5f,3.0f});
        // Espacio entre celdas (Hay dos métodos "after/before")
        pdfPTable.setSpacingBefore(10);
        
        // Se ejecuta el encabezado

        writeHeader(pdfPTable);
        writeTableData(pdfPTable);

        // Se agrega
        document.add(pdfPTable);
        // Se cierra el documento
        document.close();



    } catch (Exception e) {
        System.out.println("Error"+e);
    }
  }
}
