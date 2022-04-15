function loadJSON(){
    const dataUrl = "http://localhost:6666/emp";
    let httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", dataUrl);
    httpRequest.send();




    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState == 4){
            let dataObj = JSON.parse(httpRequest.responseText);
            // add the action link to new page
            
        }

    }

}

let button = document.createElement('button');
button.addEventListener('click',loadJSON);
button.innerText = "LogIn";
let body = document.getElementsByTagName("body")[0];
body.appendChild(button)

