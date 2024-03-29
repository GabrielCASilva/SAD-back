package com.trabalho.sad.api.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trabalho.sad.SadApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class RelatorioController {

    @GetMapping("/gerarRelatorio")
    public String gerarRelatorio() {
        try {
            SadApplication.gerarRelatorio();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/downloadRelatorio";
    }

    @GetMapping("/downloadRelatorio")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadRelatorio() throws IOException {

        File relatorio = new File("relatorio.docx");

        InputStreamResource resource = new InputStreamResource(new FileInputStream(relatorio));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio.docx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType
                        .parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
                .body(resource);
    }
}
