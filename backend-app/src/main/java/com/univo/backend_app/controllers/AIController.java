package com.univo.backend_app.controllers;

import com.univo.backend_app.services.AIService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ia")
@CrossOrigin(origins = "*")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/consulta")
    public Map<String, String> probar(@RequestParam String pregunta) {
        String respuesta = aiService.preguntar(pregunta);
        return Map.of("respuesta", respuesta);
    }

}