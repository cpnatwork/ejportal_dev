<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 14.07.2010
  Time: 16:22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Konsortium Suche</title>
    <meta name="heading" content="Konsortium Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
Suche Konsortium f&uuml;r Journal:
<br>

<s:form id="konsortiumSearch" action="listKonsortium" method="post" validate="true">

    <s:hidden name="journalId" value="%{journal.id}"/>
    <s:textfield label="Name des Konsortiums" key="konsortiumName" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("konsortiumSearch"));
</script>