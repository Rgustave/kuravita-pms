/**
 * 
 */
package com.kuravita.inventorymanagementservice.utils;

/**
 * @author gustave.mugabo
 *
 */
public class InventoryMsUtils {

	/**
	 * Check if an object is null
	 * 
	 * @param object
	 * @return
	 */

	public static boolean isNull(Object object) {

		return object == null ? true : false;

	}

	/**
	 * Check if an object is null
	 * 
	 * @param object
	 * @return
	 */

	public static boolean nonNull(Object object) {
		return object == null ? false : true;

	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public boolean checkInputString(String input) {
	        return (input == null || input.trim().length() == 0);
	    }

}
