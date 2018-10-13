//
//package com.example.demo.services;
//
//import java.awt.Color;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import com.example.demo.dao.ArticleInvRepository;
//import com.example.demo.entities.ArticleInv;
//
//import com.example.demo.entities.ArticleInv;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.TabStop.Alignment;
//import com.itextpdf.text.pdf.PdfWriter;
//public class PDFGenerator {
//
//	// Classe permmettant de déssiner un tableau.
//
//	public static PdfPTable premierTableau(List<ArticleInv> articles) {
//		Date d = new Date();
//		d = null;
//		// On créer un objet table dans lequel on intialise ça taille.
//		PdfPTable table = new PdfPTable(8);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		// On créer l'objet cellule.
//		PdfPCell cell;
//		cell = new PdfPCell(new Phrase("Fusion de chaque première cellule de chaque colonne"));
//		cell.setColspan(8);
//		cell = new PdfPCell(new Phrase("Référentiel",
//				FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(
//				new Phrase("Article", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(
//				new Phrase("Marque", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(new Phrase("Date d'Entree",
//				FontFactory.getFont(FontFactory.TIMES_BOLD,8, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(new Phrase("Bénificiaire",
//				FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(
//				new Phrase("Etat", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(
//				new Phrase("type", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//		cell = new PdfPCell(new Phrase("Destinataire",
//				FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.ITALIC, BaseColor.BLACK)));
//		cell.setBackgroundColor(BaseColor.GRAY);
//		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(cell);
//
//		// contenu du tableau.
//
//		for (int i = 0; i < articles.size(); i++) {
//			cell.setRowspan(1);
//			cell = new PdfPCell(new Phrase(articles.get(i).getRef(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//
//			// contenu du tableau.
//			cell = new PdfPCell(new Phrase(articles.get(i).getNom(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//
//			cell = new PdfPCell(new Phrase(articles.get(i).getMarque(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//			d = articles.get(i).getDateEntree();
//
//			if (d == null)
//				table.addCell("");
//			else {
//				cell = new PdfPCell(new Phrase(sdf.format(articles.get(i).getDateEntree()),
//						FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
//
//				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table.addCell(cell);
//			}
//
//			cell = new PdfPCell(new Phrase(articles.get(i).getRessourceBeneficaire(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//			cell = new PdfPCell(new Phrase(articles.get(i).getEtat().toString(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//			cell = new PdfPCell(new Phrase(articles.get(i).getType().toString(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//			cell = new PdfPCell(new Phrase(articles.get(i).getDestinataire(),
//					FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.NORMAL, BaseColor.BLACK)));
//
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table.addCell(cell);
//
//		}
//		return table;
//	}
//
//}
