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

    public void substituirVariaveis() throws Exception {

        WordprocessingMLPackage wordDoc = WordprocessingMLPackage.load(new File("relatorio.docx"));
        MainDocumentPart mainDocPart = wordDoc.getMainDocumentPart();

        HashMap<String, String> variables = new HashMap<>();
        variables.put("nome", "João");
        variables.put("nome_2", "Marcos");

        mainDocPart.variableReplace(variables);
    
        wordDoc.save(new File("novo_relatorio.docx"));
        System.out.println("Documento modificado salvo com sucesso!");
    }

    public void gerarRelatorioCompleto(String arquivoEntrada, HashMap<String, String> variables) throws Exception {
        WordprocessingMLPackage wordDoc = WordprocessingMLPackage.load(new File(arquivoEntrada));
        MainDocumentPart mainDocPart = wordDoc.getMainDocumentPart();

        mainDocPart.variableReplace(variables);
    
        wordDoc.save(new File("relatorio_completo.docx"));
        System.out.println("Documento modificado salvo com sucesso!");
    }
}

// public static void main(String[] args) {
//     try {
//         // Carregue o documento Word modelo
//         WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File("caminho/do/seu/modelo.docx"));
//         MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();

//         // Mapeie as variáveis para os valores desejados
//         Map<String, String> variables = new HashMap<>();
//         variables.put("nome", "João");
//         variables.put("idade", "30");
//         // Adicione outras variáveis conforme necessário

//         // Substitua as variáveis no documento
//         String docxContent = mainDocumentPart.getXML();
//         for (Map.Entry<String, String> entry : variables.entrySet()) {
//             String variable = "${" + entry.getKey() + "}";
//             String value = entry.getValue();
//             docxContent = docxContent.replace(variable, value);
//         }
//         mainDocumentPart.setContents(docxContent);

//         // Salve o documento modificado
//         wordMLPackage.save(new File("caminho/do/seu/novo_documento.docx"));
        
//         System.out.println("Documento modificado salvo com sucesso!");
//     } catch (Docx4JException e) {
//         e.printStackTrace();
//     }
// }
