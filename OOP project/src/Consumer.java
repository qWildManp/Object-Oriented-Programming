import java.io.Serializable;

/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
interface Consumer extends Serializable {//interface of consumer
	 public String getName();
	 public int getPower();
	 public void morePower(int amount) throws NotAPowerGeneratorException;
}
