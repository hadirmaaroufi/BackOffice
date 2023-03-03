package tn.esprit.pidev.bns.entity.ibtihel;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PDFGenerator {



    private List<PurchaseOrder> listPurshaseOrder;

    public PDFGenerator(List<PurchaseOrder> listPurshaseOrder) {
        this.listPurshaseOrder = listPurshaseOrder;
    }


    private void writeTableHeader(PdfPTable table) {

        //Créer des cellules de tableau pour l'en-tête du tableau
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);


        // Ajout d'en-têtes dans la cellule- l'entête du tableau créé
         // Ajout d'une cellule au tableau
        cell.setPhrase(new Phrase("Order ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Reference", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Payment Method", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Order Price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Adress", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Phone Number", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mail", font));
        table.addCell(cell);
    }




    // ajout des données dans le tableau
    private void writeTableData(PdfPTable table) {

        // Itération sur la liste des orders
        for (PurchaseOrder purchaseOrder : listPurshaseOrder) {
            //adding order id
            table.addCell(String.valueOf(purchaseOrder.getIdOrder()));
            table.addCell(purchaseOrder.getReference());
            table.addCell(purchaseOrder.getPaymentMethod().toString());
            table.addCell(String.valueOf(purchaseOrder.getOrderPrice()));
            table.addCell(purchaseOrder.getDate().toString());
            table.addCell(purchaseOrder.getAddress());
            table.addCell(String.valueOf(purchaseOrder.getPhoneNumber()));
            table.addCell(purchaseOrder.getMail());
        }
    }




    public void export(HttpServletResponse response) throws DocumentException, IOException {
        //creation d'un objet document
        Document document = new Document(PageSize.A4);

        //instance de pdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());

        //ouvrir le doc pour le modifier
        document.open();

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        /*String imgPath ="src/main/resources/images/- Silvia Mellow -.png";
        ImageData imageData = ImageDataFactory.create(imgPath);
        Image image= new Image(imageData);
        image.setFixedPosition(document.getPageSize().getWidth()/2-320, document.getPageSize().getHeight()/2-160);
        image.setOpacity(0.3f); */


        //creation de paragraph
        Paragraph p = new Paragraph("List of Orders", font);

        //aligner la Paragraph au centre
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(150f);
        table.setWidths(new float[] {3.0f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });
        table.setSpacingBefore(20);

        writeTableHeader(table);
        writeTableData(table);





        document.add(table);

        document.close();
        System.out.println("PDF Generated");

    }


}
