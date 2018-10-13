package com.example.demo.services;


import org.springframework.ui.Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

import com.example.demo.dao.*;
import com.example.demo.Metier.*;
import com.example.demo.entities.*;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
@Controller
@RequestMapping(value = "/inventaire")
public class ArticleRestService {

	Boolean t;
	// @RequestMapping(value="/index")
	// private String show(){return "index";}
	@Autowired
	private ArticleInvRepository ArticleInvRepository;
	@Autowired
	private ArticleMetier ArticleMetier;
	@Autowired
	private SearchMetier SearchMetier;

	@Autowired
	private SearchDate SearchDate;
	@Autowired
	private SearchEtat SearchEtat;
	List<typeArticle> list = Arrays.asList(typeArticle.values());

	List<EtatM> listM = Arrays.asList(EtatM.values());

	@RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
	public String saveArticle(ArticleInv a) {
		ArticleMetier.saveArticle(a);

		return "redirect:list";
	}

	@RequestMapping(value = "/UpdateArticle", method = RequestMethod.POST)
	public String updateArticle(ArticleInv a) {
		ArticleMetier.saveArticle(a);

		return "redirect:list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("a", new ArticleInv());
		model.addAttribute("list", list);
		model.addAttribute("listM", listM);
		return "AjoutArticle";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listArticles(Model model, @RequestParam(name = "page", defaultValue = "0") int p) {
		//System.out.println(p);
		Page<ArticleInv> articles = ArticleMetier.PageArticle(p);
		//System.out.println(p);
		int pagesCount = articles.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		model.addAttribute("article", articles);
		model.addAttribute("pageCourante", p);
	    model.addAttribute("articles", articles);
		model.addAttribute("list", list);
		model.addAttribute("listM", listM);

		return "inventaire";

	}

	@RequestMapping(value = "/chercher", method = RequestMethod.POST)
	public String chercher(Model model, 
			@RequestParam(name = "et", defaultValue = "null") String em,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "Destinataire", defaultValue = "") String dest,
			@RequestParam(name = "mar", defaultValue = "") String mrq,
			@RequestParam(name = "Référentiel", defaultValue = "") String ref,
			@RequestParam(name = "Article", defaultValue = "") String article,
			@RequestParam(name = "loc", defaultValue = "") String local,
			@RequestParam(name = "ben", defaultValue = "") String ben,
			@RequestParam(name = "type") String typ,
			@RequestParam(name = "dateAcq") String dateAcq, 
			@RequestParam(name = "dateSortie") String dateSortie)
	{   System.out.println(dateSortie);
		Pageable pageable = new PageRequest(p, 5);
		List<ArticleInv> Mate = new ArrayList<ArticleInv>();
		List<ArticleInv> PageDest = SearchMetier.chercherD("%" + dest + "%");
		List<ArticleInv> pageMarque = SearchMetier.chercherM("%" + mrq + "%");
		List<ArticleInv> pageRef = SearchMetier.chercherR("%" + ref + "%");
		List<ArticleInv> pageArticle = SearchMetier.chercherA("%" + article + "%");
		List<ArticleInv> pageloc = SearchMetier.chercherL("%" + local + "%");
		List<ArticleInv> pageBen = SearchMetier.chercherB("%" + ben + "%");

		List<ArticleInv> pagetype = ArticleInvRepository.findAll();

		for (int i = 0; i < list.size(); i++) {

			if (typ.equals(list.get(i).toString())) {
				//System.out.println(list.get(i));
				pagetype = SearchEtat.chercherT(list.get(i));

			}
		}
		List<ArticleInv> pageEtat = ArticleInvRepository.findAll();

		for (int i = 0; i < listM.size(); i++) {

			if (em.equals(listM.get(i).toString())) {
				//System.out.println(listM.get(i));
				pageEtat = SearchEtat.chercherE(listM.get(i));

			}
		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<ArticleInv> pagedateAcq = null;

		Date dateac = new Date();
		dateac = null;
		try {
			if (dateAcq != "") {
				dateac = format.parse(dateAcq);
				pagedateAcq = SearchDate.chercherDateAC(dateac);
				//System.out.println(pagedateAcq.size());
			}

			else {
				pagedateAcq = ArticleInvRepository.findAll();
				// System.out.println(pagedateAcq.size());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ArticleInv> pagedateSortie = null;
		Date dateS = new Date();
		dateS = null;
		try {
			if (dateSortie != "") {
				dateS = format.parse(dateSortie);
				pagedateSortie = SearchDate.chercherDateSortie(dateS);
				
			}

			else {
				pagedateSortie = ArticleInvRepository.findAll();
			  System.out.println(pagedateSortie.size());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    for (ArticleInv pda : pagedateAcq)
     	for (ArticleInv pds : pagedateSortie)
	    	for (ArticleInv pd : PageDest)
	   	 	   for (ArticleInv pm : pageMarque)
			    	for (ArticleInv pr : pageRef)
				    	for (ArticleInv pa : pageArticle)
					    	for (ArticleInv pl : pageloc)
						     	for (ArticleInv pt : pagetype)
						    		for (ArticleInv pb : pageBen)
							     		for (ArticleInv pe : pageEtat)
								
										   	{
												{
													if (pd.getId() == pm.getId() && pm.getId() == pr.getId()
															&& pr.getId() == pa.getId() && pa.getId() == pl.getId()
															&& pl.getId() == pb.getId() && pb.getId() == pe.getId()
															&& pe.getId() == pt.getId() && pt.getId() == pda.getId()
															&& pda.getId() == pds.getId())

														
														Mate.add(pm);
												}

											}

		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > Mate.size() ? Mate.size() : (start + pageable.getPageSize());
		Page<ArticleInv> Mat = new PageImpl<ArticleInv>(Mate.subList(start, end), pageable, Mate.size());
		int pagesCount = Mat.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		model.addAttribute("article", Mat);
		model.addAttribute("pageCourante", p);
      
		return "inventaire";
	}

	@RequestMapping(value = "/supprimer")
	public String supprimer(Long id) {
		ArticleMetier.delete(id);

		return "redirect:list";
	}

	@RequestMapping(value = "/edit")
	public String editer(Long id, Model model) {
		ArticleInv mt = ArticleMetier.edit(id);
		model.addAttribute("b", mt);
		model.addAttribute("list", list);
		model.addAttribute("listM", listM);
		return "EditMateriel";
	}
//	@RequestMapping(value = "/extract")
//	public String extract(Model model) {
//		List<ArticleInv> articles = ArticleInvRepository.findAll();
//		String chemin="C:\\eclipse-workspace-JEE\\proj\\src\\main\\resources\\pdf\\inv.pdf";
//		
//		    Document document = new Document();
//		    try 
//		    {
//		      PdfWriter.getInstance(document, new FileOutputStream(chemin));
//		      document.open();
//		      Image img=Image.getInstance("clr.png");
//		      img.setAlignment(Element.ALIGN_CENTER);
//		      
//		      document.add(new Paragraph());
//		      document.add(img);
//              Paragraph p=new Paragraph(new Paragraph("liste du matériel département Informatique",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.PINK)));
//              p.setAlignment(Element.ALIGN_CENTER);
//		      document.add(p);
//		      
//		      document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------"));
//		      document.add(new Paragraph(""));
//		      document.add(PDFGenerator.premierTableau(articles));
//
//		    } catch (DocumentException de) {
//		      de.printStackTrace();
//		    } catch (IOException de) {
//		      de.printStackTrace();
//		    }
//		   
//		    document.close();
//		  
//		    return "my";
//	}

}
