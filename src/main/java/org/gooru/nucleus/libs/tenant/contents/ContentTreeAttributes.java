package org.gooru.nucleus.libs.tenant.contents;

/**
 * @author ashish on 10/1/17.
 */
public interface ContentTreeAttributes {

    boolean isContentRootPublished();

    static ContentTreeAttributes build(boolean isContentRootPublished) {
        return () -> isContentRootPublished;
    }
}
