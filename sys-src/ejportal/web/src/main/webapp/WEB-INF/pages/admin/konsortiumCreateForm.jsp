<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 03.08.2010
  Time: 15:48:37
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Konsortium umbenennen</title>
    <meta name="heading" content="Konsortium"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="konsortiumForm" action="createKonsortium" method="post" validate="true">
    <s:textfield label="Konsortium" key="konsortium.konsortiumName" required="true" cssClass="text medium" labelposition="left"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listKonsortien" var="back">
    <s:param name="id" value="%{konsortium.konsortiumId}"/>
</s:url>
<a href="${back}">Abbrechen</a>
--%>

<script type="text/javascript">
    Form.focusFirstElement($("konsortiumForm"));
</script>