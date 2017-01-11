package org.gooru.nucleus.libs.tenant;

/**
 * @author ashish on 6/1/17.
 */
class TenantTreeImpl implements TenantTree {

    private final String tenant;
    private final String tenantRoot;

    TenantTreeImpl(String tenant, String tenantRoot) {
        this.tenant = tenant;
        this.tenantRoot = tenantRoot;
    }

    @Override
    public String tenantRoot() {
        return tenantRoot;
    }

    @Override
    public String tenant() {
        return tenant;
    }
}
