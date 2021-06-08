package tn.esprit.spring.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.repository.CartRepository;

import tn.esprit.spring.repository.CommandeRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.ProductRepository;


@Service
public class CommandeService {
	@Autowired
	CartRepository cartRepeository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CommandeRepository commandRepository;
	@Autowired
	CartService cartservice;	
	@Autowired
	IUserRepository userRepository;
	public Commande savecommande(Commande panier) {
		// TODO Auto-generated method stub
		return commandRepository.save(panier);
	}
	
	public List<Commande> getAllcommande() {
		
		
		return (List<Commande>) commandRepository.findAll();

	}
	
	public void deletecommande(Long id) {
		
		Optional<Commande> commande = commandRepository.findById(id);
	    
	    if(commande.isPresent()) 
	    {
	    	commandRepository.deleteById(id);
	       }	
	    }
	public Commande updatecommande(Commande fr){
		
		return commandRepository.save(fr);
	}
	public List<Commande> getCommandepardate(Date date){
		   return commandRepository.findByComandedate(date);
		}

	public void commandepdf (Long id){
		try {
			Commande fr = commandRepository.getOne(id);
			
		String file_name="E:\\pdf\\Pipdf"+fr.getId()+".pdf";
		Document document=new Document(PageSize.A4,15,15,45,30);
		
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			 document.open();
			 document.add(new Paragraph("  "));
			 document.add(new Paragraph("  "));
			 Image img=Image.getInstance("E:\\pdf\\capture2.PNG");
			 img.setAlignment(Element.ALIGN_LEFT);
			 img.setIndentationLeft(5);
			 img.setIndentationRight(5);
			 img.setSpacingAfter(1);
			 document.add(img); 

			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 document.add(new Paragraph("Telephone  :(+216) 98155255   "+"                                                             Adresse :Al Ghazela /Tunis "));
			 document.add(new Paragraph("Fax          :(+216) 75155255   "+"                                                                 Code Postal :2088  "));
			 document.add(new Paragraph("Email       :service@consomitounsi.tn  "));
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 document.add(new Paragraph(" "));
			 document.add(new Paragraph(" "));

		
			 Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
			 Date aujourdhui = fr.getCommandDate();
			 document.add(new Paragraph("idCommande  :"+fr.getId()));
			 SimpleDateFormat formater = null;
			 formater = new SimpleDateFormat("dd-MM-yy");
		
			 Paragraph adresse=new Paragraph("Nom : "+fr.getName());
			 document.add(adresse);
			 
			 document.add(new Paragraph("Prenom  :"+fr.getPrenom()));
			 document.add(new Paragraph("Date Payment	: "+fr.getCommandDate()));
			 document.add(new Paragraph("Montant totale  :"+fr.getMontantHT()));
			 document.add(new Paragraph("Type Payment  :"+fr.getCommandType()));
				
			 Font mainFont = FontFactory.getFont("Cooper Black",35, BaseColor.BLACK);
			 
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 PdfPTable table = new PdfPTable(4);
			 PdfPTable table2 = new PdfPTable(3);
			  Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
			    Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
	
			 
			    PdfPCell nameProduit = new PdfPCell(new Paragraph("Name Product", tableHeader));
			    nameProduit.setBorderColor(BaseColor.BLACK);
			    nameProduit.setPaddingLeft(10);
			    nameProduit.setHorizontalAlignment(Element.ALIGN_CENTER);
			    nameProduit.setVerticalAlignment(Element.ALIGN_CENTER);
			    nameProduit.setBackgroundColor(BaseColor.LIGHT_GRAY);
			    nameProduit.setExtraParagraphSpace(5f);
			    table.addCell(nameProduit);
			     
			    
			    PdfPCell Prix = new PdfPCell(new Paragraph("Quantity", tableHeader));
			    Prix.setBorderColor(BaseColor.BLACK);
			    Prix.setPaddingLeft(10);
			    Prix.setHorizontalAlignment(Element.ALIGN_CENTER);
			    Prix.setVerticalAlignment(Element.ALIGN_CENTER);
			    Prix.setBackgroundColor(BaseColor.LIGHT_GRAY);
			    Prix.setExtraParagraphSpace(5f);
			    table.addCell(Prix);
			    
			    
			    PdfPCell Unit = new PdfPCell(new Paragraph("Unit price", tableHeader));
			    Unit.setBorderColor(BaseColor.BLACK);
			    Unit.setPaddingLeft(10);
			    Unit.setHorizontalAlignment(Element.ALIGN_CENTER);
			    Unit.setVerticalAlignment(Element.ALIGN_CENTER);
			    Unit.setBackgroundColor(BaseColor.LIGHT_GRAY);
			    Unit.setExtraParagraphSpace(5f);
			    table.addCell(Unit);
			    
			    PdfPCell Total = new PdfPCell(new Paragraph("Prix Totale", tableHeader));
			    Total.setBorderColor(BaseColor.BLACK);
			    Total.setPaddingLeft(10);
			    Total.setHorizontalAlignment(Element.ALIGN_CENTER);
			    Total.setVerticalAlignment(Element.ALIGN_CENTER);
			    Total.setBackgroundColor(BaseColor.LIGHT_GRAY);
			    Total.setExtraParagraphSpace(5f);
			    table.addCell(Total);
			    
			    
			    
			    PdfPCell quantiteval = new PdfPCell(new Paragraph(String.valueOf(fr.getProductname()) , tableHeader));
		 	    quantiteval.setBorderColor(BaseColor.BLACK);
		 	    quantiteval.setPaddingLeft(10);
		 	    quantiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	    quantiteval.setVerticalAlignment(Element.ALIGN_CENTER);
		 	    quantiteval.setBackgroundColor(BaseColor.WHITE);
		 	    quantiteval.setExtraParagraphSpace(5f);
		 	    table.addCell(quantiteval);
			    
		 	   
		 	   
			    PdfPCell quantitevall = new PdfPCell(new Paragraph(String.valueOf(fr.getQnt())));
		 	    quantitevall.setBorderColor(BaseColor.BLACK);
		 	    quantitevall.setPaddingLeft(10);
		 	    quantitevall.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	    quantitevall.setVerticalAlignment(Element.ALIGN_CENTER);
		 	    quantitevall.setBackgroundColor(BaseColor.WHITE);
		 	    quantitevall.setExtraParagraphSpace(5f);
		 	    table.addCell(quantitevall);
			    
		 	   
			    PdfPCell quantit = new PdfPCell(new Paragraph(String.valueOf(fr.getMontantUN())));
		 	    quantit.setBorderColor(BaseColor.BLACK);
		 	    quantit.setPaddingLeft(10);
		 	    quantit.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	    quantit.setVerticalAlignment(Element.ALIGN_CENTER);
		 	    quantit.setBackgroundColor(BaseColor.WHITE);
		 	    quantit.setExtraParagraphSpace(5f);
		 	    table.addCell(quantit);
		 	    

			    PdfPCell quant = new PdfPCell(new Paragraph(String.valueOf(fr.getMontantHT())));
		 	    quant.setBorderColor(BaseColor.BLACK);
		 	    quant.setPaddingLeft(10);
		 	    quant.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	    quant.setVerticalAlignment(Element.ALIGN_CENTER);
		 	    quant.setBackgroundColor(BaseColor.WHITE);
		 	    quant.setExtraParagraphSpace(5f);
		 	    table.addCell(quant);
		 	    
		 	   document.add(table);
		 	    
		 	    document.add(new Paragraph("  "));
			    
			    document.add(table2);
			    document.add(new Paragraph("  "));
			    document.add(new Paragraph("  "));
			    
				 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
				 
			 
			
			    document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		}
	public void uploadpdf(long id) throws IOException{
			Commande fr = commandRepository.getOne(id);
		   FacesContext context = FacesContext.getCurrentInstance();  
		    HttpServletResponse response = (HttpServletResponse) context  
		                         .getExternalContext().getResponse();  
		    File file = new File("E:\\pdf\\Pipdf"+fr.getId()+".pdf");  
		    if (!file.exists()) {  
		      response.sendError(HttpServletResponse.SC_NOT_FOUND);  
		      return;  
		     }  
		    response.reset();  
		    response.setBufferSize(20);  
		    response.setContentType("application/octet-stream");  
		    response.setHeader("Content-Length", String.valueOf(file.length()));  
		    response.setHeader("Content-Disposition", "attachment;filename=\""  
		           + file.getName() + "\"");  
		    BufferedInputStream input = null;  
		    BufferedOutputStream output = null;  

		    try 
		    {  
		        input = new BufferedInputStream(new FileInputStream(file),  
		                    20);  
		        output = new BufferedOutputStream(response.getOutputStream(),  
		                        20);  
		        byte[] buffer = new byte[20];  
		        int length;  
		        while ((length = input.read(buffer)) > 0) {  
		            output.write(buffer, 0, length);  
		        }  
		    } finally 
		    {  
		        input.close();  
		        output.close();  
		    }  
		    context.responseComplete();
		}


}
