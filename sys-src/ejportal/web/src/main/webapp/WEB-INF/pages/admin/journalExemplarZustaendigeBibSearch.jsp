<%--
  Created by IntelliJ IDEA.
  User: uj32uvac
  Date: 09.08.2010
  Time: 14:45:38
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Zust&auml;ndige Bibliothek Suche</title>
    <meta name="heading" content="Zust&auml;ndige Bibliothek Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>


Suche zust&auml;ndige Bibliothek f&uuml;r das Exemplar:
<br>

<s:form id="zustaendigeBibSearch" action="listZustaendigeBib" method="post" validate="true">

    <s:hidden name="exemplarId" value="%{exemplarId}"/>
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield label="Name des Eigentuemers" key="sigelSearchTO.name" cssClass="text medium"/>
    <s:textfield label="Bibliothek" key="sigelSearchTO.bibliothek" cssClass="text medium"/>
    <s:textfield label="Fakultaet" key="sigelSearchTO.fakultaet" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("zustaendigeBibSearch"));
</script>