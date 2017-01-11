package org.gooru.nucleus.libs.tenant.algorithm;

import org.gooru.nucleus.libs.tenant.TenantTree;

/**
 * @author ashish on 10/1/17.
 */
public final class TreeOverlapInfoBuilder {

    private TreeOverlapInfoBuilder() {
        throw new AssertionError();
    }

    public static TreeOverlapInfo build2LevelTreeInfo(TenantTree firstTree, TenantTree secondTree) {
        return new TreeOverlapInfo2Levels(firstTree, secondTree);
    }
}
