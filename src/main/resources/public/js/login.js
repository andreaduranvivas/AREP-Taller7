document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/login', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = function() {
        if (xhr.status === 200) {
            document.getElementById('response').innerHTML = 'Login successful';
            window.location.href = "https://localhost:4567/calculadora.html";
        } else {
            document.getElementById('response').innerHTML = 'Login failed';
        }
    };
    xhr.send(`username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`);
});
