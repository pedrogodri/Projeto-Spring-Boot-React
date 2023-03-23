package br.com.api.produtos.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoControle {
    
    @GetMapping("/")
    public String Rota() {{
        return "API de produtos funcionando!";
    }}
}
