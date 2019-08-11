NET STOP iGrocery.Web

robocopy "D:\Jenkins\workspace\iGrocery.v2.web\web.v2\build" "D:\!websites\igrocery.v2.web" /MIR

robocopy "D:\Jenkins\workspace\iGrocery.v2.web\devops" "D:\!websites" "hosting.igrocery.web.bat"

NET START iGrocery.Web

