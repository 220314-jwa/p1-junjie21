let employeeTable = document.getElementById('empTable');
checkLogin().then(sendRequest);

async function sendRequest(){
    let httpResponse = await fetch ('http://localhost:6666/emp');

    if(httpResponse && httpResponse.status === 200){
        let response = await httpResponse.json();
        shwoEmployees(response);
    }
}

function shwoEmployees(){
    employeeTable.innerHTML = `<tr>
    <th>ID</th>
    <th>First name</th>
    <th>Last name</th>
    <th>department ID</th>
    <th>Manager ID</th>
    <th>Pick</th>
    </tr>`;

    for(let employee of employeeArr){
        let row = document.createElement('tr');
        row.innerHTML = `
        <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.department}</td>
        <td>${employee.manager}</td>
        <td><button type="button" id="pick${employee.id}">Pick</submit></td>
    `;

    employeeTable.appendChild(row);
    let pickBtn = document.getElementById('pick' + employee.id);
    

    }

}