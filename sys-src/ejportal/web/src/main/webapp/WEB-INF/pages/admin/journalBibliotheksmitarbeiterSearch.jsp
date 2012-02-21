<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 16:39:18
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Bibliothek Suche</title>
    <meta name="heading" content="Bibliothek Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
Suche Bibliothek f&uuml;r das Journal "<s:property value="titel"/>":
<br>

<s:form id="bibliotheksmitarbeiterSearch" action="listBibliotheksmitarbeiter" method="post" validate="true">

    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield label="Bibliothek" key="bibliotheksmitarbeiterSearchTO.name" cssClass="text medium"/>
    <s:textfield key="bibliotheksmitarbeiterSearchTO.abteilungsHauptstelle" cssClass="text medium"/>
    <s:textfield key="bibliotheksmitarbeiterSearchTO.emailanschrift" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
    <br
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("bibliotheksmitarbeiterSearch"));
</script>