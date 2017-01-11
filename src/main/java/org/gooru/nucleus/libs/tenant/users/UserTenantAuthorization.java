package org.gooru.nucleus.libs.tenant.users;

/**
 * @author ashish on 6/1/17.
 */
public interface UserTenantAuthorization {

    boolean canAccessFullProfile();

    boolean canAccessPartialProfile();

    boolean canFollow();

    boolean canBeAddedAsCollaborator();

    AuthorizationReason reason();

    enum AuthorizationReason {
        USERS_TENANT_MATCH,
        USERS_TENANT_TREE_MATCH,
        USERS_TENANT_TREE_MISMATCH
    }
}
