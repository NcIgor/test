package serialization;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import serialization.SerializationBean.SerializationSubBean;

public class SerializationBean implements Serializable{
	private static final long serialVersionUID = -8235319537689575951L;


	public static class SerializationSubBean implements Serializable{
		private static final long serialVersionUID = 2955472347132241962L;
		
		private Integer intValue;
		private String stringValue;
		private BigDecimal bigDecimal;
		public SerializationSubBean init() {
			this.intValue = new Random().nextInt();
			this.stringValue = "stringValue"  + new Random().nextInt();
			this.bigDecimal = new BigDecimal(new Random().nextInt());
			return this;
		}
		@Override
		public String toString() {
			return "SerializationSubBean [intValue=" + intValue + ", stringValue=" + stringValue + ", bigDecimal="
					+ bigDecimal + "]";
		}
	}
	
	private Integer intValue;
	private String stringValue;
	private BigDecimal bigDecimal;
	private SerializationSubBean subBean;
	private List<SerializationSubBean> list;

	
	public SerializationBean init() {
		System.out.println("SerializationBean.SerializationBean()");
		this.intValue = new Random().nextInt();
		this.stringValue = "stringValue"  + new Random().nextInt();
		this.bigDecimal = new BigDecimal(new Random().nextInt());
		this.subBean = new SerializationSubBean().init();;
		this.list = Stream.generate(() -> {
				return new SerializationSubBean().init();
			}).limit(10)
			.collect(Collectors.toList());
		return this;
	}


	@Override
	public String toString() {
		return "SerializationBean [intValue=" + intValue + ", stringValue=" + stringValue + ", bigDecimal=" + bigDecimal
				+ ", subBean=" + subBean + ", list=" + list + "]";
	}
}
