<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %><%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 05.08.2010
  Time: 13:18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Exemplar bearbeiten</title>
    <meta name="heading" content="Exemplar bearbeiten"/>
    <meta name="menu" content="JournalMenu"/>

    <SCRIPT LANGUAGE="JavaScript" SRC="/scripts/CalendarPopup.js"></SCRIPT>
    <!-- This prints out the default stylehseets used by the DIV style calendar.
         Only needed if you are using the DIV style popup -->
    <SCRIPT LANGUAGE="JavaScript">document.write(getCalendarStyles());</SCRIPT>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>

<s:form id="exemplarForm" action="editExemplar" method="post" validate="true">
    <s:hidden name="exemplarBaseTO.exemplarId" value="%{exemplarBaseTO.exemplarId}"/>
    <s:hidden name="journalId" value="%{journalId}"/>

    <s:select label="Beteiligung" key="exemplarBaseTO.beteiligung" name="exemplarBaseTO.beteiligung" list="listBeteiligung"  headerKey="" headerValue="-- Bitte waehlen --" />
    <s:select label="Form" key="exemplarBaseTO.form" name="exemplarBaseTO.form" list="listForm"  headerKey="" headerValue="-- Bitte waehlen --" />
    <s:select label="Zugangsart" key="exemplarBaseTO.zugangsart" name="exemplarBaseTO.zugangsart" list="listZugangsart"  headerKey="" headerValue="-- Bitte waehlen --" />
    <s:select label="Status" key="exemplarBaseTO.status" name="exemplarBaseTO.status" list="listStatus"  headerKey="" headerValue="-- Bitte waehlen --" />

    <s:textfield label="Bestellnummer" key="exemplarBaseTO.bestellnummer" required="true" cssClass="text medium"/>
    <s:textfield label="Kundenummer" key="exemplarBaseTO.kundennummer"  cssClass="text medium"/>
    <s:textfield label="Abonummer" key="exemplarBaseTO.abonummer"  cssClass="text medium"/>
    
    <s:checkbox label="Privatabo" key="exemplarBaseTO.privatabo" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Ex Kommentar" key="exemplarBaseTO.exKommentar"  cssClass="text medium"/>
    <s:textfield label="Print Ex Bayern" key="exemplarBaseTO.printexBayern"  cssClass="text medium"/>

    <s:select label="Abbestellung" key="exemplarBaseTO.abbestellung" name="exemplarBaseTO.abbestellung" list="listAbbestellung"  headerKey="" headerValue="-- Bitte waehlen --" />
    <li id="wwgrp_abbestellt" class="wwgrp">    <div         id="wwlbl_abbestellt" class="wwlbl">
    <label for="abbestellt" class="desc">            Abbestellt zum
    </label>        </div>
    <div id="wwctrl_abbestellt" class="wwctrl">
    <input type="text" name="exemplarBaseTO.abbestZum" value="<s:date name="exemplarBaseTO.abbestZum" format="dd.MM.yyyy"/>" id="abbestellt" class="text medium"/></div><SCRIPT LANGUAGE="JavaScript" ID="abbestelltX">
                var abbestelltCal = new CalendarPopup("abbestelltDiv");
                abbestelltCal.setMonthNames('Januar','Februar','Maerz','April','Mai','Juni','Juli','August','September','Oktober','November','Dezember');
                abbestelltCal.setDayHeaders('S','M','D','M','D','F','S');
                abbestelltCal.setWeekStartDay(1);
                abbestelltCal.setTodayText("Heute");
                abbestelltCal.showNavigationDropdowns();
                abbestelltCal.setYearSelectStartOffset(2);
            </SCRIPT>

            <SCRIPT LANGUAGE="JavaScript">writeSource("abbestelltX");</SCRIPT>
            <A HREF="#"
               onClick="abbestelltCal.select(exemplarForm.abbestellt,'abbestelltAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="abbestelltAnchor" ID="abbestelltAnchor"> <img src="/images/iconCalendar.gif"/> </A>
        </li><div id="abbestelltDiv" STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>


    <s:select label="Umbestellung" key="exemplarBaseTO.umbestellung" name="exemplarBaseTO.umbestellung" list="listUmbestellung"  headerKey="" headerValue="-- Bitte waehlen --" />

    <li id="wwgrp_umbestellt" class="wwgrp">    <div         id="wwlbl_umbestellt" class="wwlbl">

    <label for="umbestellt" class="desc">            Umbestellt zum
    </label>        </div>
    <div id="wwctrl_umbestellt" class="wwctrl">
    <input type="text" name="exemplarBaseTO.umbestZum" value="<s:date name="exemplarBaseTO.umbestZum" format="dd.MM.yyyy"/>" id="umbestellt" class="text medium"/></div>   <A HREF="#"
               onClick="umbestelltCal.select(exemplarForm.umbestellt,'umbestelltAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="umbestelltAnchor" ID="umbestelltAnchor"> <img src="/images/iconCalendar.gif"/> </A></li>

        <SCRIPT LANGUAGE="JavaScript" ID="umbestelltX">
                var umbestelltCal = new CalendarPopup("umbestelltDiv");
                umbestelltCal.setMonthNames('Januar','Februar','Maerz','April','Mai','Juni','Juli','August','September','Oktober','November','Dezember');
                umbestelltCal.setDayHeaders('S','M','D','M','D','F','S');
                umbestelltCal.setWeekStartDay(1);
                umbestelltCal.setTodayText("Heute");
                umbestelltCal.showNavigationDropdowns();
                umbestelltCal.setYearSelectStartOffset(2);
            </SCRIPT>
            <SCRIPT LANGUAGE="JavaScript">writeSource("umbestelltX");</SCRIPT>


        <div id="umbestelltDiv" STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>


    <li class="buttonBar bottom">
       <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<s:url action="showExemplarDetail" var="back">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${back}">Abbrechen</a>

<script type="text/javascript">
    Form.focusFirstElement($("exemplarForm"));
</script>
