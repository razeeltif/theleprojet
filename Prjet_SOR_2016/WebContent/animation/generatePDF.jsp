<%@page import="Bean.Animation"%>
<%@page import="Bean.Groupe"%>
<%@page import="validation.Identification"%>
<%@page import="manager.Manager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%@page import="com.itextpdf.text.*"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>

<jsp:useBean id="manager" 
	class="manager.Manager"
	scope="session" />
	
<%
String realPath = request.getRealPath("/")+"animation/AnimationPDF.pdf";
if(true){
	Document document = new Document();
	try {
		ArrayList<Animation> listAnim = manager.getServRMI().getAllAnim();
		PdfWriter.getInstance(document,
		          new FileOutputStream(realPath));
		document.open();

		final Font fontTitre = new Font(Font.getFamily("CALIBRI"), 40, Font.BOLD);
		final Font fontAnim = new Font(Font.getFamily("CALIBRI"), 12, Font.BOLD);
		final Font fontStuff = new Font(Font.getFamily("CALIBRI"), 11, Font.BOLD);
		Paragraph title = new Paragraph("BREST 2016",fontTitre);		
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(fontAnim);

		
		for(int i=0; i<listAnim.size(); i++){
	        Chunk chunk = new Chunk("nom de l'animation : " + listAnim.get(i).getNom_animation() + "\n");
	        paragraph.add(chunk);
	        chunk = new Chunk("groupe :	" +listAnim.get(i).getGroupe_name()+"\n" );
	        paragraph.add(chunk);
	        chunk = new Chunk("description :	" + listAnim.get(i).getDescription() + "\n" );
	        paragraph.add(chunk);
	        chunk = new Chunk("nombre de places au total :	" + listAnim.get(i).getNb_Places()+"\n");
	        paragraph.add(chunk);
	        chunk = new Chunk("durée :	"+ listAnim.get(i).getDuree()/60+"h"+listAnim.get(i).getDuree()%60+"\n\n" );
	        paragraph.add(chunk);
	      }
		
	    document.add(paragraph);
		document.close(); // no need to close PDFwriter?

	} catch (DocumentException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
	      e.printStackTrace();
    }
} %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../commun_page_menu/menu.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Génération de PDF</title>
</head>
<body>
<h1>Génération du PDF</h1>

<h2>Le PDF a été généré, <a href="../ServletDlPdf?path=<%out.print(realPath);%>">cliquez ici</a></h2>
</body>
</html>