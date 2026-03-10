package com.analu.estofados_backend.produto;

import com.analu.estofados_backend.produto.dto.ProdutoCreateRequest;
import com.analu.estofados_backend.produto.dto.ProdutoResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:5173") // depois a gente melhora isso
public class ProdutoController {

  private final ProdutoService service;

  public ProdutoController(ProdutoService service) {
    this.service = service;
  }

  @GetMapping
  public List<ProdutoResponse> listar() {
    return service.listar();
  }

  @PostMapping
  public ProdutoResponse criar(@RequestBody @Valid ProdutoCreateRequest req) {
    return service.criar(req);
  }
}