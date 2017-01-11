package org.gooru.nucleus.libs.tenant.classes;

/**
 * @author ashish on 6/1/17.
 */
public interface ClassTenantAuthorization {

    boolean canRead();

    boolean canJoin();

    AuthorizationReason reason();

    enum AuthorizationReason {
        USER_CLASS_TENANT_MATCH,
        USER_CLASS_TENANT_TREE_MATCH,
        UNAUTHORIZED
    }
}
