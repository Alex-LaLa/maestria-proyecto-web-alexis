package com.univo.backend_app.ai.prompts;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LowStockPromptBuilder {

    public String build(List<Map<String,Object>> products){

        StringBuilder prompt = new StringBuilder();

        prompt.append("""
                Eres un consultor experto en administración de inventarios.

                Analiza los siguientes productos con inventario bajo.

                """);

        for(Map<String,Object> product : products){

            prompt.append("""
                    
                    Producto: %s
                    Categoría: %s
                    Stock actual: %s
                    Nivel de reorden: %s
                    
                    """
                    .formatted(

                            product.get("nombre"),
                            product.get("categoria"),
                            product.get("unidades_disponibles"),
                            product.get("nivel_reorden")

                    ));

        }

        prompt.append("""

                Clasifica los productos usando estas reglas:
                
                - CRÍTICO: cuando el stock actual sea menor al nivel de reorden.
                - ATENCIÓN: cuando el stock actual sea igual o hasta un 30% superior al nivel de reorden.
                - NORMAL: cuando el inventario sea suficiente.
                
                Explica cuáles necesitan atención inmediata.
                
                No inventes información.
                
                Usa únicamente los datos proporcionados.
                
                Al final proporciona recomendaciones prácticas para el dueño del negocio.
                
                Responde en español.
                """);

        return prompt.toString();

    }

    }