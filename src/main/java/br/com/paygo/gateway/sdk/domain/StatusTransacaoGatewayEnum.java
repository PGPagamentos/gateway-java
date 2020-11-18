package br.com.paygo.gateway.sdk.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusTransacaoGatewayEnum {

	TRANSACAO_INICIADA(0, "TRANSACAO INICIADA"),
	AGUARDANDO_CONFIRMACAO(1, "AGUARDANDO CONFIRMACAO"),
	EXPIRADA(4, "EXPIRADA"),
	AUTORIZADA(5, "AUTORIZADA"),
	CONFIRMADA(6, "CONFIRMADA"),
	NEGADA(7, "NEGADA"),
	CANCELAMENTO_EM_ANDAMENTO(8, "CANCELAMENTO EM ANDAMENTO"),
	CANCELADA(9, "CANCELADA"),
	PENDENTE_DE_CONFIRMACAO(10, "PENDENTE DE CONFIRMACAO"),
	FALHA_NA_COMUNICACAO_COM_FORNECEDOR(11, "FALHA NA COMUNICACAO COM FORNECEDOR"),
	STATUS_NAO_TRATADO(-99, "STATUS NÃO TRATADO");
	
	private int id;
	private String description;
	
	StatusTransacaoGatewayEnum(int id, String description) {
		this.id = id;
		this.description = description;
	}

    @JsonValue
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

    @JsonCreator
	public static StatusTransacaoGatewayEnum getStatusEnum(int status){
		for (StatusTransacaoGatewayEnum statusEnum : StatusTransacaoGatewayEnum.values()) {
			if (statusEnum.getId() == status) {
				return statusEnum;
			}
		}
		return STATUS_NAO_TRATADO;
	}
}
