getEmployee();

async function getEmployee(){
    let response = await fetch(employeeUrl + 'employee');

    if(response.status === 200){
        let employees = await response.json();
        console.log(employees);
        showEmployee(employees);
    }
}

function getEmployeeAjax(){
    let jax = new XMLHttpRequest();
    jax.onreadystatechange = getData;
    jax.open('GET',employeeUrl + 'employees');
    jax.send();

    function getData(){
        if(jax.readyState === 4 ){
            if(jax.status === 200){
                let response = jax.responseText;
                let employees = JSON.parse(response);
                showEmployee(employees);
            }
        }
    }
}


function showEmployee(employees){
    let eTable = document.getElementById('availableEmployees');
    eTable.innerHTML = `<tr>
    <th>ID</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Department ID</th>
    <th>Manage ID</th>
    <th></th>
</tr>`;

    for(let employee of employees){
        let row = document.createElement('tr');

        for(let field in employee){
            let colum = document.createElement('td');
            if(field !=='status'){
                colum.innerText = employee[field];
            }else{
                colum.innerHTML =`<button id="pick${employee.id}">Pick</button>`;
            }
            row.appendChild(colum);
        }
        eTable.appendChild(row);
        document.getElementById('pick' + employee.id).onclick = employeePick;
    }
}

async function pickEmpoyee(){
    if(user){
        let empId = event.target.id;
        empId = empId.replace('pick',"");
        console.log(empId);

        let header  = {"picked" : user.id};
        console.log(header);
        let response = await fetch(employeeUrl + 'employee/pick/' + empId,{
            method:'GET',body:JSON.stringify(user),headers:tokenHeader
        
        });

        if(response === 200){
            let update = await response.json();
            logIn  =  update;
            await getEmployee();
        }else{
            let message = await response.text();
            alert(message);
        }
    }else{
        alert("you need to login first!");
    }
}