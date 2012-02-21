<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 12:11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Liste der Bibliotheken</title>
    <meta name="heading" content="Liste der Bibliotheken"/>
    <meta name="menu" content="StammMenu"/>
</head>



<jsp:include page="/common/stammMenu.jsp"/>

<s:set name="bibliotheksmitarbeiters" value="bibliotheksmitarbeiters" scope="request"/>
<display:table name="bibliotheksmitarbeiters" class="table" requestURI="" id="bibliotheksmitarbeitersList" export="false" pagesize="25">
    <display:column property="bibId" sortable="true" href="showBibliotheksmitarbeiterDetail.html"
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

<script type="text/javascript">
    highlightTableRows("bibliotheksmitarbeitersList");
</script>