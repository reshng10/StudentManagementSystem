function assign( departmentId) {
    var parsed= parseInt(departmentId)
    console.log(document.getElementById('bt'))
    let departmentName = document.getElementById("departmentName")
    let departmentId2 = document.getElementById("departmentId")
     for (let i =0; i<departments.length;i++){
         if(departments[i].id===parsed){
            departmentName.value=departments[i].name
             departmentId2.value =departments[i].id
             break
         }
     }

}