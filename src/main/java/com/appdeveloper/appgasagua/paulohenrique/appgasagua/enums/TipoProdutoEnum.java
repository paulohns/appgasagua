<<<<<<< HEAD
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

public enum TipoProdutoEnum {

	VINTE_LITROS("Garrafão 20 litros", 0), DEZ_LITROS("Garrafão 10 litros", 0),  
	CINCO_LITROS("Garrafão 5 litros", 0), SEIS_LITROS("Garrafão 6 litros", 0),
	P_90("Botijão 90 Kg", 1), P_45("Botijão 45 Kg", 1),  
	P_20("Botijão 20 Kg", 1), P_13("Botijão de 13Kg", 1), P_8("Botijão de 8Kg", 1); 

	private String descricao;
	
	/**0 - ÁGUA </BR> 1 - GÁS  */
	private Integer tipoProduto;

	private TipoProdutoEnum(String descricao, Integer tipoProduto) {
		this.setDescricao(descricao);
		this.setTipoProduto(tipoProduto);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Integer tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
=======
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

public enum TipoProdutoEnum {

	VINTE_LITROS("Garrafão 20 litros", 0), DEZ_LITROS("Garrafão 10 litros", 0),  
	CINCO_LITROS("Garrafão 5 litros", 0), SEIS_LITROS("Garrafão 6 litros", 0),
	P_90("Botijão 90 Kg", 1), P_45("Botijão 45 Kg", 1),  
	P_20("Botijão 20 Kg", 1), P_13("Botijão de 13Kg", 1), P_8("Botijão de 8Kg", 1); 

	private String descricao;
	
	/**0 - ÁGUA </BR> 1 - GÁS  */
	private Integer tipoProduto;

	private TipoProdutoEnum(String descricao, Integer tipoProduto) {
		this.setDescricao(descricao);
		this.setTipoProduto(tipoProduto);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Integer tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
>>>>>>> 8d90bf7ae359e854bffd0431365a1f1a76cca0aa
