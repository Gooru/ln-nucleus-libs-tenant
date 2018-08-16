package org.gooru.nucleus.libs.tenant.classes;

/**
 * @author szgooru on 16-Aug-2018
 */
public interface ClassAttributes {

	boolean isClassPublished();
	
	static ClassAttributes build (boolean isClassPublished) {
		return () -> isClassPublished;
	}
}
