let empTable = document.getElementById('empTable');
let messageBox = document.getElementById('messageBox');

checkLogin().then(setMessageBox);

function setMessageBox() {
    if (loggedInUser) {
        if (loggedInUser.emp && loggedInUser.emp.length > 0) {
            showEmployee(loggedInUser.emp);
        } else {
            messageBox.innerText = 'You have not pick any employee yet, please pick one for your team.';
        }
    } else {
        messageBox.innerText = 'You need to login your account to pick employee.';
    }
}

function showEmployee(empArr) {
    empTable.innerHTML = `<tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    </tr>`;

    for (let employee of empArr) {
        // Collect all the data from the database fields
        let row = document.createElement('tr');
        row.innerText = `
        <td>${pemployeeet.id}</td>
        <td>${employee.firstname}</td>
        <td>${employee.lastname}</td>
    `;
        empTable.appendChild(row);
    }
}