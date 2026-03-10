package com.analu.estofados_backend.produto;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity // diz: "isso vira uma tabela"
@Table(name = "produtos") // nome da tabela no banco
public class Produto {

  @Id // chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment no Postgres
  private Long id;

  @Column(nullable = false) // não pode ser null no banco
  private String nome;

  @Enumerated(EnumType.STRING) // salva o enum como TEXTO (mais legível no banco)
  @Column(nullable = false)
  private ProdutoTipo tipo;

  @Column(nullable = false)
  private String unidade = "UN"; // ex: UN, KG, M...

  @Column(nullable = false, precision = 12, scale = 2)
  private BigDecimal custo = BigDecimal.ZERO;

  @Column(name = "preco_venda", nullable = false, precision = 12, scale = 2)
  private BigDecimal precoVenda = BigDecimal.ZERO;

  @Column(nullable = false)
  private Boolean ativo = true; // melhor que deletar do banco

  @Column(name = "criado_em", nullable = false)
  private OffsetDateTime criadoEm = OffsetDateTime.now();

  // getters e setters (no começo vamos simples, sem Lombok)

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }

  public ProdutoTipo getTipo() { return tipo; }
  public void setTipo(ProdutoTipo tipo) { this.tipo = tipo; }

  public String getUnidade() { return unidade; }
  public void setUnidade(String unidade) { this.unidade = unidade; }

  public BigDecimal getCusto() { return custo; }
  public void setCusto(BigDecimal custo) { this.custo = custo; }

  public BigDecimal getPrecoVenda() { return precoVenda; }
  public void setPrecoVenda(BigDecimal precoVenda) { this.precoVenda = precoVenda; }

  public Boolean getAtivo() { return ativo; }
  public void setAtivo(Boolean ativo) { this.ativo = ativo; }

  public OffsetDateTime getCriadoEm() { return criadoEm; }
  public void setCriadoEm(OffsetDateTime criadoEm) { this.criadoEm = criadoEm; }
}