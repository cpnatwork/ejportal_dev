<%--
  Created by IntelliJ IDEA.
  User: florian
  Date: 11.08.2010
  Time: 09:58:51
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Fach Suche</title>
    <meta name="heading" content="Fach Suche"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="ezbDatenSearch" action="importEzbDatenList" method="post" validate="true">

    <s:textfield key="ezbDatenSearchTO.ezbId" cssClass="text medium"/>
    <s:textfield key="ezbDatenSearchTO.titel" cssClass="text medium"/>
    <s:textfield key="ezbDatenSearchTO.zdbNummer" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
    <br
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("ezbDatenSearch"));
</script>