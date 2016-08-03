package serialization;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.fusesource.hawtbuf.ByteArrayInputStream;
import org.springframework.util.Assert;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoTest {
	public static void main(String[] args) throws KryoException, FileNotFoundException{
		byte[] byteArray = null;
		SerializationBean someObject=new SerializationBean().init();
		int loops = 10000;
		long start = System.nanoTime();
		Kryo kryo=new Kryo();
		for (int i = 0; i < loops; i++) {
			//serialise object
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
			try (Output output = new Output(byteArrayOutputStream)) {
				kryo.writeClassAndObject(output, someObject);
			}
			byteArray = byteArrayOutputStream.toByteArray();
		}
		System.out.println("serialize: " + (System.nanoTime() - start)/1000f/loops);
		
		start = System.nanoTime();
		SerializationBean retrievedObject = null;
		for (int i = 0; i < loops; i++) {
			try (Input input = new Input( new ByteArrayInputStream(byteArray))){
//	            Kryo kryo=new Kryo();
				retrievedObject = (SerializationBean)kryo.readClassAndObject(input);
	        }
		}
		System.out.println("deserialize: " + (System.nanoTime() - start)/1000f/loops);

		
		Assert.isTrue(someObject.toString().equals(retrievedObject.toString()));
		
		
        //try-with-resources used to autoclose resources
        try (Output output = new Output(new FileOutputStream("KryoTest.ser"))) {
//            Kryo kryo=new Kryo();
            kryo.writeClassAndObject(output, someObject);
        }
        System.out.println("Original obj:\n " + someObject.toString());

        //deserialise object

        try (Input input = new Input( new FileInputStream("KryoTest.ser"))){
//            Kryo kryo=new Kryo();
            retrievedObject=(SerializationBean)kryo.readClassAndObject(input);
        }

        System.out.println("Retrieved from file: \n" + retrievedObject.toString());
        Assert.isTrue(someObject.toString().equals(retrievedObject.toString()));
    }
}
