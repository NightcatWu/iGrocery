NET STOP iGrocery.Api

for /f "tokens=1" %%i in ('jps -m ^| find "igrocery-api-2.0.jar"') do ( taskkill /F /PID %%i )

robocopy "D:\Jenkins\workspace\iGrocery.v2.api\api.v2\target" "D:\!websites\igrocery.v2" /MIR

robocopy "D:\Jenkins\workspace\iGrocery.v2.api\devops" "D:\!websites" "hosting.igrocery.api.bat"

NET START iGrocery.Api


NET STOP iGrocery.Web

robocopy "D:\Jenkins\workspace\iGrocery\api\target" "D:\!websites\igrocery.v1" /MIR

robocopy "D:\Jenkins\workspace\iGrocery\devops" "D:\!websites" "hosting.igrocery.web.bat"

NET START iGrocery.Web

