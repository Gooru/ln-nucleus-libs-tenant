package org.gooru.nucleus.libs.tenant;

import java.util.Objects;

/**
 * @author ashish on 6/1/17.
 */
public final class TenantTreeBuilder {

    private TenantTreeBuilder() {
        throw new AssertionError();
    }

    public static TenantTree build(String tenant, String tenantRoot) {
        Objects.requireNonNull(tenant);
        return new TenantTreeImpl(tenant, tenantRoot);
    }
}
