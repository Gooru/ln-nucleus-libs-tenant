package org.gooru.nucleus.libs.tenant.settings;

/**
 *
 * @author Ashish <ashish@gooru.org>
 */
public interface TenantSettingsProvider {

    String getContentVisibility();

    String getUserVisibility();

    String getClassVisibility();

    String getDefaultCourseVersion();
    
}
