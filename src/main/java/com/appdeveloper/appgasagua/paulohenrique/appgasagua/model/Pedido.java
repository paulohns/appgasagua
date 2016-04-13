package com.appdeveloper.appgasagua.paulohenrique.appgasagua.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.FormaPagamentoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.PedidoFavoritoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.StatusPedidoEnum;

/**
 * @author PauloHenrique
 *
 */
@Access(AccessType.PROPERTY)
@Entity
@Table(name="TB_PEDIDO", schema="public")
public class Pedido{
	
	

	public Pedido() {
		super();
	}
	
	public Pedido(boolean gerarClasses) {
		super();
		if(gerarClasses){
			gasPedido = new Produto();
			aguaPedido = new Produto();
			endereco = new EnderecoPedido();
		}
	}

	private Integer idPedido;

	private String emailCliente;
	
	private BigDecimal valorTotalPedido;
	
    private Integer qntItemAgua;

    private Integer qntItemGas;
	
	private StatusPedidoEnum statusPedido;
	
	private FormaPagamentoEnum formaPgto;
	
	private PedidoFavoritoEnum pedidoFavorito;
	
	private Produto aguaPedido;
	
	private Produto gasPedido;

	private Calendar dataPedido;

	private EnderecoPedido endereco;
	
	private AvaliacaoPedido avaliacaoPedido;
	
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "TB_PEDIDO_ID_SEQ", sequenceName="TB_PEDIDO_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="TB_PEDIDO_ID_SEQ")
	@Column(name="id", unique=true)
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	@Column(name = "email_cliente", length=100)
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	@Column(name="valor_total")
	public BigDecimal getValorTotalPedido() {
		return valorTotalPedido;
	}
	public void setValorTotalPedido(BigDecimal valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}
	
	@Column(name="qntd_item_agua")
	public Integer getQntItemAgua() {
		return qntItemAgua;
	}
	public void setQntItemAgua(Integer qntItemAgua) {
		this.qntItemAgua = qntItemAgua;
	}
	
	@Column(name="qntd_item_gas")
	public Integer getQntItemGas() {
		return qntItemGas;
	}
	public void setQntItemGas(Integer qntItemGas) {
		this.qntItemGas = qntItemGas;
	}
	
	@Column(name="status_pedido", length=1)
	@Enumerated(EnumType.ORDINAL)
	public StatusPedidoEnum getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedidoEnum statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	@OneToOne
	@ForeignKey(name = "id_agua")
	public Produto getAguaPedido() {
		return aguaPedido;
	}
	public void setAguaPedido(Produto aguaPedido) {
		this.aguaPedido = aguaPedido;
	}
	
	@OneToOne
	@ForeignKey(name = "id_gas")
	public Produto getGasPedido() {
		return gasPedido;
	}
	public void setGasPedido(Produto gasPedido) {
		this.gasPedido = gasPedido;
	}
	
	@Column(name="forma_pgto", length=1)
	@Enumerated(EnumType.ORDINAL)
	public FormaPagamentoEnum getFormaPgto() {
		return formaPgto;
	}
	public void setFormaPgto(FormaPagamentoEnum formaPgto) {
		this.formaPgto = formaPgto;
	}
	
	@Column(name="pedido_favorito", length=1)
	@Enumerated(EnumType.ORDINAL)
	public PedidoFavoritoEnum getPedidoFavorito() {
		return pedidoFavorito;
	}
	public void setPedidoFavorito(PedidoFavoritoEnum pedidoFavorito) {
		this.pedidoFavorito = pedidoFavorito;
	}
	
	@Column(name="data_pedido")
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	@OneToOne
	@ForeignKey(name = "id_avaliacao")
	public AvaliacaoPedido getAvaliacaoPedido() {
		return avaliacaoPedido;
	}
	public void setAvaliacaoPedido(AvaliacaoPedido avaliacaoPedido) {
		this.avaliacaoPedido = avaliacaoPedido;
	}
	
	@OneToOne
	@ForeignKey(name = "id_endereco")
	public EnderecoPedido getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoPedido endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * @return data do pedido formatada
	 */
	@Transient
	public String getDataPedidoFormatada(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(dataPedido.getTime());
	}
	
	@Transient
	public String getDescricao(){
		return "Item 1: "+gasPedido.getDescricao() + " Item 2:" +aguaPedido.getDescricao();
	}

}
