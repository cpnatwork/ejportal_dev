<%--
  Created by IntelliJ IDEA.
  User: uj32uvac
  Date: 10.08.2010
  Time: 10:22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="journalList.title"/></title>
    <meta name="heading" content="<fmt:message key='journalList.heading'/>"/>
    <meta name="menu" content="MainMenu"/>
</head>


<br><s:url action="listBearbeitungsdatum" var="bearbeitungsDatumChange14">
    <s:param name="maxDateParam" value="14"/>
</s:url>
<s:url action="listBearbeitungsdatum" var="bearbeitungsDatumChange7">
    <s:param name="maxDateParam" value="7"/>
</s:url>
<s:url action="listBearbeitungsdatumAll" var="bearbeitungsdatumAll">
</s:url>

<div><a href="${bearbeitungsDatumChange14}">Termine der n&auml;chsten 14 Tage</a> | <a href="${bearbeitungsDatumChange7}">Termine der n&auml;chsten 7 Tage</a> | <a href="${bearbeitungsdatumAll}">Alle Termine</a> </div>
<br>
<hr/>


<s:set name="journals" value="journals" scope="request"/>
<display:table name="journals" class="table" requestURI="" id="journalList" export="false" pagesize="25" defaultsort="3">
    <display:column property="id" sortable="true" href="showJournalDetail.html"
                    paramId="journalId" paramProperty="id" titleKey="journal.id"/>
    <display:column property="titel" sortable="true" titleKey="journal.titel"/>
    <display:column property="bearbeitungsdatum" sortable="true" titleKey="journal.bearbeitungsdatum" format="{0,date,dd.MM.yyyy}" maxLength="10"/>                        
    <display:column property="kommentarAdmin" sortable="true" titleKey="journal.kommentarAdmin"/>

    <display:setProperty name="paging.banner.item_name" value="Journal"/>
    <display:setProperty name="paging.banner.items_name" value="Journale"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/><br/>"/>

</display:table>

<%--<c:out value="${buttons}" escapeXml="false" /> --%>



<script type="text/javascript">
    highlightTableRows("journalList");
</script>
