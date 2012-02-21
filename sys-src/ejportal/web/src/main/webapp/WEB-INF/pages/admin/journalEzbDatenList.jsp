<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 10.08.2010
  Time: 10:41:04
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>EZB Daten Liste</title>
    <meta name="heading" content="EZB Daten Liste"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

W&auml;hlen Sie einen neuen EZB Eintrag f&uuml;r das Journal:
<br><br>

    <s:url action="changeEzbDaten"  var="ezbDatenChange">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <s:url action="searchEzbDaten" var="ezbDatenSearch">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <div class="userActions">
        <a class="small gray awesome" onClick ="window.location.href='${ezbDatenSearch}'">Neue Suche in EZB Daten durchf&uuml;hren</a> <br /><br />
    </div>



<s:set name="ezbDaten" value="ezbDaten" scope="request"/>
<display:table name="ezbDaten" class="table" requestURI="" id="ezbDatenList" export="false" pagesize="25">
    <display:column property="ezbId" sortable="true" href="${ezbDatenChange}"
        paramId="ezbId" paramProperty="ezbId" titleKey="ezbDaten.ezbId"/>
    <display:column property="titel" sortable="true" titleKey="ezbDaten.titel"/>
    <display:column property="zdbNummer" sortable="true" titleKey="ezbDaten.zdbNummer"/>
    <display:column property="verlag" sortable="true" titleKey="ezbDaten.verlag"/>
    <display:column property="typ" sortable="true" titleKey="ezbDaten.typ"/>
    <display:column property="preistyp" sortable="true" titleKey="ezbDaten.preistyp"/>


    <display:setProperty name="paging.banner.item_name" value="EZB Eintrag"/>
    <display:setProperty name="paging.banner.items_name" value="EZB Eintr&auml;ge"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/><br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/><br/>"/>
</display:table>
<br>

<script type="text/javascript">
    highlightTableRows("ezbDatenList");
</script>