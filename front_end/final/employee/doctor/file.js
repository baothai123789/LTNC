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
    <input id="name" class="form-control">
    <label for="gender">Giới tính:</label>
    <input id="gender" class="form-control">
    <label for="phone">Số điện thoại:</label>
    <input id="phone" class="form-control">
    <label for="age">Tuổi:</label>
    <input id="age" class="form-control">
    <label>Địa chỉ:</label>
    <div class="form-control">
    <p>Đường/Ấp/Khu phố</p>
    <input id="street" class="form-control" >
    <p>Huyện/Thị xã/Thành Phố</p>
    <input id="town" class="form-control">
    <p>Tỉnh/Thành phố</p>
    <input id="province" class="form-control">
    <p>Quốc gia</p>
    <input id="nation" class="form-control">
    </div>   

    <label for="address">Thời gian làm việc từ:</label>
    <input id="workFrom" class="form-control" type="date">
    <label for="address">Bộ phận</label>
    <input id="part" class="form-control">
    <label for="address">Chức vụ:</label>
    <input id="position" class="form-control">

    <label >Bằng cấp:</label><br><br>     
    <div id="pivot" id="pivot1" style="margin-left:50px;"></div>
    <button id="submit" class="button" type="">Chỉnh sửa</button>
    </form>
    `
        var token= sessionStorage.getItem('jwt')
        var userId=sessionStorage.getItem('id')
        var PutData
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
            document.getElementById('id').innerHTML=data.id;
            document.getElementById('name').value=data.name;
            document.getElementById('phone').value=data.phone;
            document.getElementById('gender').value=data.gender;
            document.getElementById( 'age').value=data.age;
            document.getElementById('street').value=data.address.street
            document.getElementById('town').value=data.address.town
            document.getElementById('province').value=data.address.province
            document.getElementById('nation').value=data.address.nation
            document.getElementById( 'workFrom').value=data.workFrom;
            document.getElementById( 'part').value=data.part;
            document.getElementById( 'position').value=data.position;
            const Certificate= data.certificateList;
            PutData=data
            delete(PutData.id)
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
    // ....................................................
    document.getElementById("submit").addEventListener("click", event => {
        event.preventDefault(); // Prevent the default form submission behavior
        // Gather the form data
        PutData.name=document.getElementById('name').value
        PutData.phone=document.getElementById('phone').value
        PutData.gender=document.getElementById('gender').value
        PutData.age=document.getElementById( 'age').value
        PutData.address.street=document.getElementById('street').value
        PutData.address.town=document.getElementById('town').value
        PutData.address.province=document.getElementById('province').value
        PutData.address.nation=document.getElementById('nation').value
        PutData.workFrom=document.getElementById('workFrom').value
        PutData.part=document.getElementById('part').value
        PutData.position=document.getElementById('position').value
        console.log(PutData)
    // .....................................................................
        // Define the PUT request
        fetch('http://localhost:8080/profile/employee/editprofile/' + userId, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + token
            },
            body: JSON.stringify(PutData) // Convert the JavaScript object to a JSON string
        })
        .then(function(response) {
            if(response.ok) {
                console.log(response)
                return response.json();
            } else {
                alert('Cập nhật thất bại');
            }
        })
        .then(function(data) {
            alert('Cập nhật thành công');
            // Handle success - maybe update the UI to show the changes
        })
        .catch(function(error) {
            console.error('Lỗi cập nhật', error);
            // Handle errors here, such as displaying a message to the user
        });
    });
}

function func2(){
    document.getElementById('section').innerHTML = `
    <h1>Tạo hồ sơ nhập viện</h1>
    <form class="form-inline">
        <label >Nhập mã hồ sơ khám bệnh</label>
        <input id="id" type="text" class="form-control" name="DoctorId">
        <label >Nhập mã bệnh nhân</label>
        <input id="PatientId" type="text" class="form-control" name="date">
        <label >Nhập tình trạng</label>
        <input id="detail" type="text" class="form-control" name="date1">
        <label for="done">Đã khỏi</label><br>
        <input type="radio" name="done" class="form-check-input mt-0" value="true" />Có 
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <input type="radio" name="done" class="form-check-input mt-0" value="false" />Không
        <br>
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
            const medicalDetailId= document.getElementById("id").value
        const patientId= document.getElementById("PatientId").value
        var detail = document.getElementById("detail").value
        const room = document.getElementById("room").value
        const startDate= document.getElementById("startDate").value
        const doctorId=sessionStorage.getItem('id')
        var radios = document.getElementsByName('done');
let done;
for (const radio of radios) {
    if (radio.checked) {
        done = radio.value;
        break;
    }
}
        const data={
            medicalDetailId,
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
                            <label>Thông tin y tá quản lí</label><br>
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
                            <br><br>
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
    document.getElementById('section').innerHTML = `
    <h1>Hồ sơ khám chữa bệnh</h1>
    <div id="medicalRecords"> Đang tải vui lòng đợi trong giây lát</div>
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
            if(response.ok)
            return response.json()
            else{
                document.getElementById("medicalRecords").innerHTML=`
                Không có hồ sơ khám bệnh trong dữ liệu`
            }
        })
        .then(function(data){
            const pivot= document.getElementById('medicalRecords');
            if(data.length===0){
                document.getElementById("medicalRecords").innerHTML=`
                Không có hồ sơ khám bệnh trong dữ liệu`
            }
            else{
                document.getElementById("medicalRecords").innerHTML=``       
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
                <label>Thông tin bệnh nhân:</label><br>
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
        }
        })
    }
    catch(error){
        alert("Lỗi"+error)
    }
}
function func4(){
    document.getElementById('section').innerHTML=`
    <h1>Lịch khám bệnh</h1>
    <div id="schedule"></div>       
    `;  
    var userId= sessionStorage.getItem("id")
    var token= sessionStorage.getItem("jwt")
    try{
        fetch('http://localhost:8080/schedule/doctor/getschedule/'+userId,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(function(response){
            console.log(response)
            return response.json()
        })
        .then(function(data){
            console.log(data)
            const pivot= document.getElementById('schedule');
            pivot.innerHTML=`Không có lịch ở thời điểm hiện tại`
            data.forEach(element => {
                pivot.innerHTML=``
                var newMedicalRecord=document.createElement("form")
                newMedicalRecord.classList.add("form-inline")
                newMedicalRecord.innerHTML=`    
                    <label>Mã hồ sơ</label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.id}</div>
                    <label>Thời gian</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.time} giờ, ${element.date}</div>
                    <label>Thông tin bệnh nhân</label><br>
                    <label> Mã bệnh nhân </label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.patientInfo.id}</div>
                    <label>Họ và tên </label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.patientInfo.name}</div>
                    <label> Số điện thoại </label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.patientInfo.phone}</div>
                    <label> Giới tính </label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.patientInfo.gender}</div>
                    <label> Tuổi </label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.patientInfo.age}</div>
                    <label>Lịch sử bệnh</label>
                    `
                element.patientInfo.medicalRecords.forEach(e=>{
                    var scheduleDiv = document.createElement("div");
                    scheduleDiv.innerHTML=`
                    <label>Thời gian</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.time}</div>
                    <label>Tên bệnh</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.name}</div>
                    <label>Đã chữa trị?</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${e.done?"Có" : "Không"}</div>
                    <br>
                    `
                    newMedicalRecord.appendChild(scheduleDiv);
                })
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
function func5()
{
    document.getElementById('section').innerHTML=`
    <h1>Tạo hồ sơ bệnh án</h1>
    <form class="form-inline">
        <label >Nhập mã bệnh nhân</label>
        <input id="patientId" type="text" class="form-control" name="date">
        <label >Nhập khoa</label>
        <select id="major" class="form-select" name="position">
                <option  selected>....</option>
                <option value="ngoai tong hop">Ngoại tổng hợp</option>
                <option value="da khoa">Đa khoa</option>
                <option value="khoa noi">Khoa nội</option>
                <option value="khoa phu san">Khoa phụ sản</option>
                <option value="khoa nhi">Khoa nhi</option>
                <option value="khoa truyen nhiem">Khoa truyền nhiễm</option>
            </select> 
        <label >Nhập tên bệnh</label>
        <input id="nameofDisease" type="text" class="form-control" name="date2">   
        <label >Nhập tình trạng bệnh nhân</label>
        <input id="patientState" type="text" class="form-control" name="date2">  
        <label for="inProgress">Đang chữa trị?</label> <br>
            <input type="radio" class="form-check-input mt-0" name="inProgress" value=true style="margin-left: 50px;">Có       
            <input type="radio" class="form-check-input mt-0" name="inProgress" value=false style="margin-left: 50px;">Không   
            <br>
        <label for="certificate.department">Nhập thời gian nhập viện</label>
        <input id="date" type="date" class="form-control" name="certificate.department" >
        <label id="medicalSchedules">Nhập lịch trình bệnh án</label>
        <br>
        <button id="add" class="button" type="submit">+</button>
        <button id="submit" class="button" type="submit">Submit</button>
        <div id="parent"></div>
        </div>`
        const addButton = document.getElementById("add");
        var j=0;
        const medicalSchedules = document.getElementById("medicalSchedules");
        addButton.addEventListener("click", (event) => {
            j++
            event.preventDefault()
            const newC = document.createElement("div");
            newC.classList.add("schedule");
            newC.innerHTML = `
                <label for="time">Nhập thời gian bệnh</label>
                <input type="datetime-local" class="form-control" name="time">
                <label for="disease">Nhập nôi dung khám</label>
                <input type="text" class="form-control" name="detail">
                <label for="done${j}">Đã khỏi bệnh?</label> <br>
               <input type="radio" class="form-check-input mt-0" name="done${j}" value=true style="margin-left: 50px;">Có       
               <input type="radio" class="form-check-input mt-0" name="done${j}" value=false style="margin-left: 50px;">Không   
                <br><br>
            `;
            medicalSchedules.appendChild(newC);
            
        });   
    const submit = document.getElementById("submit");
        submit.addEventListener("click", (event) => {
            event.preventDefault()
        const patientId= document.getElementById("patientId").value
        const doctorId=sessionStorage.getItem("id")
        const major=document.getElementById("major").value
        const nameofDisease=document.getElementById("nameofDisease").value
        const PatientState=document.getElementById("patientState").value
        const date=document.getElementById("date").value
        var radios = document.getElementsByName('inProgress');
        let inProgress;
        for (const radio of radios) {
        if (radio.checked) {
        inProgress = radio.value;
        break;
    }
}
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
        var i=0
        C.forEach(element=>{
            i++
        const time = element.querySelector("[name='time']").value+":00";
        const detail = element.querySelector("[name='detail']").value;
        var radios = document.getElementsByName(`done${i}`);
        let done;
        for (const radio of radios) {
        if (radio.checked) {
        done = radio.value;
        break;
    }
}
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
                        alert("Đăng kí hồ sơ thất bại")
                    }
                })   
            }
            catch(error){
                alert("Lỗi: "+error)
            }
        }); 
}
function func6(){
    document.getElementById('section').innerHTML = `
    <h1 >Cập nhật tình trạng nhập viện của bệnh nhân</h1>     
    <form class="form-inline">
    <div>
    <label>Nhập mã hồ sơ nhập viện</label>
    <input id="hospitaladmissionId" type="text" class="form-control">
    <label>Nhập thời gian</label>
    <input id="hospitaladmissionDate" type="date" class="form-control">
    <label>Nhập tình trạng hiện tại của bệnh nhân</label>
    <input id="hospitaladmissionState" type="text" class="form-control">
    <button id="update" class="button" type="submit">Cập nhật</button>
    </div>
    </form>
        `
    document.getElementById("update").onclick=function(event){
        event.preventDefault()
        const token=sessionStorage.getItem("jwt")
        const hospitaladmissionId=document.getElementById("hospitaladmissionId").value
        const hospitaladmissionDate=document.getElementById("hospitaladmissionDate").value
        const hospitaladmissionState=document.getElementById("hospitaladmissionState").value
        fetch('http://localhost:8080/hospitaladmission/updatepatientstate/'+hospitaladmissionId,{
            method:"PUT",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            },
            body:JSON.stringify({date:hospitaladmissionDate,detail:hospitaladmissionState})
        })
        .then(response=>{
            if(response.ok){
                alert("Cập nhật thành công")
            }
            else{
                alert("Hồ sơ không tồn tại")
            }
        })
    }
}