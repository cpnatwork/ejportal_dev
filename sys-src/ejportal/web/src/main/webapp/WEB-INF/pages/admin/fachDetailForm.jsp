<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 05.08.2010
  Time: 18:02:03
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Fach bearbeiten</title>
    <meta name="heading" content="Fach"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="fachForm" action="editFach" method="post" validate="true">
<s:hidden key="fach.fachId"/>
    <s:textfield label="Fachname" key="fach.fachName" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listFachs" var="back">
    <s:param name="fachId" value="%{fach.fachId}"/>
</s:url>
<a href="${back}">zurueck zum Fach (ohne Speichern)</a>
--%>
<script type="text/javascript">
    Form.focusFirstElement($("fachForm"));
</script>