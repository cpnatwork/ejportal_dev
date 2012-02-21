@echo off

rem ***  Migration vorbereiten  ***
rem migration\input> subst_d_create.cmd


set EXECDIR=..\data_import
set EXECCMD=prod_01_create_tab.cmd
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

set EXECDIR=..\data_import
set EXECCMD=prod_02_import.cmd
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

pause
GOTO :eof
