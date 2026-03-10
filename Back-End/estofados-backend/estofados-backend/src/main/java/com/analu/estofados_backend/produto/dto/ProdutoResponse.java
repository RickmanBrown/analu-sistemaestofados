package com.analu.estofados_backend.produto.dto;

import com.analu.estofados_backend.produto.ProdutoTipo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ProdutoResponse(
  Long id,
  String nome,
  ProdutoTipo tipo,
  String unidade,
  BigDecimal custo,
  BigDecimal precoVenda,
  Boolean ativo,
  OffsetDateTime criadoEm
) {}