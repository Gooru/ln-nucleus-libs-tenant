package org.gooru.nucleus.libs.tenant.classes;

import org.gooru.nucleus.libs.tenant.TenantTree;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfo;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfoBuilder;
import org.gooru.nucleus.libs.tenant.bootstrap.TenantStore;

/**
 * @author ashish on 10/1/17.
 */
class ClassTenantAuthorizer implements ClassTenantAuthorization {
	private final ClassAttributes classAttributes;
	private final TenantTree classTenantTree;
    private final TreeOverlapInfo result;

    public ClassTenantAuthorizer(TenantTree classTenantTree, TenantTree userTenantTree, ClassAttributes classAttributes) {
        result = TreeOverlapInfoBuilder.build2LevelTreeInfo(classTenantTree, userTenantTree);
        this.classTenantTree = classTenantTree;
        this.classAttributes = classAttributes;
    }

    @Override
    public boolean canRead() {
        return result.areSameLeaves() || classTenantVisibilityIsDiscoverableAndClassIsPublished();
    }

    @Override
    public boolean canJoin() {
        return result.areSameLeaves();
    }

    @Override
    public boolean canCollaborate() {
        return result.areSameLeaves();
    }
    
    private boolean classTenantVisibilityIsDiscoverableAndClassIsPublished() {
        return TenantStore.getInstance().getTenantById(this.classTenantTree.tenant()).isClassVisibilityDiscoverable()
            && classAttributes.isClassPublished();
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
