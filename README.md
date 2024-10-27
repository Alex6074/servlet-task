# Servlets task

## Description
An application has a login page. The correct logins are "user" with password "2222" and "admin" with password "1111". Admin can add new users.
AuthFilter checks session attribute "user" for paths `/user/*`. If there isn't, it redirects the request to the `/login.jsp` page.

## Tomcat settings
![img.png](img.png)

## Application screenshots

**login.jsp**

![img_1.png](img_1.png)

**admin.jsp**

![img_2.png](img_2.png)

**hello.jsp**

![img_3.png](img_3.png)
## Additional information
If there are problems with deployment, you need to add jstl-1.2.jar to the apache-tomcat\lib folder