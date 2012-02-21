<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 07.07.2010
  Time: 15:54:24
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Provider Suche</title>
    <meta name="heading" content="Provider Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
Suche Provider f&uuml;r das Journal "<s:push value="journal"><s:property value="titel"/></s:push>":
<br>

<s:form id="providerSearch" action="listProvider" method="post" validate="true">

    <s:hidden name="journalId" value="%{journal.id}"/>
    <s:textfield label="Name des Providers" key="institutionSearchTO.name" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
    <br>

</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("providerSearch"));
</script>