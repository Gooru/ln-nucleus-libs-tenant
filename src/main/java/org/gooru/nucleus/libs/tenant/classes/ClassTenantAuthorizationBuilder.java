package org.gooru.nucleus.libs.tenant.classes;

import org.gooru.nucleus.libs.tenant.TenantTree;

/**
 * @author ashish on 9/1/17.
 */
public final class ClassTenantAuthorizationBuilder {

    private ClassTenantAuthorizationBuilder() {
        throw new AssertionError();
    }

    public static ClassTenantAuthorization build(TenantTree classTenantTree, TenantTree userTenantTree) {
        return new ClassTenantAuthorizer(classTenantTree, userTenantTree);
    }
}
