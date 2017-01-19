package org.gooru.nucleus.libs.tenant.contents;

import org.gooru.nucleus.libs.tenant.TenantTree;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfo;
import org.gooru.nucleus.libs.tenant.algorithm.TreeOverlapInfoBuilder;
import org.gooru.nucleus.libs.tenant.bootstrap.TenantStore;

/**
 * @author ashish on 10/1/17.
 */
class ContentTenantAuthorizer implements ContentTenantAuthorization {

    private final ContentTreeAttributes attributes;
    private final TreeOverlapInfo result;
    private final TenantTree contentTenantTree;

    ContentTenantAuthorizer(TenantTree contentTenenatTree, TenantTree userTenantTree,
        ContentTreeAttributes attributes) {
        this.attributes = attributes;
        this.result = TreeOverlapInfoBuilder.build2LevelTreeInfo(contentTenenatTree, userTenantTree);
        this.contentTenantTree = contentTenenatTree;
    }

    @Override
    public boolean canRead() {
        return result.belongToSameRoot() || result.areSameLeaves() || contentTenantVisibilityIsGlobal()
            || contentTenantVisibilityIsDiscoverableAndContentIsPublished();
    }

    @Override
    public boolean canCollaborate() {
        return result.belongToSameRoot() || result.areSameLeaves();
    }

    private boolean contentTenantVisibilityIsDiscoverableAndContentIsPublished() {
        return TenantStore.getInstance().getTenantById(contentTenantTree.tenant()).isContentVisibilityDiscoverable()
            && attributes.isContentRootPublished();
    }

    private boolean contentTenantVisibilityIsGlobal() {
        return TenantStore.getInstance().getTenantById(contentTenantTree.tenant()).isContentVisibilityGlobal();
    }
}
