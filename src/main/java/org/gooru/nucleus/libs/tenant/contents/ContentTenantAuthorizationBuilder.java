package org.gooru.nucleus.libs.tenant.contents;

import org.gooru.nucleus.libs.tenant.TenantTree;

/**
 * @author ashish on 10/1/17.
 */
public final class ContentTenantAuthorizationBuilder {

    private ContentTenantAuthorizationBuilder() {
        throw new AssertionError();
    }

    public static ContentTenantAuthorization build(TenantTree contentTenenatTree, TenantTree userTenantTree,
        ContentTreeAttributes attributes) {
        return new ContentTenantAuthorizer(contentTenenatTree, userTenantTree, attributes);
    }
}
