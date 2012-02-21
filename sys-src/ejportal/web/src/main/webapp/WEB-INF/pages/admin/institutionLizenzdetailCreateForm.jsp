<%--
  Created by IntelliJ IDEA.
  User: ag35ogub
  Date: 06.08.2010
  Time: 10:16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Lizenzdetail anlegen</title>
    <meta name="heading" content="Lizenzdetails"/>
    <meta name="menu" content="StammMenu"/>
</head>


<s:form id="lizenzdetailForm" action="createLizenzdetail" method="post" validate="true">
    <s:hidden name="institutionId" value="%{institutionId}" />
    <s:textfield label="Beginn" key="lizenzdetail.beginn" required="true" cssClass="text medium"/>
    <s:textfield label="Laufzeit" key="lizenzdetail.laufzeit" required="true" cssClass="text medium"/>
    <s:textfield label="Verlaengerung" key="lizenzdetail.verlaengerung"  cssClass="text medium"/>
    <s:textfield label="Kosten" key="lizenzdetail.kosten"  cssClass="text medium"/>
    <s:textfield label="Readme aktualisiert" key="lizenzdetail.readmeAktualisiert"  cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>



<s:url action="showInstitutionDetail" var="back">
    <s:param name="id" value="%{institutionId}"/>
</s:url>
<a href="${back}">zurueck zur Institution (ohne Speichern)</a>

<script type="text/javascrsipt">
    Form.focusFirstElement($("institutionForm"));
</script>
