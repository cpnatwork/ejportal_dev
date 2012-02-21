<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 03.08.2010
  Time: 10:02:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Stammdatenverwaltung</title>
    <meta name="heading" content="heading"/>
    <meta name="menu" content="StammMenu"/>
</head>

<div class="separator"></div>

<ul class="glassList">
    <!--
    <li>
        <a href="<c:url value='/editProfile.html'/>"><fmt:message key="menu.user"/></a>
    </li>
     -->


    <li>
        <a href="<c:url value="showJournalCreateForm.html"/>">Neues Journal anlegen</a>
    </li>
    <li>
        <a href="<c:url value="importEzbDatenSearch.html"/>">Journal aus EZB importieren</a>
    </li>

    <br>

    <li>
        <a href="<c:url value="searchInstitutions.html"/>">Institution und Lizenzdetails &auml;ndern</a>
    </li>
    <!--
    <li>
        <a href="<c:url value="/listInstitutions.html"/>">Institutionen anzeigen</a>
    </li>
    -->
     <li>
        <a href="<c:url value="showInstitutionCreateForm.html"/>">Neue Institution anlegen</a>
    </li>

    <br>
    
    <li>
        <a href="<c:url value="searchKonsortien.html"/>">Konsortium &auml;ndern</a>
    </li>
    <!--
    <li>
        <a href="<c:url value="/listKonsortien.html"/>">Konsortien anzeigen</a>
    </li>
    -->
     <li>
        <a href="<c:url value="showKonsortiumCreateForm.html"/>">Neues Konsortium anlegen</a>
    </li>

    <br>
    
    <li>
        <a href="<c:url value="searchPakete.html"/>">Paket &auml;ndern</a>
    </li>
    <!--
    <li>
        <a href="<c:url value="/listPakete.html"/>">Pakete anzeigen</a>
    </li>
    -->
     <li>
        <a href="<c:url value="showPaketCreateForm.html"/>">Neues Paket anlegen</a>
    </li>

    <br>

    <li>
        <a href="<c:url value="searchSigels.html"/>">Sigel &auml;ndern</a>
    </li>
    <%--
    <li>
        <a href="<c:url value="/listSigels.html"/>">Sigel anzeigen</a>
    </li>
    --%>
     <li>
        <a href="<c:url value="showSigelCreateForm.html"/>">Neues Sigel anlegen</a>
    </li>

    <br>

    <li>
        <a href="<c:url value="searchBibliotheksmitarbeiterForEdit.html"/>">Bibliothek &auml;ndern</a>
    </li>
    <%--
    <li>
        <a href="<c:url value="/listBibliotheksmitarbeiterForEdit.html"/>">Bibliotheksmitarbeiter anzeigen</a>
    </li>
    --%>
     <li>
        <a href="<c:url value="showBibliotheksmitarbeiterCreateForm.html"/>">Neue Bibliothek anlegen</a>
    </li>
    <br>
    <li>
        <a href="<c:url value="searchFaecher.html"/>">F&auml;cher &auml;ndern</a>
    </li>
    <li>
       <a href="<c:url value="showFachCreateForm.html"/>">Neues Fach anlegen</a>
    </li>
    <%--
    <li>
        <a href="<c:url value='/uploadFile.html'/>"><fmt:message key="menu.selectFile"/></a>
    </li>
    --%>

</ul>
