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
        fetch('http://localhost:8080/profile/employee/financialemployee/getprofile/'+userId,{
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
    <h1>Hóa đơn </h1>
    <div id="medicalRecords"></div>
    <p id="inform">Đang tải dữ liệu xin đợi trong giây lát</p>
    `
    var userId= sessionStorage.getItem("id")
    var token= sessionStorage.getItem("jwt")
    try{
        fetch('http://localhost:8080/finance/getmedicalbill/'+userId+'/false',{
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
                var pivot2=document.createElement("form")
                pivot2.classList.add("form-inline")
                pivot2.innerHTML=`
                    <h2>Hóa đơn</h2>
                    <label>Mã hóa đơn</label>
                    <div  type="text" class="form-control" name="medicalrecord.name" >${element.id}</div>
                    <label>Loại</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.type}</div>
                    <label>Viện phí</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.medicalFee}</div>
                    <label>Hạn nộp</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.hastopay}</div>
                    <button onclick="func('${element.id}')" class="button" type="button">Thanh toán</button>
                    <!--  <h2>Liên hệ nhân viên</h2>
                    <label>Mã số</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.contactInfoDTO.id}</div>
                    <label>Họ và tên</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.contactInfoDTO.name}</div>
                    <label>Số điện thoại</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.contactInfoDTO.phone}</div>
                    <label>Giới tính</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.contactInfoDTO.gender}</div>
                    <label>Tuổi</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.contactInfoDTO.age}</div>
                    <label>Địa chỉ</label>
                    <div  type="text" class="form-control" name="medicalrecord.treatment" >${element.contactInfoDTO.address.street}-${element.contactInfoDTO.address.town}-${element.contactInfoDTO.address.province}-${element.contactInfoDTO.address.nation}</div>
                -->  
                ` 
                pivot.appendChild(pivot2)
                document.getElementById("inform").innerHTML=``
            });
            
            
        })
    }
    catch(error){
        alert("Lỗi"+error)
    }
}
function func3(){
    document.getElementById('section').innerHTML=`
    <h1>Trả viện phí</h1>
    <form class="form-inline">
        <label for="bill" >Nhập mã hóa đơn</label>
        <input id="BillId" type="text" class="form-control" name="bill">
        <button id="submit" class="button" type="submit">Submit</button>
        <br>
        </form>`
  
    document.getElementById("submit").addEventListener('click',(event)=>{
        event.preventDefault()
        const BillId= document.getElementById("BillId").value
        const token = sessionStorage.getItem('jwt')
    try{
        fetch('http://localhost:8080/finance/paybill/'+BillId,{
            method:"PUT",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(response=>{
            return response.json()
        })
        .then(data=>{
            if(data.message==="success")
            alert("Thanh toán thành công")
        else{
            alert("Thanh toán thất bại")
        }
        })
    }
    catch(error){
        alert("Lỗi"+error)
    }
})
}
function func(BillId){
        const token = sessionStorage.getItem('jwt')
    try{
        fetch('http://localhost:8080/finance/paybill/'+BillId,{
            method:"PUT",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(response=>{
            return response.json()
        })
        .then(data=>{
            if(data.message==="success")
           { alert("Thanh toán thành công")
        }
        else{
            alert("Thanh toán thất bại")
        }
        })
    }
    catch(error){
        alert("Lỗi"+error)
    }
}