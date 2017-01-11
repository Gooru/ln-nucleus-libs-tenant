package org.gooru.nucleus.libs.tenant.db.entities;

import java.util.Objects;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * @author ashish on 9/1/17.
 */
@Table("tenant")
public class Tenant extends Model {
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

    public static final String QUERY_FETCH_TENANT =
        "select id, content_visibility, user_visibility, class_visibility, parent_tenant from tenant where status = "
            + "'active'";

    public String getTenantId() {
        return this.getString(ID);
    }

    public boolean isContentVisibilityGlobal() {
        return Objects.equals(this.getString(CONTENT_VISIBILITY), CONTENT_VISIBILITY_GLOBAL);
    }

    public boolean isContentVisibilityDiscoverable() {
        return Objects.equals(this.getString(CONTENT_VISIBILITY), CONTENT_VISIBILITY_DISCOVERABLE);
    }

    public boolean isContentVisibilityTenant() {
        return Objects.equals(this.getString(CONTENT_VISIBILITY), CONTENT_VISIBILITY_TENANT);
    }

    public boolean isUserVisibilityGlobal() {
        return Objects.equals(this.getString(USER_VISIBILITY), USER_VISIBILITY_GLOBAL);
    }

    public boolean isUserVisibilityTenant() {
        return Objects.equals(this.getString(USER_VISIBILITY), USER_VISIBILITY_TENANT);
    }

    public boolean isClassVisibilityTenant() {
        return Objects.equals(this.getString(CLASS_VISIBILITY), CLASS_VISIBILITY_TENANT);
    }

    public String getParentTenantId() {
        return this.getString(PARENT_TENANT);
    }

}
