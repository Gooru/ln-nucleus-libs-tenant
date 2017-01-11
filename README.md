Nucleus Libs Tenant
================

Nucleus Libs is set of repositories which are shared libraries and can be used across the nucleus components.

This specific library is dedicated to provide tenant related authorization decisions based on tenancy information of two parties (and some meta information).

There are three levels of parties which can interact with each other:

1. User interaction with users
2. User interaction with content
3. User interaction with class

Content Visibility
--

The content level visibility can be set to one of following:
1. Tenant tree: All contents are visible to users of this tenant as well as any users who belong to this tenant tree
2. Discoverable: The discoverable content from this tenant will be visible to rest of the world while users of tenant tree can see anything
3. Global: All contents from this tenant are visible to everyone else

To start with default value of content visibility will be Tenant tree. Only Gooru tenant will be having visibility value of Global.  

Class Visibility
--
Theoretically, there could be multi level visibility for class also. However, to begin with we only show classes in the same tenant. Note that this is within same tenant and not tenant tree.
 
 User Visibility
 --
 Based on visibility of user, other users may see full profile or limited profile or they may follow this user. To being with there would be only default value for user visibility where full profile will be visible in same tenant tree and follow users would also be allowed in same tenant tree. Outside of tenant tree, only limited profile will be visible. 


Usage
--
To use this library, one needs to follow these steps:
1. Create a component which can initialize the TenantInitializer. This component should be initialized after the DB pool initialization is complete as it requires a DataSource object for initialization
2. Before calling any validity check API, one needs to create TenantTree objects using builder for both entities in question
3. Then call up the *AuthorizationBuilder api to build the autorization handler
4. Call up the authorized and it will return *Authorizer object. This object can provide various answers which should be used by handlers

Build
--
For building this library itself just running ```gradle ```  or ```gradle build``` should suffice.

However, for any component that depends on this library and is added as dependency (e.g. other nucleus components), this library project needs to be present as sibling directory of that project.

We shall move other dependent projects to use [jitpack](https://jitpack.io/) at later point of time.