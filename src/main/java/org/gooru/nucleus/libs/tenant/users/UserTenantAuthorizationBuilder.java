package org.gooru.nucleus.libs.tenant.users;

import org.gooru.nucleus.libs.tenant.TenantTree;

/**
 * @author ashish on 9/1/17.
 */
public final class UserTenantAuthorizationBuilder {

    private UserTenantAuthorizationBuilder() {
        throw new AssertionError();
    }

    public static UserTenantAuthorization build(TenantTree loggedInUserTenantTree, TenantTree secondaryUserTenantTree) {
        // TODO
        return new UserTenantAuthorizer(loggedInUserTenantTree, secondaryUserTenantTree);
    }
}
