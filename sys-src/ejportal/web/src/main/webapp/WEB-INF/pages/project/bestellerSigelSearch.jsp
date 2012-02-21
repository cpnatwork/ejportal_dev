<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 11.08.2010
  Time: 14:03:47
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Sigel Suche</title>
    <meta name="heading" content="Sigel Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>


Suche Sigel f&uuml;r den Besteller:
<br>

<s:form id="sigelSearch" action="listProjectBestellerSigel" method="post" validate="true">
    <s:hidden name="bestellerId" value="%{bestellerId}"/>
    <s:hidden name="interesseId" value="%{interesseId}"/>
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield label="Name des Eigentümers" key="sigelSearchTO.name" cssClass="text medium"/>
    <s:textfield label="Bibliothek" key="sigelSearchTO.bibliothek" cssClass="text medium"/>
    <s:textfield label="Fakultät" key="sigelSearchTO.fakultaet" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("sigelSearch"));
</script>