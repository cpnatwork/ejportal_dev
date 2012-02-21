<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <meta name="heading" content="<fmt:message key='mainMenu.heading'/>"/>
    <meta name="menu" content="MainMenu"/>
</head>

<p><fmt:message key="mainMenu.message"/></p>

<div class="separator"></div>

<ul class="glassList">
    <%--<li>
        <a href="<c:url value='/editProfile.html'/>"><fmt:message key="menu.user"/></a>
    </li>--%>
    <li>
        <a href="<c:url value="/searchJournals.html"/>">Journale suchen</a>
    </li>

    <%--
    <li>
    <a href="<c:url value="/listJournals.html"/>">Journale anzeigen</a>
    </li>
    --%>

    <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
        <li>
            <a href="<c:url value="/admin/masterdataMenu.html"/>">Stammdaten verwalten</a>
        </li>

        <li>
        <a href="<c:url value="/listBearbeitungsdatum.html"/>">Termine anzeigen</a>
        </li>
    </authz:authorize>


    <%--<li>
        <a href="<c:url value="/showJournalCreateForm.html"/>">Neues Journal anlegen</a>
    </li>
    <li>
        <a href="<c:url value="/listVerlage.html"/>">Verlage anzeigen</a>
    </li>
    <li>
        <a href="<c:url value="/searchInstitutions.html"/>">Institutionen suchen</a>
    </li>
    <li>
        <a href="<c:url value="/listInstitutions.html"/>">Institutionen anzeigen</a>
    </li>
     <li>
        <a href="<c:url value="/showInstitutionCreateForm.html"/>">Neue Institution anlegen</a>
    </li>

    <li>
        <a href="<c:url value='/uploadFile.html'/>"><fmt:message key="menu.selectFile"/></a>
    </li>--%>

</ul>
