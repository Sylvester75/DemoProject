<div style="padding: 20px;">
    <style>

        #t2 {
            width: 100%;
            border: 1px solid black;
            border-collapse: collapse;
        }

        #t2 td, th {
            text-align: center;
            padding: 15px;
            border: 1px solid black;
        }

        #t2 tr:nth-child(odd) {
            background-color: #eee;
        }

        #logo {
            text-align: center;
        }
    </style>
    <p id="logo">
        <img src="https:${icon}"
             alt="Weather Icon">
    </p>

    <h2 style="color: black;text-align: center;margin-top: 40px;">Weather Info</h2>


    <table id="t2">
        <tr>
            <th>City</th>
            <th>${city}</th>
        </tr>
        <tr>
            <td>Country</td>
            <td>${country}</td>
        </tr>
        <tr>
            <td>Location Cordinate</td>
            <td>${lat},${aLong}</td>
        </tr>
        <tr>
            <td>Local Time</td>
            <td>${localTime}</td>
        </tr>
        <tr>
            <td>Last Updated</td>
            <td>${lastUpdated}</td>
        </tr>
        <tr>
            <td>Temperature(in C)</td>
            <td>${temp}</td>
        </tr>
        <tr>
            <td>Weather Condition</td>
            <td>${text}</td>
        </tr>
    </table>
</div>