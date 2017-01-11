package org.gooru.nucleus.libs.tenant.users;

import org.gooru.nucleus.libs.tenant.TenantTree;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfo;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfoBuilder;

/**
 * @author ashish on 10/1/17.
 */
class UserTenantAuthorizer implements UserTenantAuthorization {
    private final TreeOverlapInfo result;

    public UserTenantAuthorizer(TenantTree loggedInUserTenantTree, TenantTree secondaryUserTenantTree) {
        result = TreeOverlapInfoBuilder.build2LevelTreeInfo(loggedInUserTenantTree, secondaryUserTenantTree);
    }

    @Override
    public boolean canAccessFullProfile() {
        return result.areSameLeaves() || result.belongToSameRoot();
    }

    @Override
    public boolean canAccessPartialProfile() {
        return result.areDisjunctTrees();
    }

    @Override
    public boolean canFollow() {
        return result.areSameLeaves() || result.belongToSameRoot();
    }

    @Override
    public boolean canBeAddedAsCollaborator() {
        return result.areSameLeaves() || result.belongToSameRoot();
    }

    @Override
    public AuthorizationReason reason() {
        if (result.areSameLeaves()) {
            return AuthorizationReason.USERS_TENANT_MATCH;
        } else if (result.belongToSameRoot()) {
            return AuthorizationReason.USERS_TENANT_TREE_MATCH;
        } else {
            return AuthorizationReason.USERS_TENANT_TREE_MISMATCH;
        }
    }
}
