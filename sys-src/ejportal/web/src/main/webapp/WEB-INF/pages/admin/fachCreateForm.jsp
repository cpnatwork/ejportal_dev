<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 06.08.2010
  Time: 09:50:45
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Neues Fach anlegen</title>
    <meta name="heading" content="Neues Fach"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="fachForm" action="createFach" method="post" validate="true">

    <s:textfield label="Fachname" key="fach.fachName" labelposition="left" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listFache" var="back">
    <s:param name="fachId" value="%{fach.fachId}"/>
</s:url>
<a href="${back}">Abbrechen</a>
--%>
<script type="text/javascript">
    Form.focusFirstElement($("fachForm"));
</script>