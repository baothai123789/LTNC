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
            if(response.ok){
            return response.json()
            }
            else{
                document.getElementById("inform").innerHTML=`<p>Không có hóa đơn nào</p>`
            }
        })
        .then(function(data){
            if(data.length===0)
                {
                    console.log("hello")
                    document.getElementById("inform").innerHTML=`<p>Không có hóa đơn nào</p>`
                }
                console.log("hello1")
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
    <h1 >Trả viện phí</h1>
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