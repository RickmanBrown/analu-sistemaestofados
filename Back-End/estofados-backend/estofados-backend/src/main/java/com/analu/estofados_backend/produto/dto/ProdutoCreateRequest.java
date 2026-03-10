package com.analu.estofados_backend.produto.dto;

import com.analu.estofados_backend.produto.ProdutoTipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoCreateRequest(
  @NotBlank String nome,
  @NotNull ProdutoTipo tipo,
  @NotBlank String unidade,
  @NotNull BigDecimal custo,
  @NotNull BigDecimal precoVenda
) {}