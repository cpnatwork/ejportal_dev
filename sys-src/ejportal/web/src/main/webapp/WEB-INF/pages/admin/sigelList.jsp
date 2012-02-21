<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 04.08.2010
  Time: 15:00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Liste der Sigel</title>
    <meta name="heading" content="Sigels"/>
     <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:set name="sigels" value="sigels" scope="request"/>
<display:table name="sigels" class="table" requestURI="" id="sigelsList" export="false" pagesize="25">
    <display:column property="sigelId" sortable="true" href="showSigelDetail.html"
                    paramId="sigelId" paramProperty="sigelId" titleKey="sigel.sigelId"/>
    <display:column property="name" sortable="true" titleKey="sigel.name"/>
    <display:column property="bibliothek" sortable="true" titleKey="sigel.bibliothek"/>
    <display:column property="fakultaet" sortable="true" titleKey="sigel.fakultaet"/>


    <display:setProperty name="paging.banner.item_name" value="Sigel"/>
    <display:setProperty name="paging.banner.items_name" value="Sigel"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sigelsList");
</script>