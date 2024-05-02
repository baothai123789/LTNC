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
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1>Chỉnh sửa thông tin</h1>     
    <form class="form-inline">
    <div id="nhanvienInfo"></div>
    </form>
        `
        var nhanvien = 
            { id: 1, name: 'AAA', gender: 'Nam', phone: 'A', age: 15, address: 'A',role:'doctor',part:'medicalemployee',workForm:"2022-03-04",Position:'a',Certificate:{department:'a',time:'3/2/2022',major:'a'} };

        // Function to display nhanvien information
        function displaynhanvienInfo() {
            const nhanvienInfo = document.getElementById('nhanvienInfo');
            nhanvienInfo.innerHTML = '';

            const nhanvienElement = document.createElement('div');
                nhanvienElement.innerHTML = `
                        <label for="name">Họ và tên:</label>
                        <input type="text" class="form-control" name="name" value=${nhanvien.name}>
                        <label for="gender">Giới tính:</label>
                        <input type="text" class="form-control" name="gender" value=${nhanvien.gender}>
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" class="form-control" name="phone" value=${nhanvien.phone}>
                        <label for="age">Tuổi:</label>
                        <input type="number" class="form-control" name="age" value=${nhanvien.age}>
                        <label for="address">Địa chỉ:</label>
                        <input type="text" class="form-control" name="address" value=${nhanvien.address}>
                        <label for="role">Vai trò:</label>
                        <select class="form-select" name="role">
                            <option selected>...</option>
                            <option value="doctor">Bác sĩ</option>
                            <option value="nurse">Y tá</option>
                            <option value="functionalemployee">Nhân viên chức năng</option>
                        </select>                        
                        <label for="part">Bộ phận:</label>
                        <select class="form-select" name="part">
                            <option selected>...</option>
                            <option value="medicalemployee">Nhân viên y tế</option>
                            <option value="financialemployee">Nhân viên tài chính</option>
                            <option value="pharmacymanager">Nhân viên quản lý thuốc</option>
                            
                        </select>
                        
                        <label for="workFrom">Ngày bắt đầu làm việc:</label>
                        <input type="date" class="form-control" name="workFrom" value=${nhanvien.workForm}>
                        <label for="Position">Chức vụ:</label>
                        <input type="text" class="form-control" name="Position" value=${nhanvien.Position}> 
                        <br>                     
                        <button class="button" type="submit">Sửa thông tin</button>  
                        <br><br>
                `;
                nhanvienInfo.appendChild(nhanvienElement);
        }
            displaynhanvienInfo();
}
function func3(){
    document.getElementById('section').innerHTML = `
    <h1 id="pivot">Quản lí phòng khám</h1>
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
            return response.json()
        })
        .then(function(data){
            console.log(data)
            const pivot=document.getElementById("pivot")
            data.forEach(element => {
                var child= document.createElement("form")
                child.classList.add("form-inline")
                child.innerHTML=`
                <label for="id">Mã hồ sơ</label>
                <div class="form-control">${element.id}</div>
                <label for="id">Hồ sơ</label>
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
                <label for="id">Thông tin bác sĩ</label>
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
                <label id="patientStates">Tình trạng nhập viện</label>
                <label>Hồ sơ khám bệnh</label>
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
                <label id="medicalSchedules">Đặt lịch khám</label>
                <label>Ngày khám</label>
                <div class="form-control">${element.medicalDetail.date}</div>
                <label for="id">Trạng thái bệnh nhân</label>
                <div class="form-control">${element.medicalDetail.patientState}</div>
                <label> Hồ sơ bệnh nhân</label>
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
                <label id="medicalRecords">Lịch sử khám chữa bệnh</label>
                `
                pivot.appendChild(child)
                element.patientInfo.medicalRecords.forEach(e=>{
                    var medicalRecords=document.getElementById("medicalRecords")
                    var newMedicalRecords=document.createElement("div")
                    newMedicalRecords.innerHTML=`
                    <label for="id">Tên bệnh</label>
                <div class="form-control">${e.name}</div>
                <label for="id">Thời gian chữa bệnh</label>
                <div class="form-control">${e.time}</div>
                <label for="id">Đã điều trị?</label>
                <div class="form-control">${e.treatment}</div>
                    `
                    medicalRecords.appendChild(newMedicalRecords)
                })
                element.patientStates.forEach(e=>{
                    var patientStates=document.getElementById("patientStates")
                    var newPatientStates=document.createElement("div")
                    newPatientStates.innerHTML=`
                    <label for="id">Tình trạng:</label>
                <div class="form-control">${e.detail}</div>
                <label for="id">Thời gian nhập viện</label>
                <div class="form-control">${e.date}</div>
                    `
                    patientStates.appendChild(newPatientStates)
                })
                // element.medicalDetail.medicalSchedules(e=>{
                //     var medicalSchedules=document.getElementById("medicalSchedules")
                //     var newMedicalSchedules=document.createElement("div")
                //     newMedicalSchedules.innerHTML=`
                //     `
                //     medicalSchedules.appendChild(newMedicalSchedules)
                // })
                
            }); 
        })
    }
    catch(error)
    {
        console.log("Lỗi:"+error)
    }
}