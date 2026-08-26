package br.edu.ifsp.aula.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/demo")
public class HttpDemoController {
    @GetMapping
    public String index() {
        return "index";
    }
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "termo", required = false) String termo, Model model) {
        model.addAttribute("resultadoBusca", "Você buscou por: " + (termo != null ? termo : "nada"));
        return "index";
    }
    @GetMapping("/recurso/{id}")
    @ResponseBody
    public String obterRecurso(@PathVariable("id") Long id) {
        return "Acessando o recurso com ID: " + id;
    }
    @PostMapping("/processar")
    public String processarFormulario(@RequestParam("mensagem") String mensagem, Model model) {
        model.addAttribute("mensagemRecebida", "Servidor recebeu (POST): " + mensagem);
        return "index";
    }
    @GetMapping("/status")
    public ResponseEntity<String> testarStatus(@RequestParam("tipo") String tipo) {
        if ("ok".equals(tipo)) return ResponseEntity.ok("200 OK");
        if ("erro".equals(tipo)) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500 Internal Server Error");
        if ("nao-encontrado".equals(tipo)) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Not Found");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
    }
}