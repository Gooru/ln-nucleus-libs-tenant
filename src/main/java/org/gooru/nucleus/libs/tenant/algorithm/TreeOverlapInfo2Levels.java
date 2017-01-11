package org.gooru.nucleus.libs.tenant.algorithm;

import java.util.Objects;

import org.gooru.nucleus.libs.tenant.TenantTree;

/**
 * @author ashish on 10/1/17.
 */
class TreeOverlapInfo2Levels implements TreeOverlapInfo {

    private final TenantTree firstTree, secondTree;

    public TreeOverlapInfo2Levels(TenantTree firstTree, TenantTree secondTree) {
        this.firstTree = firstTree;
        this.secondTree = secondTree;
    }

    @Override
    public boolean areSameLeaves() {
        return Objects.equals(firstTree.tenant(), secondTree.tenant());
    }

    @Override
    public boolean belongToSameRoot() {
        return firstTree.tenantRoot() != null && secondTree.tenantRoot() != null && Objects
            .equals(firstTree.tenantRoot(), secondTree.tenantRoot());
    }

    @Override
    public boolean areDisjunctTrees() {
        return !(areSameLeaves() || belongToSameRoot());
    }
}
