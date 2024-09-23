package com.anthonyo.kfc.patrimoineapi.controller;

import com.anthonyo.kfc.patrimoineapi.modele.Patrimoine;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patrimoines")
public class PatrimoineController {

    private final String filePath = "patrimoines.txt"; // Chemin du fichier pour persistance
    private final Map<String, Patrimoine> patrimoines = new HashMap<>();

    @PutMapping("/{id}")
    public Patrimoine createOrUpdatePatrimoine(@PathVariable String id, @RequestBody Patrimoine patrimoine) throws IOException {
        patrimoines.put(id, patrimoine);
        writeToDisk(id, patrimoine);
        return patrimoine;
    }

    @GetMapping("/{id}")
    public Patrimoine getPatrimoine(@PathVariable String id) {
        return patrimoines.get(id);
    }

    private void writeToDisk(String id, Patrimoine patrimoine) throws IOException {
        String data = id + ":" + patrimoine.getPossesseur() + ":" + patrimoine.getDerniereModification() + "\n";
        Files.writeString(Path.of(filePath), data, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
    }
}
