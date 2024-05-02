document.querySelector('.menu-toggle').onclick = function() {
    var nav = document.querySelector('#nav1');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
    }
};

document.getElementById('notification-div').style.display = 'none';
document.querySelector('.notification-toggle').onclick = function() {
    var nav = document.querySelector('#notification-div');
    var tmp = document.querySelector('#account-div');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
        tmp.style.display = 'none';
    }
};
document.getElementById('account-div').style.display = 'none';
document.querySelector('.account-toggle').onclick = function() {
    var nav = document.querySelector('#account-div');
    var tmp = document.querySelector('#notification-div');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
        tmp.style.display = 'none';
    }
};
function func1(){
    document.getElementById('section').innerHTML = `
    <h1>Thông tin cá nhân</h1>     
    <form class="form-inline">
    <div id="benhnhanInfo"></div>
    <label for="id">Mã số</label>
    <div id="id" class="form-control"></div>
    <label for="name">Họ và tên:</label>
    <div id="name" class="form-control"></div>
    <label for="gender">Giới tính:</label>
    <div id="gender" class="form-control"></div>
    <label for="phone">Số điện thoại:</label>
    <div id="phone" class="form-control"></div> 
    <label for="age">Tuổi:</label>
    <div id="age" class="form-control"></div>
    <label for="address">Địa chỉ:</label>
    <div id="address" class="form-control"></div>

    <label for="address">Thời gian làm việc từ:</label>
    <div id="workFrom" class="form-control"></div>
    <label for="address">Chức năng:</label>
    <div id="part" class="form-control"></div>
    <label for="address">Chức vụ:</label>
    <div id="position" class="form-control"></div>

    <label >Bằng cấp:</label><br><br>     
    <div id="pivot" id="pivot1" style="margin-left:50px;"></div>
    </form>
    `
        var token= sessionStorage.getItem('jwt')
        var userId=sessionStorage.getItem('id')
        console.log(token)
        console.log(userId)
        try{
        fetch('http://localhost:8080/profile/employee/doctor/getprofile/'+userId,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(response=>{
            return response.json();
        })
        .then(data=>{
            document.getElementById('id').innerText=data.id;
            console.log(data.id)
            document.getElementById('name').innerText=data.name;
            document.getElementById('phone').innerText=data.phone;
            document.getElementById('gender').innerText=data.gender;
            document.getElementById( 'age').innerText=data.age;
            document.getElementById('address').innerHTML=data.address.street+"-"+
            data.address.town+"-"+data.address.province+"-"+data.address.town
            document.getElementById( 'workFrom').innerText=data.workFrom;
            document.getElementById( 'part').innerText=data.part;
            document.getElementById( 'position').innerText=data.position;
            const Certificate= data.certificateList;
    
            const tableBody = document.querySelector("#section #pivot");
            Certificate.forEach(record=>{
                const row = document.createElement("div");
                row.innerHTML = `
                <label>Cơ sở tốt nghiệp:</label>
                    <div id="sicktime" type="date" class="form-control" name="medicalrecord.time" >${record.department}</div>
                    <label>Chuyên ngành:</label>
                    <div id="disease"type="text" class="form-control" name="medicalrecord.name" >${record.major}</div>
                    <label>Thời gian tốt nghiệp</label>
                    <div id="treatmented" type="text" class="form-control" name="medicalrecord.treatment" >${record.time}</div>
                    <br><br><br>
        `;
        tableBody.appendChild(row);
            }) 
        })
    }catch(error){
        alert('Lỗi kết nối đến server: ' + error);
    }
}
function func2(){
    document.getElementById('section').innerHTML = `
    <h1>Tạo hồ sơ nhập viện</h1>
    <form class="form-inline">
        <label >Nhập mã hồ sơ khám bệnh</label>
        <input id="id" type="text" class="form-control" name="DoctorId">
        <label >Nhập mã bệnh nhân</label>
        <input id="PatientId" type="text" class="form-control" name="date">
        <label >Nhập mã bác sĩ</label>
        <input id="doctorId" type="text" class="form-control" name="datem">
        <label >Nhập tình trạng</label>
        <input id="detail" type="text" class="form-control" name="date1">
        <label >Nhập trạng thái kết thúc</label>
        <input id="done" type="text" class="form-control" name="date2">
        <label >Nhập số phòng cấp cứu</label>
        <input id="room" type="text" class="form-control" name="date3">
        <label for="certificate.department">Nhập thời gian nhập viện</label>
        <input id="startDate" type="date" class="form-control" name="certificate.department" >
        <label id="patientStates">Nhập tình trạng cấp cứu</label>
        <br>
        <button id="add" class="button" type="submit">+</button>
        <button id="submit" class="button" type="submit">Submit</button>
        <div id="parent"></div>
        </div>
    </form>      
        `
        const addButton = document.getElementById("add");
        const patientStates = document.getElementById("patientStates");
        addButton.addEventListener("click", (event) => {
            event.preventDefault()
            const newC = document.createElement("div");
            newC.classList.add("state");
            newC.innerHTML = `
                <label for="time">Nhập thời gian bệnh</label>
                <input type="date" class="form-control" name="time" >
                <label for="disease">Nhập triệu chứng bệnh</label>
                <input type="text" class="form-control" name="disease">
                <br><br>
            `;
            patientStates.appendChild(newC);
            
        });   
    const submit = document.getElementById("submit");
        submit.addEventListener("click", (event) => {
            event.preventDefault()
            const id= document.getElementById("id").value
        const patientId= document.getElementById("PatientId").value
        var detail = document.getElementById("detail").value
        const done = document.getElementById("done").value
        const room = document.getElementById("room").value
        const startDate= document.getElementById("startDate").value
        const doctorId=document.getElementById("doctorId").value
        const data={
            medicalDetail:{
                id
    },
    patientId,
    doctorId,
    patientStates:[],
    detail,
    startDate,
    done,
    room
    }
        const C= document.querySelectorAll(".state")
    C.forEach(element=>{
        const date = element.querySelector("[name='time']").value;
        detail = element.querySelector("[name='disease']").value;
        data.patientStates.push({
            date, detail
        })
    })
            
            var data2= JSON.stringify(data)
            console.log(data)
            console.log(data2)
            const token=sessionStorage.getItem("jwt")
            console.log(token)
            try{
                fetch('http://localhost:8080/hospitaladmission/createdetail/',{
                    method:"POST",
                    headers:{
                        "Content-Type":"application/json",
                        "Authorization":"Bearer "+token
                    },
                    body: JSON.stringify(data)
                })
                .then(response=>{
                    if(response.ok){
                        alert("Đăng kí nhập viện thành công")
                        return response.json()
                    }
                    else {
                        alert("Đăng kí nhập viện thất bại")
                    }
                })
                .then(data=>{
                    const parent=document.getElementById("parent")
                    if (parent) {
                        let nurse = document.createElement("div");
                        nurse.innerHTML = `
                            <label>Thông tin y tá quản lí</label>
                            <label>Mã y tá</label>
                            <div class="form-control">${data.id}</div>
                            <label>Họ và tên</label>
                            <div class="form-control">${data.name}</div>
                            <label>Số điện thoại</label>
                            <div class="form-control">${data.phone}</div>
                            <label>Tuổi</label>
                            <div class="form-control">${data.age}</div>
                            <label>Giới tính</label>
                            <div class="form-control">${data.gender}</div>
                        `;
                        parent.appendChild(nurse);
                    }  
                    else{
                        console.log("không tìm thấy parent")
                    }
                })   
            }
            catch(error){
                alert("Lỗi: "+error)
            }
        }); 
}
function func3(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1>Hồ sơ khám chữa bệnh</h1>
    <div id="medicalRecords"></div>
    `
    var userId= sessionStorage.getItem("id")
    var token= sessionStorage.getItem("jwt")
    try{
        fetch('http://localhost:8080/medicaldetail/getmedicaldetail/doctor/'+userId,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(function(response){
            return response.json()
        })
        .then(function(data){
            const pivot= document.getElementById('medicalRecords');
            data.forEach(element => {
                var newMedicalRecord=document.createElement("form")
                newMedicalRecord.classList.add("form-inline")
                newMedicalRecord.innerHTML=`
                    <label>Mã hồ sơ</label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.id}</div>
                    <label>Chuyên khoa</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.major}</div>
                    <label>Tên bệnh</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.nameofDisease}</div>
                    <label>Hiện đang khám chữa bênh?</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.inProgress}</div>
                    <label>Toa thuốc</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.prescription}</div>
                    <label>Ngày khám</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.date}</div>
                    <label>Trạng thái bệnh nhân</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.patientState}</div>
                    <label>Lịch đăng kí</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.date}</div>
                `
                element.medicalSchedules.forEach(e=>{
                    var scheduleDiv = document.createElement("div");
                    scheduleDiv.innerHTML=`
                    <br>
                    <label>Thời gian</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.time}</div>
                    <label>Nội dung khám</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.detail}</div>
                    <label>Trạng thái khám</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.done}</div>
                    <br>
                    `
                    newMedicalRecord.appendChild(scheduleDiv);
                })
                var patient=document.createElement("div")
                patient.innerHTML=`
                <label>Thông tin bệnh nhân:</label>
                <label>Mã số bệnh nhân</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.patientInfo.id}</div>
                <label>Số điện thoại</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.patientInfo.phone}</div>
                    <label>Họ và tên bệnh nhân</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.patientInfo.name}</div>
                    <label>Tuổi</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.patientInfo.age}</div>
                    <label>Giới tính</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.patientInfo.gender}</div>
                    <label>Lịch sử bệnh</label>   
                    <br>
                `
                element.patientInfo.medicalRecords.forEach(e=>{
                    var m=document.createElement("div")
                    m.innerHTML=`
                    <label>Tên bệnh</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.name}</div>
                    <label>Thời gian bệnh</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.time}</div>
                    <label>Đã đươc chữa trị?</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.treatment}</div>
                    <br>
                    `
                    patient.appendChild(m)
                })
                newMedicalRecord.appendChild(patient)
                pivot.appendChild(newMedicalRecord)
                var newline= document.createElement("br")
                pivot.appendChild(newline)
            });
            
        })
    }
    catch(error){
        alert("Lỗi"+error)
    }
}
function func4(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML=`
    <h1>Lịch khám bệnh</h1>       
    <form class="form-inline">
    </form>
    `;   
}
function func5()
{
    document.getElementById('section').innerHTML=`
    <h1>Tạo hồ sơ bệnh án</h1>
    <form class="form-inline">
        <label >Nhập mã bệnh nhân</label>
        <input id="patientId" type="text" class="form-control" name="date">
        <label >Nhập mã bác sĩ</label>
        <input id="doctorId" type="text" class="form-control" name="datem">
        <label >Nhập khoa</label>
        <input id="major" type="text" class="form-control" name="date1">
        <label >Nhập tên bệnh</label>
        <input id="nameofDisease" type="text" class="form-control" name="date2">   
        <label >Nhập tình trạng bệnh nhân</label>
        <input id="patientState" type="text" class="form-control" name="date2">  
        <label >Nhập trạng thái chữa trị</label>
        <input id="inProgress" type="text" class="form-control" name="date2">  
        <label for="certificate.department">Nhập thời gian nhập viện</label>
        <input id="date" type="date" class="form-control" name="certificate.department" >
        <label id="medicalSchedules">Nhập lịch trình bệnh án</label>
        <br>
        <button id="add" class="button" type="submit">+</button>
        <button id="submit" class="button" type="submit">Submit</button>
        <div id="parent"></div>
        </div>`
        const addButton = document.getElementById("add");
        const medicalSchedules = document.getElementById("medicalSchedules");
        addButton.addEventListener("click", (event) => {
            event.preventDefault()
            const newC = document.createElement("div");
            newC.classList.add("schedule");
            newC.innerHTML = `
                <label for="time">Nhập thời gian bệnh</label>
                <input type="datetime-local" class="form-control" name="time">
                <label for="disease">Nhập nôi dung khám</label>
                <input type="text" class="form-control" name="detail">
                <label for="disease">Nhập trạng thái hoàn thành</label>
                <input type="text" class="form-control" name="done">
                <br><br>
            `;
            medicalSchedules.appendChild(newC);
            
        });   
    const submit = document.getElementById("submit");
        submit.addEventListener("click", (event) => {
            event.preventDefault()
        const patientId= document.getElementById("patientId").value
        const doctorId=document.getElementById("doctorId").value
        const major=document.getElementById("major").value
        const nameofDisease=document.getElementById("nameofDisease").value
        const PatientState=document.getElementById("patientState").value
        const inProgress=document.getElementById("inProgress").value
        const date=document.getElementById("date").value
        const data={
            detail:{
                doctorId,patientId,major,nameofDisease,PatientState,inProgress,date,
                medicalSchedules:[]
    },
    info:{
        doctorId,patientId
    }
    }
        const C= document.querySelectorAll(".schedule")
        C.forEach(element=>{
        const time = element.querySelector("[name='time']").value+":00";
        const detail = element.querySelector("[name='detail']").value;
        const done = element.querySelector("[name='done']").value;
        data.detail.medicalSchedules.push({
            time, detail,done
        })
    })
            
            var data2= JSON.stringify(data)
            console.log(data)
            console.log(data2)
            const token=sessionStorage.getItem("jwt")
            console.log(token)
            try{
                fetch('http://localhost:8080/medicaldetail/createmedicaldetail',{
                    method:"POST",
                    headers:{
                        "Content-Type":"application/json",
                        "Authorization":"Bearer "+token
                    },
                    body: JSON.stringify(data)
                })
                .then(response=>{
                    if(response.ok){
                        alert("Đăng kí hồ sơ thành công")
                        return response.json()
                    }
                    else {
                        alert("Đăng kí nhập viện thất bại")
                    }
                })   
            }
            catch(error){
                alert("Lỗi: "+error)
            }
        }); 
}

