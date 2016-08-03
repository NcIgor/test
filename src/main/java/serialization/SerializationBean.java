package serialization;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import serialization.SerializationBean.SerializationSubBean;
import serialization.SerializationBean.SerializationSubBeanParent;

public class SerializationBean implements Serializable{
	private static final long serialVersionUID = -8235319537689575951L;

	public static class SerializationSubBeanParent implements Serializable{
		private static final long serialVersionUID = 2955472347132241962L;
		
		private Integer intValue;
		private String stringValue;
		private BigDecimal bigDecimal;
		public SerializationSubBeanParent init() {
			this.intValue = new Random().nextInt();
			this.stringValue = "stringValue"  + new Random().nextInt();
			this.bigDecimal = new BigDecimal(new Random().nextInt());
			return this;
		}
		@Override
		public String toString() {
			return "\n" + getClass() + " = " + "SerializationSubBean [intValue=" + intValue + ", stringValue=" + stringValue + ", bigDecimal="
					+ bigDecimal + "]";
		}
	}
	public static class SerializationSubBean extends SerializationSubBeanParent implements Serializable {
		private Integer intValue3;
		public SerializationSubBean init() {
			super.init();
			this.intValue3 = new Random().nextInt();
			return this;
		}
		@Override
		public String toString() {
			return "\n" + getClass() + " = " + super.toString() + " iv:" + intValue3 + " ";
		}
	}
	public static class SerializationSubBean2 extends SerializationSubBeanParent implements Serializable {
		private Integer intValue2;
		public SerializationSubBean2 init() {
			super.init();
			this.intValue2 = new Random().nextInt();
			return this;
		}
		@Override
		public String toString() {
			return "\n" + getClass() + " = " + super.toString() + " iv:" + intValue2 + " ";
		}
	}
	
	private Integer intValue;
	private String stringValue;
	private BigDecimal bigDecimal;
	private SerializationSubBean subBean;
	private List<SerializationSubBeanParent> list;

	
	public SerializationBean init() {
		System.out.println("SerializationBean.SerializationBean()");
		this.intValue = new Random().nextInt();
		this.stringValue = "stringValue"  + new Random().nextInt();
		this.bigDecimal = new BigDecimal(new Random().nextInt());
		this.subBean = new SerializationSubBean().init();;
		this.list = Stream.generate(() -> {
				SerializationSubBeanParent serializationSubBean;
				int r = new Random().nextInt(3);
				if(r == 0){
					serializationSubBean = new SerializationSubBean();
				} else if (r == 1) {
					serializationSubBean = new SerializationSubBean2();
				} else {
					serializationSubBean = new SerializationSubBeanParent();
				}
				return serializationSubBean.init();
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
