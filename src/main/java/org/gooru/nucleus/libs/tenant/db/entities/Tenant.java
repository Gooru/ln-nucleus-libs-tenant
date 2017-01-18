package org.gooru.nucleus.libs.tenant.db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author ashish on 9/1/17.
 */
public class Tenant {
    private static final String ID = "id";
    private static final String CONTENT_VISIBILITY = "content_visibility";
    private static final String USER_VISIBILITY = "user_visibility";
    private static final String CLASS_VISIBILITY = "class_visibility";
    private static final String PARENT_TENANT = "parent_tenant";

    private static final String CONTENT_VISIBILITY_GLOBAL = "global";
    private static final String CONTENT_VISIBILITY_DISCOVERABLE = "discoverable";
    private static final String CONTENT_VISIBILITY_TENANT = "tenant";
    private static final String CLASS_VISIBILITY_TENANT = "tenant";
    private static final String USER_VISIBILITY_TENANT = "tenant";
    private static final String USER_VISIBILITY_GLOBAL = "global";

    private final String id;
    private final String contentVisibility;
    private final String userVisibility;
    private final String classVisibility;
    private final String parentTenant;

    public static final String QUERY_FETCH_TENANT =
        "select id, content_visibility, user_visibility, class_visibility, parent_tenant from tenant where status = "
            + "'active'";

    public Tenant(ResultSet resultSet) throws SQLException {
        id = resultSet.getString(ID);
        contentVisibility = resultSet.getString(CONTENT_VISIBILITY);
        userVisibility = resultSet.getString(USER_VISIBILITY);
        classVisibility = resultSet.getString(CLASS_VISIBILITY);
        parentTenant = resultSet.getString(PARENT_TENANT);
    }

    public String getTenantId() {
        return this.id;
    }

    public boolean isContentVisibilityGlobal() {
        return Objects.equals(this.contentVisibility, CONTENT_VISIBILITY_GLOBAL);
    }

    public boolean isContentVisibilityDiscoverable() {
        return Objects.equals(this.contentVisibility, CONTENT_VISIBILITY_DISCOVERABLE);
    }

    public boolean isContentVisibilityTenant() {
        return Objects.equals(this.contentVisibility, CONTENT_VISIBILITY_TENANT);
    }

    public boolean isUserVisibilityGlobal() {
        return Objects.equals(this.userVisibility, USER_VISIBILITY_GLOBAL);
    }

    public boolean isUserVisibilityTenant() {
        return Objects.equals(this.userVisibility, USER_VISIBILITY_TENANT);
    }

    public boolean isClassVisibilityTenant() {
        return Objects.equals(this.classVisibility, CLASS_VISIBILITY_TENANT);
    }

    public String getParentTenantId() {
        return this.parentTenant;
    }

}
