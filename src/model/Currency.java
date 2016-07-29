package model;

import java.math.BigDecimal;

public class Currency  {
	
	private String dataCurrency;
	private String codMoeda;
	private String tipo;
	private String moeda;
	private BigDecimal taxaCompra;
	private BigDecimal taxaVenda;
	private BigDecimal paridadeCompra;
	private BigDecimal paridadeVenda;
	
	
	public String getDataCurrency() {
		return dataCurrency;
	}
	public void setDataCurrency(String dataCurrency) {
		this.dataCurrency = dataCurrency;
	}
	public String getCodMoeda() {
		return codMoeda;
	}
	public void setCodMoeda(String codMoeda) {
		this.codMoeda = codMoeda;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public BigDecimal getTaxaCompra() {
		return taxaCompra;
	}
	public void setTaxaCompra(BigDecimal taxaCompra) {
		this.taxaCompra = taxaCompra;
	}
	public BigDecimal getTaxaVenda() {
		return taxaVenda;
	}
	public void setTaxaVenda(BigDecimal taxaVenda) {
		this.taxaVenda = taxaVenda;
	}
	public BigDecimal getParidadeCompra() {
		return paridadeCompra;
	}
	public void setParidadeCompra(BigDecimal paridadeCompra) {
		this.paridadeCompra = paridadeCompra;
	}
	public BigDecimal getParidadeVenda() {
		return paridadeVenda;
	}
	public void setParidadeVenda(BigDecimal paridadeVenda) {
		this.paridadeVenda = paridadeVenda;
	}
	
	
	
}
