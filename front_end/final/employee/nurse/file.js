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
        try{
        fetch('http://localhost:8080/profile/employee/nurse/getprofile/'+userId,{
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
    <h2 style="text-align:center">Cập nhật tình trạng nhập viện của bệnh nhân</h2>     
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
function func3(){
    document.getElementById('section').innerHTML = `
    <h1 id="pivot">Xem hồ sơ nhập viện</h1>
    <p id="inform">Đang tải dữ liệu vui lòng đợi trong giây lát <p>
    `;
    const userId=sessionStorage.getItem("id")
    const token= sessionStorage.getItem("jwt")
    try{
        fetch('http://localhost:8080/hospitaladmission/details/'+userId,{
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
                document.getElementById("inform").innerHTML=`Bạn hiện tại không quản lí phòng bệnh`
            }
        })
        .then(function(data){
            console.log(data)
            const pivot=document.getElementById("inform")
            if(data.length===0){
                document.getElementById("inform").innerHTML=`Bạn hiện tại không quản lí phòng bệnh`
            }
            else{
                document.getElementById("inform").innerHTML=``;
                var j=0;
            data.forEach(element => {
                j++
                var child= document.createElement("div")
                child.innerHTML=`
                <form >
                <div ><div>
                <label for="id">Mã hồ sơ</label>
                <div class="form-control">${element.id}</div>
                <label for="id">Nội dung</label>
                <div class="form-control">${element.detail}</div>
                <label for="id">Ngày nhập viện</label>
                <div class="form-control">${element.startDate}</div>
                <label for="id">Ngày xuất viện</label>
                <div class="form-control">${element.endDate}</div>
                <label for="id">Toa</label>
                <div class="form-control">${element.prescription}</div>
                <label for="id">Hoàn tất?</label>
                <div class="form-control">${element.done}</div>
                <label for="id">Số phòng</label>
                <div class="form-control">${element.room}</div>
                </div></div>

                <h2 for="id">Thông tin bác sĩ phụ trách</h2>
                <label for="id">Mã bác sĩ</label>
                <div class="form-control">${element.doctorInfo.id}</div>
                <label for="id">Số điện thoại</label>
                <div class="form-control">${element.doctorInfo.phone}</div>
                <label for="id">Họ và tên</label>
                <div class="form-control">${element.doctorInfo.name}</div>
                <label for="id">Tuổi</label>
                <div class="form-control">${element.doctorInfo.age}</div>
                <label for="id">Giới tính</label>
                <div class="form-control">${element.doctorInfo.gender}</div>
                <label for="id">Chuyên ngành</label>
                <div class="form-control">${element.doctorInfo.major}</div>
                <label for="id">Chức vụ</label>
                <div class="form-control">${element.doctorInfo.position}</div>
                <h2 >Tình trạng nhập viện</h2>
                <div id="patientStates${j}" class="form-control"></div>
                <h2>Hồ sơ khám bệnh</h2>
                <label for="id">Mã hồ sơ</label>
                <div class="form-control">${element.medicalDetail.id}</div>
                <label for="id">Chuyên ngành</label>
                <div class="form-control">${element.medicalDetail.major}</div>
                <label for="id">Chuẩn đoán</label>
                <div class="form-control">${element.medicalDetail.nameofDisease}</div>
                <label for="id">Trạng thái</label>
                <div class="form-control">${element.medicalDetail.inProgress}</div>
                <label for="id">Toa thuốc</label>
                <div class="form-control">${element.medicalDetail.prescription}</div>
                <label id="medicalSchedules${j}">Lịch khám đã đặt</label>
                <div id="No${j}" class="form-control">Không</div>
                <label>Ngày khám</label>
                <div class="form-control">${element.medicalDetail.date}</div>
                <label for="id">Trạng thái bệnh nhân</label>
                <div class="form-control">${element.medicalDetail.patientState}</div>
                <h2> Hồ sơ bệnh nhân</h2>
                <label for="id">Mã bệnh nhân</label>
                <div class="form-control">${element.patientInfo.id}</div>
                <label for="id">Số điện thoại</label>
                <div class="form-control">${element.patientInfo.phone}</div>
                <label for="id">Họ và Tên</label>
                <div class="form-control">${element.patientInfo.name}</div>
                <label for="id">Tuổi</label>
                <div class="form-control">${element.patientInfo.age}</div>
                <label for="id">Giới tính</label>
                <div class="form-control">${element.patientInfo.gender}</div>
                <label>Lịch sử khám chữa bệnh</label>
                <div id="medicalRecords${j}" class="form-control"></div>
                </form><br>
                `
                pivot.appendChild(child)
                element.patientInfo.medicalRecords.forEach(e=>{
                    var medicalRecords=document.getElementById(`medicalRecords${j}`)
                    var newMedicalRecords=document.createElement("div")
                    newMedicalRecords.innerHTML=`
                    <h4>Lịch sử khám bệnh</h4>
                    <label for="id">Tên bệnh</label>
                <div class="form-control">${e.name}</div>
                <label for="id">Thời gian chữa bệnh</label>
                <div class="form-control">${e.time}</div>
                <label for="id">Đã điều trị?</label>
                <div class="form-control">${e.treatment}</div>
                    `
                    medicalRecords.appendChild(newMedicalRecords)
                })
                if(element.patientStates.length>0){
                    var patientStates=document.getElementById(`patientStates${j}`)
                element.patientStates.forEach(e=>{
                    var newPatientStates=document.createElement("div")
                    newPatientStates.innerHTML=`
                    <label for="id">Tình trạng:</label>
                <div class="form-control">${e.detail}</div>
                <label for="id">Thời gian nhập viện</label>
                <div class="form-control">${e.date}</div>
                    `
                    patientStates.appendChild(newPatientStates)
                })  
            }
                if(element.medicalDetail.length>0){
                    document.getElementById(`No${j}`).innerHTML=``
                element.medicalDetail.medicalSchedules(e=>{
                    var medicalSchedules=document.getElementById("medicalSchedules")
                    var newMedicalSchedules=document.createElement("div")
                    newMedicalSchedules.innerHTML=`
                    `
                    medicalSchedules.appendChild(newMedicalSchedules)
                })
            }
            }); 
        }
        })
    }
    catch(error)
    {
        console.log("Lỗi:"+error)
    }
}