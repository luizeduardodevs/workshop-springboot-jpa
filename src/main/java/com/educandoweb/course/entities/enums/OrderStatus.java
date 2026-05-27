package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	// e colocado numeros na frente pra caso seja adicionado algum novo enum com o tempo, ele nao fique quebrado
	//será inserido manualmente
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;
	
	private OrderStatus(int code) {//o contrustor do tipo enum ele é private
		this.code = code;
	}
	public int getCode() {//acessando ao mundo exterior
		return code;
	}
	// metodo para converter um valor numerico para um tipo enumerado
	//static porque nao precisa ser instanciado
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value: OrderStatus.values()) {//value() percorre todos os tipos enumerados
			if(value.getCode()== code) {
				return value;
			}
		}
		throw new IllegalArgumentException("code invalid");
	}
	
}
