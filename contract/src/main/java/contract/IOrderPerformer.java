/*
 * 
 */
package contract;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * <h1>Interface IOrderPerformer</h1>.
 *
 * @author KETATE
 */
public interface IOrderPerformer {
	
	/**
	 * Order perform.
	 *
	 * @param userOrder the user order
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	void orderPerform(UserOrder userOrder) throws IOException;

}

