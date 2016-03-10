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
if(true){
	Document document = new Document();
	try {
		ArrayList<Animation> listAnim = manager.getServRMI().getAllAnim();
		PdfWriter.getInstance(document,
		          new FileOutputStream("Paragraph.pdf"));
		document.open();

		Paragraph paragraph = new Paragraph();

		for(int i=0; i<listAnim.size(); i++){
	        Chunk chunk = new Chunk("nom de l'animation :	" + listAnim.get(i).getNom_animation() + "	groupe :	" +listAnim.get(i).getGroupe_name()+"\n" );
	        paragraph.add(chunk);
	        chunk = new Chunk("description :	" + listAnim.get(i).getDescription() + "\n" );
	        paragraph.add(chunk);
	        chunk = new Chunk("nombre de places au total :	" + listAnim.get(i).getNb_Places() + ";	durée :	"+ listAnim.get(i).getDuree()+"\n\n" );
	        paragraph.add(chunk);
		    document.add(paragraph);
	      }

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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>