<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <%@ include file="/common/meta.jsp" %>
    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/application.css'/>"/>
    <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
    <decorator:head/>
</head>

<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class"
                                                                                                  writeEntireProperty="true"/>>
<div id="container">
    <div id="user_nav">
        <%--<jsp:include page="/common/header.jsp"/>   --%>
        <%-- <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
            <c:if test="${currentMenu == 'AdminMenu'}">
                <div id="sub">
                    <menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
                    <menu:displayMenu name="AdminMenu"/>
                    </menu:useMenuDisplayer>
                </div>
            </c:if>    --%>

        <%-- Workaround: Logout nur anzeigen, wenn angemeldet --%>
        <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE,ROLE_LESEN,ROLE_PROJECT,ROLE_EXTERN">
            <div id="logout"><b><a href="/logout.jsp">Logout</a></b></div>
        </authz:authorize>
    </div>

    <jsp:include page="/common/menu.jsp"/>

    <div id="content">
        <%@ include file="/common/messages.jsp" %>
        <decorator:body/>
    </div>

    <div id="footer">
        <jsp:include page="/common/footer.jsp"/>
    </div>

</div>
</body>

</html>
