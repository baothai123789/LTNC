document.querySelector('.menu-toggle').onclick = function() {
    var nav = document.querySelector('#nav1');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
    }
    var usr=sessionStorage.getItem('jwt');
    console.log(usr);
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
    <label for="id">Mã bệnh nhân</label>
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

    <label >Lịch sử bệnh án:</label><br><br>     
    <div id="pivot" id="pivot1" style="margin-left:50px;"></div>
    </form>
    `
        var token= sessionStorage.getItem('jwt')
        var userId=sessionStorage.getItem('id')
        try{
        fetch('http://localhost:8080/profile/patient/getprofile/'+userId,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            document.getElementById('id').innerText=data.id;
            console.log(data.id)
            document.getElementById('name').innerText=data.name;
            document.getElementById('phone').innerText=data.phone;
            document.getElementById('gender').innerText=data.gender;
            document.getElementById( 'age').innerText=data.age;
            document.getElementById('address').innerHTML=data.address.street+"-"+
            data.address.town+"-"+data.address.province+"-"+data.address.town
            const medical= data.medicalRecordList;
    
            const tableBody = document.querySelector("#section #pivot");
            medical.forEach(record=>{
                const row = document.createElement("div");
                row.innerHTML = `
                <label>Thời gian bị bệnh:</label>
                    <div id="sicktime" type="date" class="form-control" name="medicalrecord.time" >${record.name}</div>
                    <label>Tên bệnh:</label>
                    <div id="disease"type="text" class="form-control" name="medicalrecord.name" >${record.time}</div>
                    <label>Đã được điều trị:</label>
                    <div id="treatmented" type="text" class="form-control" name="medicalrecord.treatment" >${record.treatment ? "Yes" : "No"}</div>
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
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1>Chỉnh sửa thông tin</h1>     
    <form class="form-inline">
    <div id="benhnhanInfo"></div>
    </form>
        `
        var benhnhan = 
            { id: 1, name: 'AAA', gender: 'Nam', phone: 'A', age: 15, address: 'A',medicalrecord:{time:"2020-02-02",name:'aa',treament:'aaaaa'} };

        // Function to display benhnhan information
        function displaybenhnhanInfo() {
            const benhnhanInfo = document.getElementById('benhnhanInfo');
            benhnhanInfo.innerHTML = '';

            const benhnhanElement = document.createElement('div');
                benhnhanElement.innerHTML = `
                        <label for="name">Họ và tên:</label>
                        <input type="text" class="form-control" name="name" value=${benhnhan.name}>
                        <label for="gender">Giới tính:</label>
                        <input type="text" class="form-control" name="gender" value=${benhnhan.gender}>
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" class="form-control" name="phone" value=${benhnhan.phone}>
                        <label for="age">Tuổi:</label>
                        <input type="number" class="form-control" name="age" value=${benhnhan.age}>
                        <label for="address">Địa chỉ:</label>
                        <input type="text" class="form-control" name="address" value=${benhnhan.address}>
                        <br>                      
                        <button class="button" type="submit">Sửa thông tin</button>     
                        <br><br>   
                `;
                benhnhanInfo.appendChild(benhnhanElement);
        }
        displaybenhnhanInfo();
    
}
function func3(){
    document.getElementById('section').innerHTML=`
    <br>
    <h1>Hồ sơ khám bệnh</h1>  
    <div id="medicalRecords"></div>
    `;
    var userId= sessionStorage.getItem("id")
    var token= sessionStorage.getItem("jwt")
    try{
        fetch('http://localhost:8080/medicaldetail/getmedicaldetail/patient/'+userId,{
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
                var doctor=document.createElement("div")
                doctor.innerHTML=`
                <label>Thông tin bác sĩ:</label>
                <label>Mã số bác sĩ</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.id}</div>
                <label>Số điện thoại</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.phone}</div>
                    <label>Họ và tên bác sĩ</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.name}</div>
                    <label>Tuổi</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.age}</div>
                    <label>Giới tính</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.gender}</div>
                    <label>Chuyên ngành</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.major}</div>
                    <label>Vai trò</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.doctorInfo.position}</div>    
                    <br>
                `
                newMedicalRecord.appendChild(doctor)
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
function func4() {
    document.getElementById('section').innerHTML = `
    <br>
    <h1> Đặt lịch khám bệnh</h1>
    <br>
    <form class="form-inline">
        <label for="DoctorId">Nhập khoa khám bệnh</label>
        <input id="major" type="text" class="form-control" name="DoctorId">
        <label for="date">Nhập ngày khám bệnh</label>
        <input id="date" type="date" class="form-control" name="date">
        <br>
        <button id="submit" class="button" type="submit">Đặt lịch</button>
        <br><br>
        <div id="appendChild">
        </div>
    </form>                       
    `
    const button = document.getElementById('submit');
    button.addEventListener("click", (event) => {
    event.preventDefault();
    const id = sessionStorage.getItem('id');
    const token = sessionStorage.getItem('jwt');
    const major = document.getElementById('major').value;
    const date = document.getElementById('date').value;
    sessionStorage.setItem("date",date)
    console.log(id);
    console.log(token);
    fetch(`http://localhost:8080/schedule/getdoctorschedule/${major}/${date}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            // Xử lý trường hợp phản hồi không thành công
            throw new Error('Network response was not ok.');
        }
    })
    .then(data => {
        // Giả sử data là đối tượng JSON chứa thông tin bạn cần
        data.forEach(element => {
            const add_doctor=document.getElementById('appendChild')
            const newDoctor= document.createElement('div')
            newDoctor.innerHTML=`
            <label>Thông tin bác sĩ</label><br>
            <label>Mã bác sĩ</label>
            <div type="text" class="form-control">${element.doctorInfo.id}</div>
            <label>Số điện thoại</label>
            <div type="text" class="form-control">${element.doctorInfo.phone}</div>
            <label>Họ và tên</label>
            <div type="text" class="form-control">${element.doctorInfo.name}</div>
            <label>Tuổi</label>
            <div type="text" class="form-control">${element.doctorInfo.age}</div>
            <label>Giới tính</label>
            <div type="text" class="form-control">${element.doctorInfo.gender}</div>
            <label>Chuyên khoa</label>
            <div type="text" class="form-control">${element.doctorInfo.major}</div>
            <label>Chức vụ</label>
            <div type="text" class="form-control">${element.doctorInfo.position}</div>
            `
            add_doctor.appendChild(newDoctor)
            element.doctorScheduleDTOs.forEach(e => {
  let newE = document.createElement('div');
  newE.innerHTML = `<button type="button" onclick="func('${e.startTime}','${element.doctorInfo.id}')"> ${e.startTime}-${e.endTime}</button>`;
  add_doctor.appendChild(newE);
});
});
    })
    .catch(error => {
        alert('Lỗi: ' + error);
    });
});
}

function func(startTime,doctorId) {
    var date=sessionStorage.getItem("date")
    var id = sessionStorage.getItem('id');
    var token = sessionStorage.getItem('jwt');
    var data={
      "doctorId": doctorId,
      "patientId": id,
      "date": date,
      "startTime": startTime
    }
    console.log(data)
    // event.preventDefault();
  fetch(`http://localhost:8080/schedule/createschedule`, {
    method: 'POST',
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`
    },
    body: JSON.stringify({
      "doctorId": doctorId,
      "patientId": id,
      "date": date,
      "startTime": startTime
    })
  })
  .then(response => {
    if (response.ok) {
        alert("Đặt lịch thành công")
        location.reload()
    }
  })
  .catch(error => {
    console.error('Có lỗi xảy ra khi tạo lịch:', error);
  });
}