package com.analu.estofados_backend.produto;

import com.analu.estofados_backend.produto.dto.ProdutoCreateRequest;
import com.analu.estofados_backend.produto.dto.ProdutoResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

  private final ProdutoRepository repository;

  public ProdutoService(ProdutoRepository repository) {
    this.repository = repository;
  }

  public List<ProdutoResponse> listar() {
    return repository.findAll()
      .stream()
      .map(this::toResponse)
      .toList();
  }

  public ProdutoResponse criar(ProdutoCreateRequest req) {
    // Regrinhas simples pra você já ir pegando o costume:
    if (req.custo().compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("Custo não pode ser negativo.");
    }
    if (req.precoVenda().compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("Preço de venda não pode ser negativo.");
    }

    Produto p = new Produto();
    p.setNome(req.nome());
    p.setTipo(req.tipo());
    p.setUnidade(req.unidade());
    p.setCusto(req.custo());
    p.setPrecoVenda(req.precoVenda());

    Produto salvo = repository.save(p);
    return toResponse(salvo);
  }

  private ProdutoResponse toResponse(Produto p) {
    return new ProdutoResponse(
      p.getId(),
      p.getNome(),
      p.getTipo(),
      p.getUnidade(),
      p.getCusto(),
      p.getPrecoVenda(),
      p.getAtivo(),
      p.getCriadoEm()
    );
  }
}