<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 19.07.2010
  Time: 13:45:14
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Paket Suche</title>
    <meta name="heading" content="Paket Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
Suche Paket f&uuml;r Journal :
<br>

<s:form id="paketSearch" action="listPaket" method="post" validate="true">

    <s:hidden name="journalId" value="%{journal.id}"/>
    <s:textfield label="Name des Pakets" key="paketName" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("paketSearch"));
</script>