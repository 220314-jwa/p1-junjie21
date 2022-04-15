let loggedInUser;
let employeeUrl = 'http://localhost:6666';
let nav = document.getElementsByTagName('nav')[0];
let logInBtn;
// call checklogin on the other JS files so that we can make sure other things happen first

checkLogin().then(setupNav);
async function checkLogin(){
    let userId = localStorage.getItem("TOKEN");
    if(userId){
    let userId = await fetch(employeeUrl + 'emp/');
    if(response.status === 200){
        loggedInPerson = await response.json();
    }
    }
}

async function checkLogin() {
    let userId = sessionStorage.getItem('Auth-Token');
    loggedOutNavBar();
    let httpResp = await fetch('http://localhost:6666');
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        loggedInNavBar();
    } else {
        loggedOutNavBar();
    }
}

function loggedInNavBar() {
    nav.innerHTML = `<ul id="navList">
        <li><a href="index.html">Lexus</a></li>
        <li><a href="employee.html">Available Employees</a></li>
        <li><a href="myEmployee.html">My Employee</a></li>
    </ul>
    <form id="loginWindow">
        <span id="nameDisplay" style="padding-right:16px"></span>
        <button type="button" id="logInBtn">Log Out</button>
    </form>
    <label>
    <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
    `;
    logInBtn = document.getElementById('logInBtn');
    logInBtn.addEventListener('click', logOut);
    document.getElementById('nameDisplay').innerText = loggedInUser.firstName;
}

function loggedOutNavBar() {
    nav.innerHTML = `<ul id="navList">
        <li><a href="index.html">Lexus</a></li>
        <li><a href="employee.html">Available Employees</a></li>
        <li><a href="myEmployee.html">My Employee</a></li>
    </ul>
    <form id="loginWindow">
        <label for="usernameLogin">Username: </label><input type="text" id="usernameLogin">&nbsp;
        <label for="passwordLogin">Password: </label><input type="password" id="passwordLogin">
        <button type="button" id="logInBtn">Log In</button>
    </form>`;
    logInBtn = document.getElementById('logInBtn');
    logInBtn.addEventListener('click', logIn);
}

async function logIn() {
    let credentials = {
        username: document.getElementById('usernameLogin').value,
        password: document.getElementById('passwordLogin').value
    };
    let credentialJSON = JSON.stringify(credentials);

    let httpResp = await fetch('http://localhost:6666/emp/create',
        { method: 'POST', body: credentialJSON,
        mode: 'no-cors'});
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        sessionStorage.setItem('Auth-Token', loggedInUser.id);
        await checkLogin();
        loggedInNavBar();
    }
}

function logOut() {
    sessionStorage.removeItem('Auth-Token');
    loggedInUser = null;
    loggedOutNavBar();
}

