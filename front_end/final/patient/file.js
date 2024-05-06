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
    <label for="id">Mã bệnh nhân</label>
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
    

    <label >Lịch sử bệnh án:</label><br>
    <div id="pivot"style="margin-left:50px;"></div>
    <button id="submit" class="button" type="">Chỉnh sửa</button>
    </form>
    `  
        var token= sessionStorage.getItem('jwt')
        var userId=sessionStorage.getItem('id')
        var PutData
        fetch('http://localhost:8080/profile/patient/getprofile/'+userId,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(function(response){
            if(response.ok){
            return response.json();
            }
            else{
                document.getElementById('section').innerHTML = `
                <br>
                <p style="text-align: center"> Không tìm thấy thông tin người dùng</p>
                `
            }
        })
        .then(function(data){
            document.getElementById('id').innerHTML=data.id;
            document.getElementById('name').value=data.name;
            document.getElementById('phone').value=data.phone;
            document.getElementById('gender').value=data.gender;
            document.getElementById( 'age').value=data.age;
            document.getElementById('street').value=data.address.street
            document.getElementById('town').value=data.address.town
            document.getElementById('province').value=data.address.province
            document.getElementById('nation').value=data.address.nation
            delete(data.id)
            PutData=data
            PutData = {
                ...PutData, // Giữ nguyên thuộc tính của PutData
                medicalRecords: []// Thêm thuộc tính medicalRecords
            };
            const tableBody = document.querySelector("#section #pivot");
            data.medicalRecordList.forEach(record=>{
                PutData.medicalRecords.push(record)
                const row = document.createElement("div");
                row.innerHTML = `
                <label>Thời gian bị bệnh:</label>
                    <div id="sicktime" type="date" class="form-control" name="medicalrecord.time" >${record.time}</div>
                    <label>Tên bệnh:</label>
                    <div id="disease"type="text" class="form-control" name="medicalrecord.name" >${record.name}</div>
                    <label>Đã được điều trị:</label>
                    <div id="treatmented" type="text" class="form-control" name="medicalrecord.treatment" >${record.treatment ? "Yes" : "No"}</div>
                    <br><br>
        `;
        console.log(PutData)
        tableBody.appendChild(row);
            }) 
        })
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
        // .....................................................................
            // Define the PUT request
            fetch('http://localhost:8080/profile/patient/editprofile/' + userId, {
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
    <h1>Hóa đơn</h1>  
    <div id="bill"></div>
    <p id="inform">Đang tải dữ liệu. Vui lòng đợi trong giây lát</p>
        `
    var userId= sessionStorage.getItem("id")
    var token= sessionStorage.getItem("jwt")
        try{
            fetch('http://localhost:8080/finance/getmedicalbill/patient/'+userId,{
                method:"GET",
                headers:{
                    "Content-Type":"application/json",
                    "Authorization":"Bearer "+token
                }
            })
            .then(function(response){
                if(response.ok){
                return response.json()
                }
                else{
                    document.getElementById("inform").innerHTML=`Không có hóa đơn trong hệ thống`
                }
            })
            .then(function(data){
                const pivot= document.getElementById('bill')
                if(data.length===0){
                    document.getElementById("inform").innerHTML=`Không có hóa đơn trong hệ thống`
                }
                else{
                    document.getElementById("inform").innerHTML=``
                }
                data.forEach(element => {
                    let newBill= document.createElement("form")
                    newBill.classList.add("form-inline")
                    newBill.innerHTML=`
                    <label>Mã hóa đơn</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.id}</div>
                    <label>Nôi dung</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.type}</div>
                    <label>Viện phí</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.totalPay}</div>
                    <label>Đã trả</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.paid ?'Đúng':'Chưa trả'}</div>
                    <label>Hạn trả</label>
                    <div  type="date" class="form-control" name="medicalrecord.treatment" >${element.hastopay}</div>
                    <h4>Vui lòng liên hệ nhân viên sau để thanh toán phí</h4>

                    `
                    let newEmployee= document.createElement("div")
                    newEmployee.innerHTML=`
                    <label>Mã nhân viên</label>
                    <div  type="text" class="form-control">${element.contactInfoDTO.id}</div>
                    <label>Họ và tên</label>
                    <div  type="text" class="form-control">${element.contactInfoDTO.name}</div>
                    <label>Số điện thoại</label>
                    <div  type="text" class="form-control">${element.contactInfoDTO.phone}</div>
                    <label>Giới tính</label>
                    <div  type="text" class="form-control">${element.contactInfoDTO.gender}</div>
                    <label>Tuổi</label>
                    <div  type="text" class="form-control">${element.contactInfoDTO.age}</div>
                    <label>Địa chỉ</label>
                    <div  type="text" class="form-control">${element.contactInfoDTO.address.street}-${element.contactInfoDTO.address.town}-${element.contactInfoDTO.address.province}-${element.contactInfoDTO.address.nation}</div>
                    <br>
                    `
                    newBill.appendChild(newEmployee)
                    pivot.appendChild(newBill)
                });
            })
        }
        catch(error){
            alert("Lỗi"+error)
        }
}
function func3(){
    document.getElementById('section').innerHTML=`
    <br>
    <h1>Hồ sơ khám bệnh</h1>  
    <div id="medicalRecords"></div>
    <p id="inform">Đang tải dữ liệu. Vui lòng đợi trong giây lát</p>
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
            if(response.ok){
            return response.json()
            }
            else{
                document.getElementById("inform").innerHTML=`Bạn hiện không có hồ sơ khám bệnh`
            }
        })
        .then(function(data){
            const pivot= document.getElementById('medicalRecords');
            if(data.length===0){
                document.getElementById("inform").innerHTML=`Bạn hiện không có hồ sơ khám bệnh`
            }
            else{
            document.getElementById("inform").innerHTML=''
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
                <h4>Thông tin bác sĩ:</h4>
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
        }
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
        <select id="major" class="form-select" name="position">
                <option  selected>....</option>
                <option value="ngoai_tong_hop">Ngoại tổng hợp</option>
                <option value="da_khoa">Đa khoa</option>
                <option value="khoa_noi">Khoa nội</option>
                <option value="khoa_phu_san">Khoa phụ sản</option>
                <option value="khoa_nhi">Khoa nhi</option>
                <option value="khoa_truyen_nhiem">Khoa truyền nhiễm</option>
            </select>  
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
    console.log(doctorId)
    console.log(id)
    console.log(date)
    console.log(startTime)
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