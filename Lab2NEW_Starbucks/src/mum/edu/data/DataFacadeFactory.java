package mum.edu.data;

/**
 * Returns an implementation of a DataFacade.
 * Could be TestDataImpl or ProdDataImpl, depending on
 * input argument.
 * 
 * Input argument can be "dev" or "prod"
 */
public class DataFacadeFactory {
	public static final DataFacade getDataFacadeInstance(String type) {
		if(type.equals("dev")) {
			return new TestDataImpl();
		}
//		if(type.equals("prod")){
//			return new RealDataBasse()
//		}
		return null;
	}
}