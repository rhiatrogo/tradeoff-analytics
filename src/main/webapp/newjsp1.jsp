<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tradeoff Analytics</title>
    </head>
    <body>
         Edited by Rhia
        <table>
            <form action="TradeOffServlet">
                <tr>
                    <td>
                        <h2> Choices: </h2>
                    </td>
                    <td>
                        <h2> Price </h2>
                    </td>
                    <td>
                        <h2> RAM </h2>
                    </td>
                    <td>
                        <h2> Screen </h2>
                    </td>
                </tr>
                <tr>
                    <td>
                        <b><u> Galaxy S4: </u></b>
                    </td>
                    <td>
                        <input type="text" name="price1" value="50">        
                    </td>
                    <td>
                        <input type="text" name="ram1" value="45">                    
                    </td>
                    <td>
                        <input type="text" name="screen1" value="5"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <b><u> iPhone 5 </u></b>
                    </td>
                    <td>
                        <input type="text" name="price2" value="99">                        
                    </td>
                    <td>
                        <input type="text" name="ram2" value="40">
                    </td>
                    <td>
                        <input type="text" name="screen2" value="4"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <b><u> MyPhone </u></b>
                    </td>
                    <td>
                        <input type="text" name="price3" value="1">                        
                    </td>
                    <td>
                        <input type="text" name="ram3" value="30000">
                    </td>
                    <td>
                        <input type="text" name="screen3" value="5000">
                    </td>
                </tr>
                <tr>
                    <td>
                        <b><u>LG Optimus G</u></b>                        
                    </td>
                    <td>
                        <input type="text" name="price4" value="10">                        
                    </td>
                    <td>
                        <input type="text" name="ram4" value="300">
                    </td>
                    <td>
                        <input type="text" name="screen4" value="5">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="submit" value="Analyze">
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
