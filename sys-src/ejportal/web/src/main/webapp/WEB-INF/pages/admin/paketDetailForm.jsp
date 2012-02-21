<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 03.08.2010
  Time: 13:30:53
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Paket bearbeiten</title>
    <meta name="heading" content="Paket"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="paketForm" action="editPaket" method="post" validate="true">
<s:hidden key="paket.paketId"/>
    <s:textfield label="Paketname" key="paket.paketName" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listPakete" var="back">
    <s:param name="paketId" value="%{paket.paketId}"/>
</s:url>
<a href="${back}">zurueck zum Paket (ohne Speichern)</a>
--%>
<script type="text/javascript">
    Form.focusFirstElement($("paketForm"));
</script>