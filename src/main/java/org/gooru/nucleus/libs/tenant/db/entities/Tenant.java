package org.gooru.nucleus.libs.tenant.db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import org.gooru.nucleus.libs.tenant.settings.TenantSettingsProvider;

/**
 * @author ashish on 9/1/17.
 */
public class Tenant implements TenantSettingsProvider {
    private static final String ID = "id";
    private static final String CONTENT_VISIBILITY = "content_visibility";
    private static final String USER_VISIBILITY = "user_visibility";
    private static final String CLASS_VISIBILITY = "class_visibility";
    private static final String PARENT_TENANT = "parent_tenant";
    private static final String DEFAULT_COURSE_VERSION = "default_course_version";

    private static final String CONTENT_VISIBILITY_GLOBAL = "global";
    private static final String CONTENT_VISIBILITY_DISCOVERABLE = "discoverable";
    private static final String CONTENT_VISIBILITY_TENANT = "tenant";
    private static final String CLASS_VISIBILITY_TENANT = "tenant";
    private static final String CLASS_VISIBILITY_DISCOVERABLE = "discoverable";
    private static final String USER_VISIBILITY_TENANT = "tenant";
    private static final String USER_VISIBILITY_GLOBAL = "global";

    private final String id;
    private final String contentVisibility;
    private final String userVisibility;
    private final String classVisibility;
    private final String parentTenant;
    private final String defaultCourseVersion;

    public static final String QUERY_FETCH_TENANT =
        "select id, content_visibility, user_visibility, class_visibility, parent_tenant, default_course_version from "
        + "tenant where status = 'active'";

    public Tenant(ResultSet resultSet) throws SQLException {
        id = resultSet.getString(ID);
        contentVisibility = resultSet.getString(CONTENT_VISIBILITY);
        userVisibility = resultSet.getString(USER_VISIBILITY);
        classVisibility = resultSet.getString(CLASS_VISIBILITY);
        parentTenant = resultSet.getString(PARENT_TENANT);
        defaultCourseVersion = resultSet.getString(DEFAULT_COURSE_VERSION);
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
    
    public boolean isClassVisibilityDiscoverable() {
    	return Objects.equals(this.classVisibility, CLASS_VISIBILITY_DISCOVERABLE);
    }

    public String getParentTenantId() {
        return this.parentTenant;
    }

    @Override
    public String getContentVisibility() {
        return this.contentVisibility;
    }

    @Override
    public String getUserVisibility() {
        return this.userVisibility;
    }

    @Override
    public String getClassVisibility() {
        return this.classVisibility;
    }

    @Override
    public String getDefaultCourseVersion() {
        return this.defaultCourseVersion;
    }

}
