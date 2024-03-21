function loadSinMsg() {
    let angleVar = document.getElementById("angle").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("sinrespmsg").innerHTML = this.responseText;
    }
    xhttp.open("GET", "/sin?angle=" + angleVar);
    xhttp.send();
}

function loadCosMsg() {
        let angleVar = document.getElementById("angle").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("cosrespmsg").innerHTML = this.responseText;
        }
        xhttp.open("GET", "/cos?angle=" + angleVar);
        xhttp.send();
}

function loadMagnitudeMsg() {
        let xVar = document.getElementById("x").value;
        let yVar = document.getElementById("y").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("magnitudemsg").innerHTML = this.responseText;
        }
        xhttp.open("GET", "/magnitude?x=" + encodeURIComponent(xVar) + "&y=" + encodeURIComponent(yVar));
        xhttp.send();
}

function loadPalindromeMsg() {
        let strVar = document.getElementById("str").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("palindromemsg").innerHTML = this.responseText;
        }
        xhttp.open("GET", "/palindrome?str=" + encodeURIComponent(strVar));
        xhttp.send();
}
