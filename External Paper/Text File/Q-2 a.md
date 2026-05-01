# **Q-2 a**





## cal.html





<!DOCTYPE html>

<html lang="en">

<head>

&#x20;   <meta charset="UTF-8">

&#x20;   <title>DOM Calculator</title>

</head>

<body>

&#x20;   <input type="number" id="n1" placeholder="Number 1">

&#x20;   <input type="number" id="n2" placeholder="Number 2">



&#x20;   <div id="ops">

&#x20;       <button>+</button> <button>-</button> <button>\*</button> <button>/</button>

&#x20;   </div>



&#x20;   Result: <h1 id="result"></h1>



&#x20;   <script>

&#x20;       // 4. DOM Event Handling

&#x20;       document.getElementById('ops').addEventListener('click', function(e) {

&#x20;           // Ensure we only trigger if an actual button is clicked

&#x20;           if (e.target.tagName !== 'BUTTON') return;



&#x20;           // Fetch and convert input values to numbers

&#x20;           let a = Number(document.getElementById('n1').value);

&#x20;           let b = Number(document.getElementById('n2').value);

&#x20;           let op = e.target.innerText;



&#x20;           // Perform calculation based on the button text

&#x20;           let calc;

&#x20;           if (op === '+') {

&#x20;               calc = a + b;

&#x20;           } else if (op === '-') {

&#x20;               calc = a - b;

&#x20;           } else if (op === '\*') {

&#x20;               calc = a \* b;

&#x20;           } else if (op === '/') {

&#x20;               calc = a / b;

&#x20;           }



&#x20;           // Update the DOM with the result

&#x20;           document.getElementById('result').innerText = calc;

&#x20;       });

&#x20;   </script>

</body>

</html>













