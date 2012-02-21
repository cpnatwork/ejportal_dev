<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 02.08.2010
  Time: 17:17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Fach Liste</title>
    <meta name="heading" content="Fach Liste"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

W&auml;hlen Sie ein neues Fach f&uuml;r das Journal :
<br><br>

<s:url action="changeFach"  var="fachChange">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>


<s:set name="faecher" value="faecher" scope="request"/>
<display:table name="faecher" class="table" requestURI="" id="fachList" export="false" pagesize="25">
    <display:column property="fachId" sortable="true" href="${fachChange}"
        paramId="fachId" paramProperty="fachId" titleKey="fach.fachId"/>
    <display:column property="fachName" sortable="true" titleKey="fach.fachName"/>

    <display:setProperty name="paging.banner.item_name" value="Fach"/>
    <display:setProperty name="paging.banner.items_name" value="F&auml;cher"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>



<script type="text/javascript">
    highlightTableRows("fachList");
</script>