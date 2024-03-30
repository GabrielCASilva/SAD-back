package com.trabalho.sad.api.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class RelatorioController {

    @GetMapping("/downloadRelatorio")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadRelatorio() throws IOException {

        File relatorio = new File("relatorio_completo.docx");

        InputStreamResource resource = new InputStreamResource(new FileInputStream(relatorio));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=novo_relatorio.docx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType
                        .parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
                .body(resource);
    }
}
