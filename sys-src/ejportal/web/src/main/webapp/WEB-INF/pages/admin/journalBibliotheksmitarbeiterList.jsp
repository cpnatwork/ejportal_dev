<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 16:23:18
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="bibliotheksmitarbeiterList.title"/></title>
    <title>Bibliothek Liste</title>
    <meta name="heading" content="<fmt:message key='bibliotheksmitarbeiterList.heading'/>"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

W&auml;hlen Sie eine neue Bibliothek f&uuml;r das Journal:
<br><br>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE,ROLE_LESEN,ROLE_PROJECT">
    <s:url action="changeBibliotheksmitarbeiter"  var="bibliotheksmitarbeiterChange">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <s:url action="searchBibliotheksmitarbeiter" var="bibMaSearch">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <div class="userActions">
        <a class="small gray awesome" onClick ="window.location.href='${bibMaSearch}'">Neue Bibliothekssuche durchf&uuml;hren</a> <br /><br />
    </div>

</authz:authorize>


<s:set name="bibliotheksmitarbeiters" value="bibliotheksmitarbeiters" scope="request"/>
<display:table name="bibliotheksmitarbeiters" class="table" requestURI="" id="bibliotheksmitarbeiterList" export="false" pagesize="25">
    <display:column property="bibId" sortable="true" href="${bibliotheksmitarbeiterChange}"
        paramId="bibId" paramProperty="bibId" titleKey="bibliotheksmitarbeiter.bibId"/>
    <display:column property="name" sortable="true" titleKey="bibliotheksmitarbeiter.name"/>
    <display:column property="abteilungsHauptstelle" sortable="true" titleKey="bibliotheksmitarbeiter.abteilungsHauptstelle"/>
    <display:column property="emailanschrift" sortable="true" titleKey="bibliotheksmitarbeiter.emailanschrift"/>


    <display:setProperty name="paging.banner.item_name" value="Bibliothek"/>
    <display:setProperty name="paging.banner.items_name" value="Bibliotheken"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>
<br>
<%--<s:url action="changeBibliotheksmitarbeiter" var="bibliotheksmitarbeiterChange">
    <s:param name="id" value="%{JournalId}"/>
</s:url>--%>
<script type="text/javascript">
    highlightTableRows("bibliotheksmitarbeiterList");
</script>