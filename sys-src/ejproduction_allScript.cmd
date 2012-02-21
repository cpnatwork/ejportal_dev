@echo off

rem ***  Migration vorbereiten  ***
rem migration\input> subst_d_create.cmd


set EXECDIR=ejportal\core
set EXECCMD=mvn -P prodcreate,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

set EXECDIR=ejportal\core
set EXECCMD=mvn -P prodcreate,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%


set EXECDIR=ejportal
set EXECCMD=mvn -P prod,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

set EXECDIR=migration
set EXECCMD=mvn -P prod,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%


set EXECDIR=migration
set EXECCMD=mvn -P prod,mysql compile exec:java -Dexec.mainClass=migration.App
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

set EXECDIR=import
set EXECCMD=prod_01_create_tab.cmd
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

set EXECDIR=import
set EXECCMD=prod_02_import.cmd
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%


set EXECDIR=ejportal\web
set EXECCMD=mvn -P prod,mysql tomcat:run
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

pause
GOTO :eof
