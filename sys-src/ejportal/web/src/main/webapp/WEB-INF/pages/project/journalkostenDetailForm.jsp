


<%--
  Created by IntelliJ IDEA.
  User: ag35ogub
  Date: 10.08.2010
  Time: 10:06:09
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Journalkosten editieren</title>
    <meta name="heading" content="Journalkosten"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<s:form id="journalkostenForm" action="editJournalkosten" method="post" validate="true">
    <s:hidden name="journalkosten.journalkostenId" value="%{journalkosten.journalkostenId}" />
    <s:hidden name="journalId" value="%{journalId}"/>

    <p><h1>Abonnement-Preis für Institution</h1></p>

    <p><b>Print + Online</b><br />
    <s:textfield label="Originalpreis" key="journalkosten.oPreisPO" required="true" cssClass="text medium"/>
    <s:select label="Waehrung" key="journalkosten.waehrungPO" name="journalkosten.waehrungPO" value="%{journalkosten.waehrungPO}" list="listWaehrung" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:select label="MwSt" key="journalkosten.mwStPO" name="journalkosten.mwStPO" value="%{journalkosten.mwStPO}" list="listMwSt" required="true" headerKey="" headerValue="-- Bitte waehlen --" />
    </p>

    <p><b>Online</b><br />
    <s:textfield label="Originalpreis" key="journalkosten.oPreisO" required="true" cssClass="text medium"/>
    <s:select label="Waehrung" key="journalkosten.waehrungO" name="journalkosten.waehrungO" value="%{journalkosten.waehrungO}" list="listWaehrung" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:select label="MwSt" key="journalkosten.mwStO" name="journalkosten.mwStO" value="%{journalkosten.mwStO}" list="listMwSt" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    </p>

    <p><b>Print</b><br />
    <s:textfield label="Originalpreis" key="journalkosten.oPreisP" required="true" cssClass="text medium"/>
    <s:select label="Waehrung" key="journalkosten.waehrungP" name="journalkosten.waehrungP" value="%{journalkosten.waehrungP}" list="listWaehrung" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:select label="MwSt" key="journalkosten.mwStP" name="journalkosten.mwStP" value="%{journalkosten.mwStP}" list="listMwSt" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    </p>

    <p><h1>Abonnement-Preis für Personen</h1></p>

    <p><b>Print + Online</b><br />
    <s:textfield label="Originalpreis" key="journalkosten.iPreisPO" required="true" cssClass="text medium"/>
    <s:select label="Waehrung" key="journalkosten.iWaehrungPO" name="journalkosten.iWaehrungPO" value="%{journalkosten.iWaehrungPO}" list="listWaehrung" required="true" />
    <s:select label="MwSt" key="journalkosten.iMwStPO" name="journalkosten.iMwStPO" value="%{journalkosten.iMwStPO}" list="listMwSt" required="true" />
    </p>

    <p><b>Online</b><br />
    <s:textfield label="Originalpreis" key="journalkosten.iPreisO" required="true" cssClass="text medium"/>
    <s:select label="Waehrung" key="journalkosten.iWaehrungO" name="journalkosten.iWaehrungO" value="%{journalkosten.iWaehrungO}" list="listWaehrung" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:select label="MwSt" key="journalkosten.iMwStO" name="journalkosten.iMwStO" value="%{journalkosten.iMwStO}" list="listMwSt" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    </p>

    <p><b>Print</b><br />
    <s:textfield label="Originalpreis" key="journalkosten.iPreisP" required="true" cssClass="text medium"/>
    <s:select label="Waehrung" key="journalkosten.iWaehrungP" name="journalkosten.iWaehrungP" value="%{journalkosten.iWaehrungP}" list="listWaehrung" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:select label="MwSt" key="journalkosten.iMwStP" name="journalkosten.iMwStP" value="%{journalkosten.iMwStP}" list="listMwSt" required="true" headerKey="" headerValue="-- Bitte waehlen --"/>
    </p>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>


<s:url value="/project/showProjectCockpit.html" var="projectSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${projectSelect}">zur&uuml;ck zur Projekt&uuml;bersicht</a>


<script type="text/javascrsipt">
    Form.focusFirstElement($("journalkostenForm"));
</script>
