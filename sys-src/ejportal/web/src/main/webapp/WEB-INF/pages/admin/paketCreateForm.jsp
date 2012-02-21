<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 03.08.2010
  Time: 13:29:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Neues Paket anlegen</title>
    <meta name="heading" content="Neues Paket"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="paketForm" action="createPaket" method="post" validate="true">
    <s:textfield label="Paketname" key="paket.paketName" labelposition="left" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listPakete" var="back">
    <s:param name="paketId" value="%{paket.paketId}"/>
</s:url>
<a href="${back}">Abbrechen</a>
--%>
<script type="text/javascript">
    Form.focusFirstElement($("paketForm"));
</script>
