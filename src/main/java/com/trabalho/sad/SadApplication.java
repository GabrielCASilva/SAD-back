package com.trabalho.sad;

import java.io.File;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SadApplication {

	public static void main(String[] args) throws Docx4JException {
		try {
			gerarRelatorio();
			SpringApplication.run(SadApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void gerarRelatorio() throws Exception {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();

		mainDocumentPart.addStyledParagraphOfText("Title", "Relatório de Avaliação de Desempenho");
		mainDocumentPart.addParagraphOfText("PERIODO DE AVALIACAO");
		File exportFile = new File("relatorio.docx");
		wordPackage.save(exportFile);
	}
}