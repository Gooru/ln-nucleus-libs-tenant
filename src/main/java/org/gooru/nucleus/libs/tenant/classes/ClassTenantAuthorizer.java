package org.gooru.nucleus.libs.tenant.classes;

import org.gooru.nucleus.libs.tenant.TenantTree;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfo;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfoBuilder;

/**
 * @author ashish on 10/1/17.
 */
class ClassTenantAuthorizer implements ClassTenantAuthorization {
    private final TreeOverlapInfo result;

    public ClassTenantAuthorizer(TenantTree classTenantTree, TenantTree userTenantTree) {
        result = TreeOverlapInfoBuilder.build2LevelTreeInfo(classTenantTree, userTenantTree);
    }

    @Override
    public boolean canRead() {
        return result.areSameLeaves();
    }

    @Override
    public boolean canJoin() {
        return result.areSameLeaves();
    }

    @Override
    public AuthorizationReason reason() {
        if (result.areSameLeaves()) {
            return AuthorizationReason.USER_CLASS_TENANT_MATCH;
        } else if (result.belongToSameRoot()) {
            return AuthorizationReason.USER_CLASS_TENANT_TREE_MATCH;
        } else {
            return AuthorizationReason.UNAUTHORIZED;
        }
    }
}
