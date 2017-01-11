package org.gooru.nucleus.libs.tenant.algorithm;

/**
 * @author ashish on 10/1/17.
 */
public interface TreeOverlapInfo {

    boolean areSameLeaves();

    boolean belongToSameRoot();

    boolean areDisjunctTrees();
}
