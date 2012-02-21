<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 12:12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Bibliothek Suche</title>
    <meta name="heading" content="Bibliothek Suche"/>
    <meta name="menu" content="SearchMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="bibliotheksmitarbeiterForm" action="listBibliotheksmitarbeiterForEdit" method="post" validate="true">

    <s:textfield key="bibliotheksmitarbeiterSearchTO.name" cssClass="text medium"/>
    <s:textfield key="bibliotheksmitarbeiterSearchTO.abteilungsHauptstelle" cssClass="text medium"/>
    <s:textfield key="bibliotheksmitarbeiterSearchTO.emailanschrift" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("bibliotheksmitarbeiterForm"));
</script>