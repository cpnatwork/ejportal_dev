<%@ include file="/common/taglibs.jsp"%>
<!--  test -->
<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<div id="tabnav">
 <ul>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="JournalMenu"/>
    <menu:displayMenu name="StammMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
</ul>
</div>
</menu:useMenuDisplayer>