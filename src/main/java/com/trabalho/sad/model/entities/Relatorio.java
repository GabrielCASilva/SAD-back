package com.trabalho.sad.model.entities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class Relatorio {

    public Relatorio(){}

    public void gerarRelatorio() throws Exception {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();

		mainDocumentPart.addStyledParagraphOfText("Title", "Relatório de Avaliação de Desempenho");
		mainDocumentPart.addParagraphOfText("PERIODO DE AVALIACAO");
        mainDocumentPart.addParagraphOfText("${nome}");
        mainDocumentPart.addParagraphOfText("${nome_2}");
		File exportFile = new File("relatorio.docx");
		wordPackage.save(exportFile);
	}

    public void gerarRelatorioCompleto(String arquivoEntrada, HashMap<String, String> variables) throws Exception {
        WordprocessingMLPackage wordDoc = WordprocessingMLPackage.load(new File(arquivoEntrada));
        MainDocumentPart mainDocPart = wordDoc.getMainDocumentPart();

        mainDocPart.variableReplace(variables);
    
        wordDoc.save(new File("relatorio_completo.docx"));
        System.out.println("Documento modificado salvo com sucesso!");
    }
}
