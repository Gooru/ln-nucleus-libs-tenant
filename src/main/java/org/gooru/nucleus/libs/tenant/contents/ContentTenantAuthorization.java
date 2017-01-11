package org.gooru.nucleus.libs.tenant.contents;

/**
 * @author ashish on 6/1/17.
 */
public interface ContentTenantAuthorization {

    boolean canRead();

    enum AuthorizationReason {
        USER_CONTENT_TENANT_MATCH,
        USER_CONTENT_TENANT_TREE_MATCH,
        CONTENT_TENANT_DISCOVERABLE,
        CONTENT_TENANT_GLOBAL,
        UNAUTHORIZED
    }
}
