NET STOP iGrocery

for /f "tokens=1" %%i in ('jps -m ^| find "igrocery-1.0.jar"') do ( taskkill /F /PID %%i )

robocopy "D:\Jenkins\workspace\iGrocery\api\target" "D:\!websites\igrocery.web" /MIR

NET START iGrocery
